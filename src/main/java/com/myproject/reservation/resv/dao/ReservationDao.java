package com.myproject.reservation.resv.dao;

import com.myproject.reservation.resv.dto.ReservationDto;

public interface ReservationDao {
	public void insert(ReservationDto dto);
	public void changeDateState(ReservationDto dto);
}

