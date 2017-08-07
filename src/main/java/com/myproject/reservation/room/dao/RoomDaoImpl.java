package com.myproject.reservation.room.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl implements RoomDao{

	@Autowired
	private SqlSession session;
}
