package com.myproject.reservation.room.dao;

import java.util.List;

import com.myproject.reservation.room.dto.RoomDto;

public interface RoomDao {
	public List<RoomDto> selRoomList(RoomDto dto);
}
