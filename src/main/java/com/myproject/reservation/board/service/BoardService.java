package com.myproject.reservation.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardCommentDto;
import com.myproject.reservation.board.dto.BoardDto;

public interface BoardService {
	public ModelAndView boardList(BoardDto dto, String keyword, String condition, String pageNum);
	public ModelAndView detail(int boardSeq, HttpServletRequest request);
	public ModelAndView detail(BoardDto dto);
	public void commentInsert(BoardCommentDto dto);
	public void increaseViewCount(int boardSeq);
	public void update(BoardDto dto);
	public void delete(int boardSeq);
	public void insert(BoardDto dto);
}
