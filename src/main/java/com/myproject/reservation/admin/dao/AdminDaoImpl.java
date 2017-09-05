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
		return session.selectList("admin.customerList");
	}

	@Override
	public List<Map<String, Object>> boardList() {
		return session.selectList("admin.boardList");
	}

	@Override
	public List<Map<String, Object>> roomList() {
		return session.selectList("admin.roomList");
	}

	@Override
	public List<Map<String, Object>> resvList() {
		return session.selectList("admin.resvList");
	}

	@Override
	public void custRemoveRow(String id) {
		session.delete("admin.custRemoveRow", id);

	}

	@Override
	public void boardRemoveRow(int boardSeq) {
		session.delete("admin.boardRemoveRow", boardSeq);
	}

	@Override
	public void roomRemoveRow(int roomSeq) {
		session.delete("admin.roomRemoveRow", roomSeq);

	}

	@Override
	public void resvRemoveRow(int rvSeq) {
		session.delete("admin.resvRemoveRow", rvSeq);
	}
}
