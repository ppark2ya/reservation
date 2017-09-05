package com.myproject.reservation.admin.dao;

import java.util.List;
import java.util.Map;

public interface AdminDao {
	public List<Map<String, Object>> customerList();
	public void custRemoveRow(String id);
	public List<Map<String, Object>> boardList();
	public void boardRemoveRow(int boardSeq);
	public List<Map<String, Object>> roomList();
	public void roomRemoveRow(int roomSeq);
	public List<Map<String, Object>> resvList();
	public void resvRemoveRow(int rvSeq);
}
