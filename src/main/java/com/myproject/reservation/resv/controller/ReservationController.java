package com.myproject.reservation.resv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.resv.dto.ReservationDto;
import com.myproject.reservation.resv.service.ReservationService;
import com.myproject.reservation.room.dto.RoomDto;
import com.myproject.reservation.room.service.RoomService;

@Controller
public class ReservationController {
	@Autowired
	private RoomService roomService;

	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/reservation/reservationForm")
	public ModelAndView privateReservationForm(ModelAndView mView,
			@RequestParam int roomSeq,
			RoomDto roomDto){
		roomDto = roomService.getData(roomSeq);
		mView.addObject("roomDto", roomDto);
		mView.setViewName("reservation/reservation_form");
		return mView;
	}

	@RequestMapping("/reservation/resvRoom")
	public ModelAndView idCheckResvRoom(ModelAndView mView,
			RoomDto roomDto,
			@ModelAttribute ReservationDto resvDto){
		roomDto = roomService.getData(resvDto.getRoomSeq());
		mView = reservationService.resvRoom(roomDto, resvDto);
		return mView;
	}
}
