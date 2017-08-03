package com.myproject.reservation.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class LoginAspect {
	
	@Around("execution(* idCheck*(..))")
	public Object idCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		Object[] args = joinPoint.getArgs();
		boolean isLogin = false;
		for(Object tmp : args){
			if(tmp instanceof HttpSession){
				HttpSession session = (HttpSession)tmp;
				if(session.getAttribute("id") != null){
					isLogin = true;
				}
			}
		}
		
		if(isLogin){
			Object obj = joinPoint.proceed();
			return obj;
		}else{
			return "redircet:/home.do";
		}
	}

	@Around("execution(* private*(..))")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		// AOP 가 적용된 메소드에 전달된 인자를 Object[] 에 담아온다.
		Object[] args = joinPoint.getArgs();
		// 로그인 여부
		boolean isLogin = false;
		HttpServletRequest request = null;
		for(Object tmp : args){
			// 객체가 HttpServletRequest 객체라면
			if(tmp instanceof HttpServletRequest){
				request = (HttpServletRequest)tmp;
				HttpSession session = request.getSession();
				if(session.getAttribute("id") != null){
					isLogin = true;
				}
			}
		}
		
		Object obj = joinPoint.proceed();
		if(obj instanceof ModelAndView){
			ModelAndView mView = (ModelAndView)obj;
			if(!isLogin){
//				mView.setViewName("alert");
//				mView.addObject("msg", "로그인이 필요합니다");
				String url = request.getRequestURI();
				String cPath = request.getContextPath();
				String redirectUrl = cPath + "/customer/signin_form.do?url=" + url;
				mView.addObject("redirectUrl", redirectUrl);
			}
		}
		
		return obj;
	}
	
}
