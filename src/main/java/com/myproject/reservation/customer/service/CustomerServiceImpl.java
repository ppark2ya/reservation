package com.myproject.reservation.customer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardDto;
import com.myproject.reservation.customer.dao.CustomerDao;
import com.myproject.reservation.customer.dto.CustomerDto;
import com.myproject.reservation.resv.dto.ReservationDto;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;

	@Override
	public ModelAndView signUp(CustomerDto custDto, BoardDto boardDto, ReservationDto resvDto, String url) {
		ModelAndView mView = new ModelAndView();
		// 게시판에서 로그인폼으로 리다이렉트 되었을 때 필요한 변수들
		int boardSeq = boardDto.getBoardSeq();
		String keyword = boardDto.getKeyword();
		String condition = boardDto.getCondition();
		// 객실 예약에서 로그인폼으로 리다이렉트 되었을 때 필요한 변수들
		int roomSeq = resvDto.getRoomSeq();
		String checkIn = resvDto.getCheckIn();
		String checkOut = resvDto.getCheckOut();

		customerDao.insert(custDto);
		if(url.equals("")){
			mView.setViewName("redirect:/home.do");
		}else{
			((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest().getSession().setAttribute("id", custDto.getId());
			if(url.contains("/board")){
				if(boardSeq == 0){
					mView.setViewName("redirect:"+url);
				}else{
					String redirectUrl = url
							+ "?boardSeq=" + boardSeq
							+ "&keywowrd=" + keyword
							+ "&condition=" + condition;
					mView.setViewName("redirect:"+redirectUrl);
				}

			}else if(url.contains("/reservation")){
				String redirectUrl = url
						+ "?roomSeq=" + roomSeq
						+ "&checkIn=" + checkIn
						+ "&checkOut=" + checkOut;
				mView.setViewName("redirect:"+redirectUrl);
			}
		}
		return mView;
	}

	@Override
	public ModelAndView signIn(CustomerDto custDto, BoardDto boardDto, ReservationDto resvDto,
			HttpServletRequest request, String url) {
		ModelAndView mView = new ModelAndView();
		// 게시판에서 로그인폼으로 리다이렉트 되었을 때 필요한 변수들
		int boardSeq = boardDto.getBoardSeq();
		String keyword = boardDto.getKeyword();
		String condition = boardDto.getCondition();
		// 객실 예약에서 로그인폼으로 리다이렉트 되었을 때 필요한 변수들
		int roomSeq = resvDto.getRoomSeq();
		String checkIn = resvDto.getCheckIn();
		String checkOut = resvDto.getCheckOut();

		// 아이디 검증
		boolean isValid = customerDao.isValid(custDto);
		if(!isValid){
			mView.setViewName("customer/signin_error");
		}else{
			request.getSession().setAttribute("id", custDto.getId());
			if(url.equals("")){
				mView.setViewName("redirect:/home.do");
			}else if(url.contains("/board")){
				// 글쓰기폼으로 들어갈 때
				if(boardSeq == 0){
					mView.setViewName("redirect:"+url);
				// 게시글 상세보기로 들어갈 때
				}else{
					String redirectUrl = url
							+ "?boardSeq=" + boardSeq
							+ "&keywowrd=" + keyword
							+ "&condition=" + condition;
					mView.setViewName("redirect:"+redirectUrl);
				}
			}else if(url.contains("/reservation")){
				String redirectUrl = url
						+ "?roomSeq=" + roomSeq
						+ "&checkIn=" + checkIn
						+ "&checkOut=" + checkOut;
				mView.setViewName("redirect:"+redirectUrl);
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
