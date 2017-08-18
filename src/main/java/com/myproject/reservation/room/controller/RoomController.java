package com.myproject.reservation.room.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping("/room/detail")
	@ResponseBody
	public Map<String, Object> roomDetail(@RequestParam int roomSeq, RoomDto dto){
		dto = roomService.getData(roomSeq);
		Map<String, Object> map = new HashMap<>();
		map.put("dto", dto);
		return map;
	}

	@RequestMapping("/room/roomList")
	public ModelAndView roomList(ModelAndView mView,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			@RequestParam(value="pageNum", required=false) Integer pageNum,
			RoomDto dto){
		if(pageNum == null){
			pageNum = 1;
		}
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		dto.setPageNum(pageNum);
		mView = roomService.selRoomListAsc(dto);
		return mView;
	}

	@RequestMapping("/room/cheapList")
	public ModelAndView cheapList(ModelAndView mView,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			@RequestParam(value="pageNum", required=false) Integer pageNum,
			RoomDto dto){
		if(pageNum == null){
			pageNum = 1;
		}
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		dto.setPageNum(pageNum);
		dto.setRoomType("cheap");
		mView = roomService.selCheapListAsc(dto);
		return mView;
	}

	@RequestMapping("/room/popularList")
	public ModelAndView popularList(ModelAndView mView,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			@RequestParam(value="pageNum", required=false) Integer pageNum,
			RoomDto dto){
		if(pageNum == null){
			pageNum = 1;
		}
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		dto.setPageNum(pageNum);
		dto.setRoomType("popular");
		mView = roomService.selPopListAsc(dto);
		return mView;
	}

	@RequestMapping("/room/luxuryList")
	public ModelAndView luxeList(ModelAndView mView,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			@RequestParam(value="pageNum", required=false) Integer pageNum,
			RoomDto dto){
		if(pageNum == null){
			pageNum = 1;
		}
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		dto.setPageNum(pageNum);
		mView = roomService.selLuxeListAsc(dto);
		return mView;
	}

}
