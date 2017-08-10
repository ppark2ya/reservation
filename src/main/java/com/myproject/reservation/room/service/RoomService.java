package com.myproject.reservation.room.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.room.dto.RoomDto;

public interface RoomService {
	public ModelAndView selRoomListAsc(RoomDto dto);
//	public List<RoomDto> scrollDownListAsc(RoomDto dto);
	public ModelAndView selCheapListAsc(RoomDto dto);
	public ModelAndView selPopListAsc(RoomDto dto);
	public ModelAndView selLuxeListAsc(RoomDto dto);
}
