package com.myproject.reservation.room;
/*
 *  room_num    number primary key,		-- 객실 고유 번호(pk)
    room_name   varchar2(20) not null,	-- 객실 이름
    room_charge number not null,		-- 객실 요금 
    avail_guest number not null,		-- 이용가능 인원
    smoking     char(2) not null,		-- 흡연가능여부(y/n)
    bath_amenity char(2) not null,		-- 세면용품 구비여부(y/n)
    wifi_free   char(2) not null,		-- 무료 와이파이여부(y/n)
    breakfast	char(2)					-- 조식 포함 여부(y/n)
 */
public class RoomDto {
	private int roomSeq;
	private String roomName;
	private int roomCharge;
	private String checkOut;	
	private int availGuest;
	private String smoking;
	private String bathAmenity;
	private String wifiFree;
	private String breakfast;
	
	public RoomDto(){}

	public RoomDto(int roomSeq, String roomName, int roomCharge, String checkOut, int availGuest, String smoking,
			String bathAmenity, String wifiFree, String breakfast) {
		super();
		this.roomSeq = roomSeq;
		this.roomName = roomName;
		this.roomCharge = roomCharge;
		this.checkOut = checkOut;
		this.availGuest = availGuest;
		this.smoking = smoking;
		this.bathAmenity = bathAmenity;
		this.wifiFree = wifiFree;
		this.breakfast = breakfast;
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

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getAvailGuest() {
		return availGuest;
	}

	public void setAvailGuest(int availGuest) {
		this.availGuest = availGuest;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getBathAmenity() {
		return bathAmenity;
	}

	public void setBathAmenity(String bathAmenity) {
		this.bathAmenity = bathAmenity;
	}

	public String getWifiFree() {
		return wifiFree;
	}

	public void setWifiFree(String wifiFree) {
		this.wifiFree = wifiFree;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	
}
