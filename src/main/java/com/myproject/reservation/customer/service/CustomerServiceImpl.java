package com.myproject.reservation.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.customer.dao.CustomerDao;
import com.myproject.reservation.customer.dto.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void signup(CustomerDto dto) {
		customerDao.insert(dto);
	}

	@Override
	public ModelAndView signin(CustomerDto dto, HttpServletRequest request) {
		boolean isValid = customerDao.isValid(dto);
		ModelAndView mView = new ModelAndView();
		if(!isValid){
			mView.setViewName("/customer/signin_error");
		}else{
			request.getSession().setAttribute("id", dto.getId());
			mView.setViewName("redirect:/home.do");
		}
		return mView;
	}

	@Override
	public void delete(HttpSession session) {
		customerDao.delete((String)session.getAttribute("id"));
		session.invalidate();
	}

	@Override
	public boolean canUseId(String id) {
		return customerDao.canUseId(id);
	}

	@Override
	public void update(CustomerDto dto) {
		customerDao.update(dto);
	}

	@Override
	public ModelAndView detail(String id) {
		CustomerDto dto = customerDao.getData(id);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

	@Override
	public void modifyPwd(CustomerDto dto) {
		customerDao.modifyPwd(dto);
	}

}
