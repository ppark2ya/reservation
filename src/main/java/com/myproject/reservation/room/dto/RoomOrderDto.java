package com.myproject.reservation.room.dto;

/*
 *  room_seq number		-- 객실 번호(fk
 *  resv_date date		-- 모든 날짜(1년)
 *  resv_yn				-- 객실 예약 가능 유무
 */
public class RoomOrderDto {
	private int roomSeq;
	private String resvDate;
	private String resvYn;

	public RoomOrderDto(){}

	public RoomOrderDto(int roomSeq, String resvDate, String resvYn) {
		super();
		this.roomSeq = roomSeq;
		this.resvDate = resvDate;
		this.resvYn = resvYn;
	}

	public int getRoomSeq() {
		return roomSeq;
	}

	public void setRoomSeq(int roomSeq) {
		this.roomSeq = roomSeq;
	}

	public String getResvDate() {
		return resvDate;
	}

	public void setResvDate(String resvDate) {
		this.resvDate = resvDate;
	}

	public String getResvYn() {
		return resvYn;
	}

	public void setResvYn(String resvYn) {
		this.resvYn = resvYn;
	}


}
