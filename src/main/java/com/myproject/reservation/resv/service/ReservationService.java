package com.myproject.reservation.resv.service;

import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.resv.dto.ReservationDto;
import com.myproject.reservation.room.dto.RoomDto;

public interface ReservationService {
	public ModelAndView resvRoom(RoomDto roomDto, ReservationDto resvDto);
}
