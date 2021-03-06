package com.myproject.reservation.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dao.BoardCommentDao;
import com.myproject.reservation.board.dao.BoardDao;
import com.myproject.reservation.board.dto.BoardCommentDto;
import com.myproject.reservation.board.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardCommentDao boardCommentDao;

	@Override
	public ModelAndView boardList(BoardDto dto) {
		int pageRowCount = 10;
		int pageDisplayCount = 5;
		ModelAndView mView = new ModelAndView();
		String keyword = dto.getKeyword();
		String condition = dto.getCondition();
		if(keyword != null){	// 검색어가 전달된 경우
			if(condition.equals("titlecontent")){	// 제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")){	// 제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")){	// 작성자 검색
				dto.setWriter(keyword);
			}else if(condition.equals("category")){	// 카테고리 검색
				dto.setCategory(keyword);
			}
			// boardlist.jsp 페이지에서 필요한 내용을 담는다.
			mView.addObject("condition", condition);
			mView.addObject("keyword", keyword);
		}
		// 보여줄 페이지 번호
		int pageNum = dto.getPageNum();
		// 보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum = 1 + (pageNum-1)*pageRowCount;
		// 보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum = pageNum*pageRowCount;
		// 전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = boardDao.getCount();
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

		// 글 목록을 얻어온다.
		List<BoardDto> list = boardDao.getList(dto);
		// 모델을 담는다.
		mView.addObject("list", list);

		// 현재 페이지 번호
		mView.addObject("pageNum", pageNum);
		mView.addObject("startPageNum", startPageNum);
		mView.addObject("endPageNum", endPageNum);
		// 전체 페이지의 갯수
		mView.addObject("totalPageCount", totalPageCount);
		mView.setViewName("board/boardlist");
		return mView;
	}

	@Override
	public ModelAndView detail(BoardDto dto) {
		ModelAndView mView = new ModelAndView();
		int boardSeq = dto.getBoardSeq();
		String keyword = dto.getKeyword();
		String condition = dto.getCondition();
		if(keyword != null){ //검색어가 전달된 경우
			if(condition.equals("titlecontent")){ //제목+내용 검색
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")){//제목 검색
				dto.setTitle(keyword);
			}else if(condition.equals("writer")){//작성자 검색
				dto.setWriter(keyword);
			}
			// list.jsp 뷰페이지에서 필요한 내용을 request 에 담는다.
			mView.addObject("condition", condition);
			mView.addObject("keyword", keyword);
		}
		dto.setBoardSeq(boardSeq);
		BoardDto resultDto = boardDao.getData(dto);
		List<BoardCommentDto> commentList = boardCommentDao.getList(boardSeq);
		mView.addObject("dto", resultDto);
		mView.addObject("commentList", commentList);
		mView.setViewName("board/detail");
		return mView;
	}

	@Override
	public ModelAndView getData(BoardDto dto) {
		BoardDto resultDto = boardDao.getData(dto);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", resultDto);
		return mView;
	}

	@Override
	public void increaseViewCount(int boardSeq) {
		boardDao.increaseViewCount(boardSeq);
	}

	@Override
	public ModelAndView commentInsert(BoardCommentDto dto) {
		// 저장할 댓글의 번호를 미리 가져온다.
		int seq = boardCommentDao.getSequence();
		// 글 번호로 사용한다
		dto.setBoardSeq(seq);
		// 원글의 댓글인지 댓글의 댓글인지 확인해서 다르게 처리한다.
		int commentGroup = dto.getCommentGroup();
		if(commentGroup == 0){	// 0 이면 원글의 댓글
			// 원글의 댓글이면 그룹번호를 저장할 댓글 번호로 지정한다.
			dto.setCommentGroup(seq);
		}
		boardCommentDao.insert(dto);
		ModelAndView mView = new ModelAndView("redirect:/board/detail.do?boardSeq="+dto.getRefGroup());
		return mView;
	}

	@Override
	public void delete(int boardSeq) {
		boardDao.delete(boardSeq);
	}
	@Override
	public void update(BoardDto dto) {
		boardDao.update(dto);
	}
	@Override
	public void insert(BoardDto dto) {
		boardDao.insert(dto);
	}



}
