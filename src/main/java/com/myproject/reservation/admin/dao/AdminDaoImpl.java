package com.myproject.reservation.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	private SqlSession session;

	@Override
	public List<Map<String, Object>> customerList() {
		List<Map<String, Object>> list = session.selectList("admin.customerList");
		return list;
	}

	@Override
	public List<Map<String, Object>> boardList() {
		List<Map<String, Object>> list = session.selectList("admin.boardList");
		return list;
	}

	@Override
	public List<Map<String, Object>> roomList() {
		List<Map<String, Object>> list = session.selectList("admin.roomList");
		return list;
	}

	@Override
	public List<Map<String, Object>> resvList() {
		List<Map<String, Object>> list = session.selectList("admin.resvList");
		return list;
	}
}
