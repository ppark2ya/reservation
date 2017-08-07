create table customer(
	id		varchar2(30) primary key,	-- 고객 아이디(pk)
	pwd		varchar2(100) not null,		-- 고객 비밀번호
	name	varchar2(30) not null,		-- 고객 이름
	phone	varchar2(50) not null,		-- 고객 전화번호
	email	varchar2(50) not null,		-- 고객 이메일
	regdate	date not null				-- 가입 일자
);

create table board(
	board_seq	number primary key, 	-- 게시판 번호
	writer		varchar2(30) references customer(id) not null,	-- 고객 아이디(fk)
	title		varchar2(100) not null,	-- 글 제목
	category	varchar2(30) not null,	-- 글 카테고리
	content		clob,					-- 글 내용
    viewCount   number,					-- 조회수
	regdate		date not null			-- 글 작성일
);

create table board_comment(
	board_seq	number primary key,
	writer		varchar2(30) references customer(id) not null,
	content		varchar2(500),
	target_id	varchar2(100),
	ref_group	number,
	comment_group number,
	regdate		date
);

create sequence room_seq;
create table room(
    room_seq    number primary key,		-- 객실 고유 번호(pk)
    room_name   varchar2(20) not null,	-- 객실 이름
    room_charge number not null,		-- 객실 요금
   	room_desc	varchar2(500),			-- 객실 설명
    avail_guest number not null,		-- 이용가능 인원
    smoking_yn     char(2) not null,		-- 흡연가능여부(y/n)
    bathamenity_yn char(2) not null,		-- 세면용품 구비여부(y/n)
    wififree_yn   char(2) not null,		-- 무료 와이파이여부(y/n)
    breakfast_yn	char(2)					-- 조식 포함 여부(y/n)
);
-- 방 목록들
insert into room values(room_seq.NEXTVAL,'c101',82000,'',2,'n','n','n','n');
insert into room values(room_seq.NEXTVAL,'c102',82000,'',2,'n','n','n','n');
insert into room values(room_seq.NEXTVAL,'c103',82000,'',2,'n','n','n','n');
insert into room values(room_seq.NEXTVAL,'c104',82000,'',2,'n','n','n','n');
insert into room values(room_seq.NEXTVAL,'c105',82000,'',2,'n','n','n','n');
insert into room values(room_seq.NEXTVAL,'c106',89000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'c107',89000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'c108',89000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'c109',89000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'c110',89000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'c201',95000,'',2,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'c202',95000,'',2,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'c203',95000,'',2,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'c204',95000,'',2,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'c205',95000,'',2,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p206',210000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p207',210000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p208',210000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p209',210000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p210',210000,'',2,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p301',280000,'',3,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p302',280000,'',3,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p303',280000,'',3,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p304',280000,'',3,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p305',300000,'',3,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p306',300000,'',3,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p307',300000,'',3,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p308',300000,'',3,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p309',300000,'',3,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p401',350000,'',4,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p402',350000,'',4,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p403',350000,'',4,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p404',350000,'',4,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p405',350000,'',4,'n','y','y','n');
insert into room values(room_seq.NEXTVAL,'p406',400000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p407',400000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p408',400000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p501',450000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p502',450000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p503',450000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p504',450000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p505',450000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p506',450000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p507',450000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'p508',450000,'',4,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'s1',897000,'',6,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'s2',980000,'',6,'n','y','y','y');
insert into room values(room_seq.NEXTVAL,'s3',1290000,'',6,'n','y','y','y');

-- 객실 예약 가능 여부를 저장하는 테이블
create table room_order(
	room_seq number references room(room_seq),	-- 객실 고유번호(fk)
	resv_date date,							-- 모든 날짜(1년치)
	resv_yn char(2)							-- 객실 사용가능 여부(y면 사용 가능)
);
-- 지금날짜로부터 1년치의 모든 객실 예약 데이터 insert
declare
begin
    for i in 1..48 loop
        for j in 1..365 loop
            insert into room_order values(i,sysdate+j,'y');
        end loop;
    end loop;
end;
select * from room_order order by room_seq asc, resv_date asc;

create sequence rv_seq;
create table reservation(
    rv_seq     number primary key,		-- 예약 번호(pk)
    id     		varchar2(30),	-- 고객 아이디(fk)
    room_seq	number,			-- 객실 고유 번호(fk)
    checkin     varchar2(30),	-- 체크인 날짜
    checkout    varchar2(30),	-- 체크아웃 날짜
    amount      number,			-- 결제 요금
    payment     varchar2(10),	-- 결제 수단(cash/card)
    numof_rooms number,			-- 현재 남은 보유 객실 수
    numof_rvcust number			-- 예약 인원
);

ALTER TABLE reservation
ADD CONSTRAINT fk_cust_id FOREIGN KEY(id)
REFERENCES customer(id);

ALTER TABLE reservation
ADD CONSTRAINT fk_room_num FOREIGN KEY(roomSeq)
REFERENCES room(roomSeq);

create table grade(
    room_grade  varchar2(20),			-- 객실 등급(cheap, popular, luxury)
    lowest      number,					-- 최저 금액
    highest     number					-- 최고 금액
);

insert into grade values('cheap', 80000, 100000);
insert into grade values('popular', 200000, 450000);
insert into grade values('luxury', 800000, 1300000);

-- imgsrc 에 저장되어있는 경로를 통해 <img src=""> 에 출력
CREATE TABLE room_image(
	img_seq		NUMBER	PRIMARY KEY,
	room_seq	number	references room(room_seq),
	imgsrc		VARCHAR2(100) NOT NULL,
	regdate		DATE
);

CREATE SEQUENCE image_seq;
