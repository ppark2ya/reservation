package com.myproject.reservation.customer.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardDto;
import com.myproject.reservation.customer.dto.CustomerDto;
import com.myproject.reservation.customer.service.CustomerService;
import com.myproject.reservation.resv.dto.ReservationDto;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer/signupform")
	public String signUpForm(){
		return "customer/signup_form";
	}

	@RequestMapping("/customer/checkid")
	@ResponseBody
	public Map<String, Object> checkId(@RequestParam(defaultValue="", required=false) String inputId){
		boolean canUse = customerService.canUseId(inputId);
		Map<String, Object> map = new HashMap<>();
		map.put("canUse", canUse);
		return map;
	}

	@RequestMapping("/customer/signup")
	public ModelAndView enCryptsignUp(ModelAndView mView,
			@ModelAttribute CustomerDto custDto,
			@RequestParam(defaultValue="", required=false) String url,
			@ModelAttribute BoardDto boardDto,
			@ModelAttribute ReservationDto resvDto){
		mView = customerService.signUp(custDto, boardDto, resvDto, url);
		return mView;
	}

	@RequestMapping("/customer/signinform")
	public ModelAndView signInForm(ModelAndView mView, HttpServletRequest request){
		String savedId = "";
		Cookie[] cookie = request.getCookies();
		if(cookie != null && cookie.length > 0){
			for(Cookie tmp : cookie){
				if(tmp.getName().equals("savedId")){
					savedId = tmp.getValue();
				}
			}
		}
		mView.addObject("saveId", savedId);
		mView.setViewName("customer/signin_form");
		return mView;
	}

	@RequestMapping("/customer/signin")
	public ModelAndView enCryptsignIn(@ModelAttribute CustomerDto custDto,
			@RequestParam(defaultValue="", required=false) String url,
			@ModelAttribute BoardDto boardDto,
			@ModelAttribute ReservationDto resvDto,
			ModelAndView mView,
			HttpServletRequest request,
			HttpServletResponse response){
		String isSave = request.getParameter("isSave");
		if(isSave != null){
			Cookie cookie = new Cookie("savedId", custDto.getId());
			cookie.setMaxAge(60);
			response.addCookie(cookie);
		}

		mView = customerService.signIn(custDto, boardDto, resvDto, request, url);
		return mView;
	}

	@RequestMapping("/customer/signout")
	public String signOut(HttpSession session){
		session.invalidate();
		return "redirect:/home.do";
	}

	@RequestMapping("/customer/forgetpasswordform")
	public String forgetPasswordForm(){
		return "customer/forgetpassword_form";
	}

	@RequestMapping("/customer/resetpassword")
	public String enCryptresetPassword(@ModelAttribute CustomerDto dto){
		customerService.modifyPwd(dto);
		return "customer/signin_form";
	}

	// AOP 오류존재
	@RequestMapping("/customer/mypage")
	public ModelAndView idCheckMypage(HttpSession session){
		ModelAndView mView = customerService.detail((String)session.getAttribute("id"));
		mView.setViewName("customer/myPage");
		return mView;
	}

	@RequestMapping("/customer/updateform")
	public ModelAndView privateUpdateForm(@ModelAttribute CustomerDto dto, HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("id");
		ModelAndView mView = customerService.detail(id);
		mView.setViewName("customer/update_form");
		return mView;
	}

	@RequestMapping("/customer/update")
	public ModelAndView enCryptUpdate(ModelAndView mView,
			@ModelAttribute CustomerDto dto){
		customerService.update(dto);
		mView.setViewName("redirect:/customer/mypage.do");
		return mView;
	}

	@RequestMapping("/customer/dropout")
	public ModelAndView privateDropout(ModelAndView mView, HttpServletRequest request){
		customerService.delete(request.getSession());
		mView.setViewName("redirect:/home.do");
		return mView;
	}
}
