package com.myproject.reservation.admin.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface AdminService {
	public List<Map<String, Object>> getList(String type);
	public void removeRow(String json) throws JsonProcessingException, IOException;
}
