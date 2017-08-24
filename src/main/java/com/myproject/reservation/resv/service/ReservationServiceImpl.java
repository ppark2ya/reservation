package com.myproject.reservation.resv.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.resv.dao.ReservationDao;
import com.myproject.reservation.resv.dto.ReservationDto;
import com.myproject.reservation.room.dto.RoomDto;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao reservationDao;

	@Override
	public ModelAndView resvRoom(RoomDto roomDto, ReservationDto resvDto) {
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
		String id = (String)session.getAttribute("id");
		int amount = roomDto.getRoomCharge();
		int roomSeq = roomDto.getRoomSeq();
		resvDto.setId(id);
		resvDto.setAmount(amount);
		resvDto.setRoomSeq(roomSeq);
		reservationDao.insert(resvDto);
		reservationDao.changeDateState(resvDto);
		ModelAndView mView = new ModelAndView("reservation/complete_form");
		mView.addObject("resvDto", resvDto);
		return mView;
	}
}
