package com.myproject.reservation.resv.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.reservation.resv.dto.ReservationDto;

@Repository
public class ReservationDaoImpl implements ReservationDao{

	@Autowired
	private SqlSession session;

	@Override
	public void insert(ReservationDto dto) {
		session.insert("reservation.insert", dto);
	}

	@Override
	public void changeDateState(ReservationDto dto) {
		session.update("reservation.changeDateState", dto);
	}
}
