package com.myproject.reservation.board.dao;

import java.util.List;

import com.myproject.reservation.board.dto.BoardCommentDto;

public interface BoardCommentDao {
	public int getSequence();
	public List<BoardCommentDto> getList(int boardSeq);
	public void insert(BoardCommentDto dto);
}
