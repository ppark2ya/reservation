package com.myproject.reservation.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardDto;
import com.myproject.reservation.customer.dto.CustomerDto;

public interface CustomerService {
	public ModelAndView signUp(CustomerDto dto, String url, HttpSession session);
	public ModelAndView signIn(CustomerDto custDto, BoardDto boardDto,
			HttpServletRequest request, String url);
	public void delete(HttpSession session);
	public boolean canUseId(String id);
	public void update(CustomerDto dto);
	public ModelAndView detail(String id);
	public void modifyPwd(CustomerDto dto);
}