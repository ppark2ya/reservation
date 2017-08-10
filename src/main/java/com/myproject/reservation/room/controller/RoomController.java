package com.myproject.reservation.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.room.dto.RoomDto;
import com.myproject.reservation.room.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;

	@RequestMapping("/room/roomList")
	public ModelAndView roomList(ModelAndView mView,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			RoomDto dto){
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		mView = roomService.selRoomListAsc(dto);
		return mView;
	}

//	@RequestMapping("/room/infiniteScrollDown")
//	@ResponseBody
//	public List<RoomDto> infiniteScrollDown(ModelAndView mView,
//			@RequestParam int roomSeq,
//			@RequestParam String checkIn,
//			@RequestParam String checkOut,
//			RoomDto dto
//			){
//		System.out.println("hello scroll");
//		dto.setCheckIn(checkIn);
//		dto.setCheckOut(checkOut);
//		dto.setRoomSeq(roomSeq-1);
//		return roomService.scrollDownListAsc(dto);
//	}

	@RequestMapping("/room/cheapList")
	public ModelAndView cheapList(ModelAndView mView,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			RoomDto dto){
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		mView = roomService.selCheapListAsc(dto);
		return mView;
	}

	@RequestMapping("/room/popularList")
	public ModelAndView popularList(ModelAndView mView,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			RoomDto dto){
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		mView = roomService.selPopListAsc(dto);
		return mView;
	}

	@RequestMapping("/room/luxuryList")
	public ModelAndView luxeList(ModelAndView mView,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			RoomDto dto){
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		mView = roomService.selLuxeListAsc(dto);
		return mView;
	}

}
