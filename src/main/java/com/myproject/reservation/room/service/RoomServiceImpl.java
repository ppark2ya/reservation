package com.myproject.reservation.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.reservation.room.dao.RoomDao;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;

}
