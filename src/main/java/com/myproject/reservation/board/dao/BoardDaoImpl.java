package com.myproject.reservation.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.reservation.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSession session;

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		List<BoardDto> list = session.selectList("board.getList", dto);
		return list;
	}

	@Override
	public int getCount() {
		return session.selectOne("board.getCount");
	}

	@Override
	public BoardDto getData(BoardDto dto) {
		return session.selectOne("board.getData", dto);
	}

	@Override
	public void increaseViewCount(int boardSeq) {
		session.update("board.increaseViewCount", boardSeq);
	}
}
