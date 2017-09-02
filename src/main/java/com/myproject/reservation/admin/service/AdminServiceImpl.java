package com.myproject.reservation.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.reservation.admin.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Map<String, Object>> customerList() {
		List<Map<String, Object>> list = adminDao.customerList();
		return list;
	}

	@Override
	public List<Map<String, Object>> boardList() {
		List<Map<String, Object>> list = adminDao.boardList();
		return list;
	}

	@Override
	public List<Map<String, Object>> roomList() {
		List<Map<String, Object>> list = adminDao.roomList();
		return list;
	}

	@Override
	public List<Map<String, Object>> resvList() {
		List<Map<String, Object>> list = adminDao.resvList();
		return list;
	}
}
