package com.myproject.reservation.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.room.dao.RoomDao;
import com.myproject.reservation.room.dto.RoomDto;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;

	private ModelAndView getList(RoomDto dto, ModelAndView mView){
		// 한 페이지에 보여줄 row 의 갯수
		int pageRowCount = 5;
		int pageDisplayCount = 5;
		// 보여줄 페이지 번호
		int pageNum = dto.getPageNum();
		// 보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum = 1 + (pageNum-1)*pageRowCount;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum = pageNum*pageRowCount;
		// 전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = roomDao.getCount();
		// 전체 페이지의 갯수 구하기
		int totalPageCount = (int)Math.ceil(totalRow/(double)pageRowCount);
		// 시작 페이지 번호
		int startPageNum = 1+((pageNum-1)/pageDisplayCount)*pageDisplayCount;
		// 끝 페이지 번호
		int endPageNum = startPageNum+pageDisplayCount-1;
		// 끝 페이지 번호가 잘못된 값이라면
		if(totalPageCount < endPageNum){
			endPageNum = totalPageCount;	// 보정해준다.
		}

		// 시작 row 번호와 끝 row 번호를 dto 에 담는다.
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		// 현재 페이지 번호
		mView.addObject("pageNum", pageNum);
		mView.addObject("startPageNum", startPageNum);
		mView.addObject("endPageNum", endPageNum);
		// 전체 페이지의 갯수
		mView.addObject("totalPageCount", totalPageCount);
		mView.addObject("checkIn", dto.getCheckIn());
		mView.addObject("checkOut", dto.getCheckOut());
		return mView;
	}

	@Override
	public ModelAndView selRoomListAsc(RoomDto dto) {
		ModelAndView mView = new ModelAndView();
		mView = getList(dto, mView);
		// 글 목록 얻어오기
		List<RoomDto> rooms = roomDao.selRoomListAsc(dto);
		mView.setViewName("room/roomList");
		mView.addObject("rooms", rooms);
		return mView;
	}

	@Override
	public ModelAndView selCheapListAsc(RoomDto dto) {
		ModelAndView mView = new ModelAndView();
		mView = getList(dto, mView);
		List<RoomDto> rooms = roomDao.selCheapListAsc(dto);
		mView.setViewName("room/cheapList");
		mView.addObject("cheap", rooms);
		return mView;
	}

	@Override
	public ModelAndView selPopListAsc(RoomDto dto) {
		ModelAndView mView = new ModelAndView();
		mView = getList(dto, mView);
		List<RoomDto> rooms = roomDao.selPopListAsc(dto);
		mView.setViewName("room/popularList");
		mView.addObject("pop", rooms);
		return mView;
	}

	@Override
	public ModelAndView selLuxeListAsc(RoomDto dto) {
		ModelAndView mView = new ModelAndView("room/luxuryList");
		List<RoomDto> rooms = roomDao.selLuxeListAsc(dto);
		mView.addObject("luxe", rooms);
		return mView;
	}

}
