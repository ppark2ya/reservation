package com.myproject.reservation.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.customer.dto.CustomerDto;

public interface CustomerService {
	public void signup(CustomerDto dto);
	public ModelAndView signin(CustomerDto dto, HttpServletRequest request);
	public void delete(HttpSession session);
	public boolean canUseId(String id);
	public void update(CustomerDto dto);
	public ModelAndView detail(String id);
	public void modifyPwd(CustomerDto dto);
}
