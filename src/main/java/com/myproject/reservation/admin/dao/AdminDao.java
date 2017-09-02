package com.myproject.reservation.admin.dao;

import java.util.List;
import java.util.Map;

public interface AdminDao {
	public List<Map<String, Object>> customerList();
	public List<Map<String, Object>> boardList();
	public List<Map<String, Object>> roomList();
	public List<Map<String, Object>> resvList();
}
