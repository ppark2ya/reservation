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
	private int room_num;
	private String room_name;
	private int room_charge;
	private String checkOut;	
	private int avail_guest;
	private String smoking;
	private String bath_amenity;
	private String wifi_free;
	private String breakfast;
	
	public RoomDto(){}

	public RoomDto(int room_num, String room_name, int room_charge, int avail_guest, String smoking,
			String bath_amenity, String wifi_free, String breakfast, String checkOut) {
		super();
		this.room_num = room_num;
		this.room_name = room_name;
		this.room_charge = room_charge;
		this.avail_guest = avail_guest;
		this.smoking = smoking;
		this.bath_amenity = bath_amenity;
		this.wifi_free = wifi_free;
		this.breakfast = breakfast;
		this.checkOut = checkOut;
	}

	public int getRoom_num() {
		return room_num;
	}

	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getRoom_charge() {
		return room_charge;
	}

	public void setRoom_charge(int room_charge) {
		this.room_charge = room_charge;
	}

	public int getAvail_guest() {
		return avail_guest;
	}

	public void setAvail_guest(int avail_guest) {
		this.avail_guest = avail_guest;
	}

	public String getSmoking() {
		return smoking;
	}

	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}

	public String getBath_amenity() {
		return bath_amenity;
	}

	public void setBath_amenity(String bath_amenity) {
		this.bath_amenity = bath_amenity;
	}

	public String getWifi_free() {
		return wifi_free;
	}

	public void setWifi_free(String wifi_free) {
		this.wifi_free = wifi_free;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	
}
