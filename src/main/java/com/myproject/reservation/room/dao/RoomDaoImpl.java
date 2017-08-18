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
		return session.selectList("room.selRoomListAsc", dto);
	}

	@Override
	public List<RoomDto> selCheapListAsc(RoomDto dto) {
		return session.selectList("room.selCheapListAsc", dto);
	}

	@Override
	public List<RoomDto> selPopListAsc(RoomDto dto) {
		return session.selectList("room.selPopListAsc", dto);
	}

	@Override
	public List<RoomDto> selLuxeListAsc(RoomDto dto) {
		return session.selectList("room.selLuxeListAsc", dto);
	}

	@Override
	public int getCount(RoomDto dto) {
		return session.selectOne("room.getCount", dto);
	}

	@Override
	public RoomDto getData(int roomSeq) {
		return session.selectOne("room.getData", roomSeq);
	}

}
