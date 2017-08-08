package com.myproject.reservation.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.room.dao.RoomDao;
import com.myproject.reservation.room.dto.RoomDto;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;

	@Override
	public ModelAndView selRoomList(RoomDto dto) {
		List<RoomDto> rooms = roomDao.selRoomList(dto);
		ModelAndView mView = new ModelAndView("room/roomList");
		mView.addObject("rooms", rooms);
		return mView;
	}

}
