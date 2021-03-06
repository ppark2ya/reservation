package com.myproject.reservation.board.dao;

import java.util.List;

import com.myproject.reservation.board.dto.BoardDto;

public interface BoardDao {
	public List<BoardDto> getList(BoardDto dto);
	public int getCount();
	public BoardDto getData(BoardDto dto);
	public void increaseViewCount(int boardSeq);
	public void delete(int boardSeq);
	public void update(BoardDto dto);
	public void insert(BoardDto dto);
}
