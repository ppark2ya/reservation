package com.myproject.reservation.room.dto;
/*
 *  room_seq    	number primary key,		-- 객실 고유 번호(pk)
    room_name   	varchar2(20) not null,	-- 객실 이름
    room_charge 	number not null,		-- 객실 요금
    room_desc		varchar2(500)			-- 객실 설명
    avail_guest 	number not null,		-- 이용가능 인원
    smoking_yn  	char(2) not null,		-- 흡연가능여부(y/n)
    bathamenity_yn 	char(2) not null,		-- 세면용품 구비여부(y/n)
    wififree_yn   	char(2) not null,		-- 무료 와이파이여부(y/n)
    breakfast_yn	char(2)					-- 조식 포함 여부(y/n)
 */
public class RoomDto {
	private int roomSeq;
	private String roomName;
	private int roomCharge;
	private String roomDesc;
	private int availGuest;
	private String smokingYn;
	private String bathAmenityYn;
	private String wifiFreeYn;
	private String breakfastYn;

	private String checkIn;
	private String checkOut;

	public RoomDto(){}

	public RoomDto(int roomSeq, String roomName, int roomCharge, String roomDesc, int availGuest, String smokingYn,
			String bathAmenityYn, String wifiFreeYn, String breakfastYn, String checkIn, String checkOut) {
		super();
		this.roomSeq = roomSeq;
		this.roomName = roomName;
		this.roomCharge = roomCharge;
		this.roomDesc = roomDesc;
		this.availGuest = availGuest;
		this.smokingYn = smokingYn;
		this.bathAmenityYn = bathAmenityYn;
		this.wifiFreeYn = wifiFreeYn;
		this.breakfastYn = breakfastYn;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomSeq() {
		return roomSeq;
	}

	public void setRoomSeq(int roomSeq) {
		this.roomSeq = roomSeq;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomCharge() {
		return roomCharge;
	}

	public void setRoomCharge(int roomCharge) {
		this.roomCharge = roomCharge;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public int getAvailGuest() {
		return availGuest;
	}

	public void setAvailGuest(int availGuest) {
		this.availGuest = availGuest;
	}

	public String getSmokingYn() {
		return smokingYn;
	}

	public void setSmokingYn(String smokingYn) {
		this.smokingYn = smokingYn;
	}

	public String getBathAmenityYn() {
		return bathAmenityYn;
	}

	public void setBathAmenityYn(String bathAmenityYn) {
		this.bathAmenityYn = bathAmenityYn;
	}

	public String getWifiFreeYn() {
		return wifiFreeYn;
	}

	public void setWifiFreeYn(String wifiFreeYn) {
		this.wifiFreeYn = wifiFreeYn;
	}

	public String getBreakfastYn() {
		return breakfastYn;
	}

	public void setBreakfastYn(String breakfastYn) {
		this.breakfastYn = breakfastYn;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}



}
