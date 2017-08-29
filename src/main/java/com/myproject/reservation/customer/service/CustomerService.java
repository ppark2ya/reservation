package com.myproject.reservation.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardDto;
import com.myproject.reservation.customer.dto.CustomerDto;
import com.myproject.reservation.resv.dto.ReservationDto;

public interface CustomerService {
	public ModelAndView signUp(CustomerDto custDto, BoardDto boardDto, ReservationDto resvDto, String url);
	public ModelAndView signIn(CustomerDto custDto, BoardDto boardDto, ReservationDto resvDto,
			HttpServletRequest request, String url);
	public void delete(HttpSession session);
	public boolean canUseId(String id);
	public void update(CustomerDto dto);
	public ModelAndView detail(String id);
	public void modifyPwd(CustomerDto dto);
}
