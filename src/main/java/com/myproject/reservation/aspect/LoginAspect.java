package com.myproject.reservation.aspect;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardDto;
import com.myproject.reservation.customer.dto.CustomerDto;
import com.myproject.reservation.resv.dto.ReservationDto;

@Aspect
@Component
public class LoginAspect {

	@Around("execution(* enCrypt*(..))")
	public Object enCrypt(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] args = joinPoint.getArgs();
		String encryptPwd = null;
		CustomerDto dto = null;
		for(Object tmp : args){
			if(tmp instanceof CustomerDto){
				dto = (CustomerDto)tmp;
				try {
			        MessageDigest sh = MessageDigest.getInstance("SHA-256");
			        sh.update(dto.getPwd().getBytes());
			        byte byteData[] = sh.digest();
			        StringBuffer sb = new StringBuffer();
			        for(int i = 0 ; i < byteData.length ; i++){
			            sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			        }
			        encryptPwd = sb.toString();
			    } catch(NoSuchAlgorithmException e){
			        e.printStackTrace();
			    }
			}
		}
		dto.setPwd(encryptPwd);
		return joinPoint.proceed();
	}

	@Around("execution(* idCheck*(..))")
	public Object idCheck(ProceedingJoinPoint joinPoint) throws Throwable {

		HttpSession session = ((ServletRequestAttributes) RequestContextHolder
							.getRequestAttributes()).getRequest().getSession();
		boolean isLogin = false;
		String id = (String)session.getAttribute("id");
		if (id != null) {
			isLogin = true;
		}

		if (isLogin) {
			Object obj = joinPoint.proceed();
			return obj;
		} else {
			return "redircet:/home.do";
		}
	}

	@Around("execution(* private*(..))")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		// 게시판 자세히 보기를 눌렀을 때 로그인을 안한 경우 parameter 를 받기위한 DTO
		BoardDto dto = null;
		ModelAndView mView = null;
		int boardSeq = 0;
		String keyword = null;
		String condition = null;
		boolean isBoardDetail = false;

		// 객실 예약버튼을 클릭했을 때 로그인을 안한 경우 parameter 를 받기위한 DTO
		ReservationDto resvDto = null;
		int roomSeq = 0;
		String checkIn = null;
		String checkOut = null;
		boolean isReservation = false;

		// 로그인 여부
		boolean isLogin = false;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
									.getRequestAttributes()).getRequest();

		if (request.getSession().getAttribute("id") != null) {
			isLogin = true;
		}

		Object[] args = joinPoint.getArgs();
		for(Object tmp : args){
			if(tmp instanceof BoardDto){
				dto = (BoardDto)tmp;
				boardSeq = dto.getBoardSeq();
				keyword = dto.getKeyword();
				condition = dto.getCondition();
				isBoardDetail = true;
			}else if(tmp instanceof ReservationDto){
				resvDto = (ReservationDto)tmp;
				roomSeq = resvDto.getRoomSeq();
				checkIn = resvDto.getCheckIn();
				checkOut = resvDto.getCheckOut();
				isReservation = true;
			}
		}

		Object obj = joinPoint.proceed();

		if (obj instanceof ModelAndView) {
			mView = (ModelAndView) obj;
			if (!isLogin) {
				mView.setViewName("alert");
				mView.addObject("msg", "로그인이 필요합니다");
				String url = request.getRequestURI();
				String cPath = request.getContextPath();
				String redirectUrl = cPath + "/customer/signinform.do?url=" + url;
				if(isBoardDetail){
					redirectUrl = redirectUrl
							+ "&boardSeq=" + boardSeq
							+ "&keyword=" + keyword
							+ "&condition=" + condition;
				}else if(isReservation){
					redirectUrl = redirectUrl
							+ "&roomSeq=" + roomSeq
							+ "&checkIn=" + checkIn
							+ "&checkOut=" + checkOut;
				}
				mView.addObject("redirectUrl", redirectUrl);
			}
		}

		return obj;
	}

}
