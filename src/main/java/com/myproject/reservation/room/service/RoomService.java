package com.myproject.reservation.room.service;

import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.room.dto.RoomDto;

public interface RoomService {
	public ModelAndView selRoomList(RoomDto dto);
}
