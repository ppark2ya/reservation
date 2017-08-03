package com.myproject.reservation.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardDto;
import com.myproject.reservation.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/boardlist")
	public ModelAndView boardList(@ModelAttribute BoardDto dto, 
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="") String condition, 
			HttpServletRequest request){
		String pageNum = request.getParameter("pageNum");
		ModelAndView mView = boardService.boardList(dto, keyword, condition, pageNum);
		mView.setViewName("board/boardlist");
		return mView;
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView privateDetail(@RequestParam int boardSeq, HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("id");
		ModelAndView mView = boardService.detail(boardSeq, request);
		boardService.increaseViewCount(boardSeq);
		boolean isLogin = false;
		if(id != null){
			isLogin = true;
		}
		mView.addObject("isLogin", isLogin);
		mView.setViewName("board/detail");
		return mView;
	}
}
