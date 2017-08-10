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
	public ModelAndView selRoomListAsc(RoomDto dto) {
		List<RoomDto> rooms = roomDao.selRoomListAsc(dto);
		ModelAndView mView = new ModelAndView("room/roomList");
		mView.addObject("rooms", rooms);
		return mView;
	}

//	@Override
//	public List<RoomDto> scrollDownListAsc(RoomDto dto){
//		List<RoomDto> rooms = roomDao.scrollDownListAsc(dto);
//		return rooms;
//	}

	@Override
	public ModelAndView selCheapListAsc(RoomDto dto) {
		List<RoomDto> rooms = roomDao.selCheapListAsc(dto);
		ModelAndView mView = new ModelAndView("room/cheapList");
		mView.addObject("cheap", rooms);
		return mView;
	}

	@Override
	public ModelAndView selPopListAsc(RoomDto dto) {
		List<RoomDto> rooms = roomDao.selPopListAsc(dto);
		ModelAndView mView = new ModelAndView("room/popularList");
		mView.addObject("pop", rooms);
		return mView;
	}

	@Override
	public ModelAndView selLuxeListAsc(RoomDto dto) {
		List<RoomDto> rooms = roomDao.selLuxeListAsc(dto);
		ModelAndView mView = new ModelAndView("room/luxuryList");
		mView.addObject("luxe", rooms);
		return mView;
	}

}
