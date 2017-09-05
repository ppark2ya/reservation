package com.myproject.reservation.admin.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.reservation.admin.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Map<String, Object>> getList(String type) {
		if(type.equals("cust")){
			return adminDao.customerList();
		}else if(type.equals("board")){
			return adminDao.boardList();
		}else if(type.equals("room")){
			return adminDao.roomList();
		}else{
			return adminDao.resvList();
		}
	}

	@Override
	public void removeRow(String json) throws JsonProcessingException, IOException {
		// jackson 라이브러리를 사용해서 json 데이터에서 primary key 값 얻어오기
		// 보통은 json data 값들에 대응되는 (VO - value object) 클래스를 만들어서 많이 사용한다.
		// ObjectMapper mapper = new ObjectMapper();
		// UserBean bean = mapper.readValue(json, UserBean.class);

		// json 데이터를 Object 타입으로 바꿀 객체 생성
		ObjectMapper mapper = new ObjectMapper();
		// json 데이터를 tree 형식의 Object 타입데이터로 변환
		JsonNode node = mapper.readTree(json);
		// key 값에 대응되는 값을 얻어와서 removeId 에 저장
		if(json.contains("id")){
			adminDao.custRemoveRow(node.path("id").textValue());
		}else if(json.contains("boardSeq")){
			adminDao.boardRemoveRow(node.path("boardSeq").intValue());
		}else if(json.contains("roomSeq")){
			adminDao.roomRemoveRow(node.path("roomSeq").intValue());
		}else if(json.contains("rvSeq")){
			adminDao.resvRemoveRow(node.path("rvSeq").intValue());
		}
	}

}
