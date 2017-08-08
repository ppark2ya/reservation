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
	public List<RoomDto> selRoomList(RoomDto dto) {
		List<RoomDto> rooms = session.selectList("room.selRoomList", dto);
		return rooms;
	}

}
