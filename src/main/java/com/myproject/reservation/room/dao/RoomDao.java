package com.myproject.reservation.room.dao;

import java.util.List;

import com.myproject.reservation.room.dto.RoomDto;

public interface RoomDao {
	public List<RoomDto> selRoomListAsc(RoomDto dto);
	public List<RoomDto> selCheapListAsc(RoomDto dto);
	public List<RoomDto> selPopListAsc(RoomDto dto);
	public List<RoomDto> selLuxeListAsc(RoomDto dto);
	public int getCount();
}
