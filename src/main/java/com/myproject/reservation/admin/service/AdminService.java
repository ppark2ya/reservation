package com.myproject.reservation.admin.service;

import java.util.List;
import java.util.Map;

public interface AdminService {
	public List<Map<String, Object>> customerList();
	public List<Map<String, Object>> boardList();
	public List<Map<String, Object>> roomList();
	public List<Map<String, Object>> resvList();
}
