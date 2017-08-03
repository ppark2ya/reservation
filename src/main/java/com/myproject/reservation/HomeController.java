package com.myproject.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home.do")
	public ModelAndView home(){
		ModelAndView mView=new ModelAndView("home");
		return mView;
	}
}














