package com.myproject.reservation.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.admin.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin/manage")
	public ModelAndView managePage(ModelAndView mView){
		mView.setViewName("admin/adminPage");
		return mView;
	}

	@RequestMapping("/admin/customerList")
	@ResponseBody
	public List<Map<String, Object>> customerList(ModelAndView mView){
		List<Map<String, Object>> list = adminService.customerList();
		System.out.println(list);
		return list;
	}

	@RequestMapping("/admin/boardList")
	@ResponseBody
	public List<Map<String, Object>> boardList(ModelAndView mView){
		List<Map<String, Object>> list = adminService.boardList();
		System.out.println(list);
		return list;
	}

	@RequestMapping("/admin/roomList")
	@ResponseBody
	public List<Map<String, Object>> roomList(ModelAndView mView){
		List<Map<String, Object>> list = adminService.roomList();
		System.out.println(list);
		return list;
	}

	@RequestMapping("/admin/resvList")
	@ResponseBody
	public List<Map<String, Object>> resvList(ModelAndView mView){
		List<Map<String, Object>> list = adminService.resvList();
		System.out.println(list);
		return list;
	}
}