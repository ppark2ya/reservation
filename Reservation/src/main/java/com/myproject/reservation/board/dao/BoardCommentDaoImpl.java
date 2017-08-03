package com.myproject.reservation.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.reservation.board.dto.BoardCommentDto;

@Repository
public class BoardCommentDaoImpl implements BoardCommentDao{

	@Autowired
	private SqlSession session;
	@Override
	public int getSequence() {
		return session.selectOne("boardComment.getSequence");
	}

	@Override
	public List<BoardCommentDto> getList(int boardSeq) {
		List<BoardCommentDto> list = session.selectList("boardComment.getList", boardSeq);
		return list;
	}

	@Override
	public void insert(BoardCommentDto dto) {
		session.insert("boardComment.insert", dto);
	}

}
