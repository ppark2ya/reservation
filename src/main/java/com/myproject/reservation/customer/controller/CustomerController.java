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
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.customer.dto.CustomerDto;
import com.myproject.reservation.customer.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customer/signupform")
	public String signupform(){
		return "customer/signup_form";
	}
	
	@RequestMapping("/customer/checkid")
	@ResponseBody
	public Map<String, Object> checkId(@RequestParam String inputId){
		boolean canUse = customerService.canUseId(inputId);
		Map<String, Object> map = new HashMap<>();
		map.put("canUse", canUse);
		return map;
	}
	@RequestMapping("/customer/signup")
	public String signup(@ModelAttribute CustomerDto dto){
		customerService.signup(dto);
		return "redirect:/home.do";
	}
	
	@RequestMapping("/customer/signinform")
	public String signinform(HttpServletRequest request){
		String savedId = "";
		Cookie[] cookie = request.getCookies();
		if(cookie != null && cookie.length > 0){
			for(Cookie tmp : cookie){
				if(tmp.getName().equals("savedId")){
					savedId = tmp.getValue();
				}
			}
		}
		request.setAttribute("savedId", savedId);
		return "customer/signin_form";
	}
	
	@RequestMapping("/customer/signin")
	public ModelAndView signin(@ModelAttribute CustomerDto dto, HttpServletRequest request,
			HttpServletResponse response){
		String isSave = request.getParameter("isSave");
		if(isSave != null){
			Cookie cookie = new Cookie("savedId", dto.getId());
			cookie.setMaxAge(60);
			response.addCookie(cookie);
		}
		ModelAndView mView = customerService.signin(dto, request);
		return mView;
	}
	
	@RequestMapping("/customer/signout")
	public String signout(HttpSession session){
		session.invalidate();
		return "redirect:/home.do";
	}

	@RequestMapping("/customer/forgetpasswordform")
	public String forgetpasswordform(){
		return "customer/forgetpassword_form";
	}
	
	@RequestMapping("/customer/resetpassword")
	public String resetpassword(@ModelAttribute CustomerDto dto){
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
	public ModelAndView privateUpdateform(@ModelAttribute CustomerDto dto, HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("id");
		ModelAndView mView = customerService.detail(id);
		mView.setViewName("customer/update_form");
		return mView;
	}
	
	@RequestMapping("/customer/update")
	public String privateUpdate(@ModelAttribute CustomerDto dto, HttpServletRequest request){
		customerService.update(dto);
		return "redirect:/customer/mypage.do";
	}
	
	@RequestMapping("/customer/dropout")
	public String privateDropout(HttpServletRequest request){
		customerService.delete(request.getSession());
		return "redirect:/home.do";
	}
}
