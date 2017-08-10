package com.myproject.reservation.room.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.reservation.room.dto.RoomDto;

@Repository
public class RoomDaoImpl implements RoomDao{

	@Autowired
	private SqlSession session;

	@Override
	public List<RoomDto> selRoomListAsc(RoomDto dto) {
		List<RoomDto> rooms = session.selectList("room.selRoomListAsc", dto);
		return rooms;
	}

//	@Override
//	public List<RoomDto> scrollDownListAsc(RoomDto dto) {
//		List<RoomDto> rooms = session.selectList("room.scrollDownListAsc", dto);
//		return rooms;
//	}

	@Override
	public List<RoomDto> selCheapListAsc(RoomDto dto) {
		List<RoomDto> rooms = session.selectList("room.selCheapListAsc", dto);
		return rooms;
	}

	@Override
	public List<RoomDto> selPopListAsc(RoomDto dto) {
		List<RoomDto> rooms = session.selectList("room.selPopListAsc", dto);
		return rooms;
	}

	@Override
	public List<RoomDto> selLuxeListAsc(RoomDto dto) {
		List<RoomDto> rooms = session.selectList("room.selLuxeListAsc", dto);
		return rooms;
	}

}
