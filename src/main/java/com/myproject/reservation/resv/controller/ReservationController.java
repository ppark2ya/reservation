package com.myproject.reservation.resv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.resv.dto.ReservationDto;
import com.myproject.reservation.resv.service.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/reservation/reservationForm")
	public ModelAndView privateReservationForm(@RequestParam int roomSeq,
			@RequestParam String checkIn,
			@RequestParam String checkOut,
			ReservationDto dto){
		dto.setRoomSeq(roomSeq);
		dto.setCheckIn(checkIn);
		dto.setCheckOut(checkOut);
		return new ModelAndView("reservation/reservation_form");
	}
}
