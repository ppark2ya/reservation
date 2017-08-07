package com.myproject.reservation.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.room.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;

	@RequestMapping("/room/roomList")
	public ModelAndView roomList(ModelAndView mView,
			@RequestParam String checkIn, @RequestParam String checkOut){

		return mView;
	}
}
