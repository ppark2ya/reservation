package com.myproject.reservation.board.service;

import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardCommentDto;
import com.myproject.reservation.board.dto.BoardDto;

public interface BoardService {
	public ModelAndView boardList(BoardDto dto);
	public ModelAndView detail(BoardDto dto);
	public ModelAndView getData(BoardDto dto);
	public ModelAndView commentInsert(BoardCommentDto dto);
	public void increaseViewCount(int boardSeq);
	public void update(BoardDto dto);
	public void delete(int boardSeq);
	public void insert(BoardDto dto);
}
