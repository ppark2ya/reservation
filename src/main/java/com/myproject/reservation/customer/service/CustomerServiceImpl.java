package com.myproject.reservation.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardDto;
import com.myproject.reservation.customer.dao.CustomerDao;
import com.myproject.reservation.customer.dto.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;

	@Override
	public ModelAndView signUp(CustomerDto dto, String url, HttpSession session) {
		ModelAndView mView = new ModelAndView();
		if(url.equals("")){
			customerDao.insert(dto);
			mView.setViewName("redirect:/home.do");
		}else{
			customerDao.insert(dto);
			session.setAttribute("id", dto.getId());
			mView.setViewName("redirect:"+url);
		}
		return mView;
	}

	@Override
	public ModelAndView signIn(CustomerDto custDto, BoardDto boardDto,
			HttpServletRequest request, String url) {
		int boardSeq = boardDto.getBoardSeq();
		String keyword = boardDto.getKeyword();
		String condition = boardDto.getCondition();
		boolean isValid = customerDao.isValid(custDto);
		ModelAndView mView = new ModelAndView();
		if(!isValid){
			mView.setViewName("customer/signin_error");
		}else{
			request.getSession().setAttribute("id", custDto.getId());
			if(url.equals("")){
				mView.setViewName("redirect:/home.do");
			}else{
				if(boardSeq == 0){
					mView.setViewName("redirect:"+url);
				}else{
					String redirectUrl = url
							+ "?boardSeq=" + boardSeq
							+ "&keywowrd=" + keyword
							+ "&condition=" + condition;
					mView.setViewName("redirect:"+redirectUrl);
				}
			}
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
