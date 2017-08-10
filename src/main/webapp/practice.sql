-- 특정 날짜의 상태값만 update 시키기
UPDATE ROOM_ORDER
SET RESV_YN='y'
WHERE RESV_DATE IN(
        SELECT  RESV_DATE
        FROM(   SELECT  *
                FROM ROOM
                JOIN ROOM_ORDER USING(ROOM_SEQ)
                WHERE RESV_DATE BETWEEN TO_DATE('2017.08.07', 'YYYY.MM.DD') AND TO_DATE('2017.08.10', 'YYYY.MM.DD'))
                WHERE RESV_DATE LIKE '17/08/08'
);

-- checkIn 날짜부터 checkOut 까지 예약상태가 y인 테이블 리턴
SELECT *
FROM
	(
		SELECT
				room_seq AS roomSeq,
				room_name AS roomName,
				room_charge AS roomCharge,
				room_desc AS roomDesc,
				avail_guest AS availGuest,
				smoking_yn AS smokingYn,
				bathAmenity_yn AS bathAmenityYn,
				wififree_yn AS wifiFreeYn,
				breakfast_yn AS breakfastYn,
				resv_date AS resvDate,
				resv_yn AS resvYn
		FROM
				room
		JOIN
				room_order USING (room_seq)
		WHERE
				resv_date
		BETWEEN
				TO_DATE(#{checkIn}, 'yyyy.mm.dd')
		AND
				TO_DATE(#{checkOut}, 'yyyy.mm.dd')
		AND
				resv_yn = 'y'
);

-- 입력한 체크인 체크아웃 날짜에 대해서 예약 가능한 방의 목록 리턴
SELECT
		room_seq AS roomSeq,
        room_name AS roomName,
        room_charge AS roomCharge,
        room_desc AS roomDesc,
        avail_guest AS availGuest,
        smoking_yn AS smokingYn,
        bathAmenity_yn AS bathAmenityYn,
        wififree_yn AS wifiFreeYn,
        breakfast_yn AS breakfastYn
FROM
		room
WHERE
		room_seq
IN
		(SELECT roomSeq
		FROM
		    (SELECT
		            room_seq AS roomSeq,
		            count(*) as count
		    FROM
		            room
		    JOIN
		            room_order USING (room_seq)
		    WHERE
		            resv_date
		    BETWEEN
		            TO_DATE('2017.08.09', 'yyyy.mm.dd')
		    AND
		            TO_DATE('2017.08.11', 'yyyy.mm.dd')
		    AND
		            resv_yn = 'y'
		    GROUP BY
		            room_seq
		    HAVING
		            count(*) >= TO_DATE('2017.08.11', 'yyyy.mm.dd') - TO_DATE('2017.08.09', 'yyyy.mm.dd')
		    ORDER BY
		            room_seq
		    )
		)
ORDER BY
		roomSeq;

-- rownum 으로 정해진 갯수 만큼의 row 만 select 하기
-- order by 의 실행순서는 가장 마지막이기 때문에 먼저 테이블을 정렬하고
-- 정렬된 테이블에 대해서 rownum 으로 원하는 row 만큼 select 한다.
SELECT *
FROM
    (SELECT
        room_seq AS roomSeq,
        room_name AS roomName,
        room_charge AS roomCharge,
        room_desc AS roomDesc,
        avail_guest AS availGuest,
        smoking_yn AS smokingYn,
        bathAmenity_yn AS bathAmenityYn,
        wififree_yn AS wifiFreeYn,
        breakfast_yn AS breakfastYn
    FROM
        room
    WHERE
        room_seq
    IN
        (SELECT room_seq
        FROM
            (SELECT
                    room_seq,
                    count(*)
            FROM
                    room
            JOIN
                    room_order USING (room_seq)
            JOIN
                    grade ON (room_charge BETWEEN lowest AND highest)
            WHERE
                    resv_date
            BETWEEN
                    TO_DATE('2017.08.12', 'yyyy.mm.dd')
            AND
                    TO_DATE('2017.08.15', 'yyyy.mm.dd')
            AND
                    resv_yn = 'y'
            GROUP BY
                    room_seq
            HAVING
                 count(*) >= (TO_DATE('2017.08.15', 'yyyy.mm.dd') - TO_DATE('2017.08.12', 'yyyy.mm.dd'))
            )
        )
    ORDER BY roomCharge ASC, roomSeq ASC)
WHERE ROWNUM <= 10;

------------------ rownum 5~20 까지의 데이터 추출하기
SELECT
		room_seq AS roomSeq,
	    room_name AS roomName,
	    room_charge AS roomCharge,
	    room_desc AS roomDesc,
	    avail_guest AS availGuest,
	    smoking_yn AS smokingYn,
	    bathAmenity_yn AS bathAmenityYn,
	    wififree_yn AS wifiFreeYn,
	    breakfast_yn AS breakfastYn
	FROM
		(SELECT selRooms.*,
				ROWNUM AS rnum
		FROM
			(SELECT
				*
			FROM
				room
			WHERE
				room_seq
			IN
				(SELECT room_seq
				FROM
				    (SELECT
				            room_seq
				    FROM
				            room
				    JOIN
				            room_order USING (room_seq)
				    WHERE
				            resv_date
				    BETWEEN
				            TO_DATE(#{checkIn}, 'yyyy.mm.dd')
				    AND
				            TO_DATE(#{checkOut}, 'yyyy.mm.dd')
				    AND
				            resv_yn = 'y'
				    GROUP BY
				            room_seq
				    HAVING
				    		count(*) >= (TO_DATE(#{checkOut}, 'yyyy.mm.dd') - TO_DATE(#{checkIn}, 'yyyy.mm.dd'))
				    )
				)
			ORDER BY room_charge DESC, room_seq DESC) selRooms)
	WHERE
		rnum BETWEEN 5 AND 20