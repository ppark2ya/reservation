package com.myproject.reservation.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.reservation.board.dto.BoardCommentDto;
import com.myproject.reservation.board.dto.BoardDto;
import com.myproject.reservation.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/board/boardlist")
	public ModelAndView boardList(BoardDto dto,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="") String condition,
			@RequestParam(value="pageNum", required=false) Integer pageNum){
		if(pageNum == null){
			pageNum = 1;
		}
		dto.setKeyword(keyword);
		dto.setCondition(condition);
		dto.setPageNum(pageNum);
		ModelAndView mView = boardService.boardList(dto);
		return mView;
	}

	@RequestMapping("/board/detail")
	public ModelAndView privateDetail(@RequestParam int boardSeq,
			@RequestParam(defaultValue="") String keyword,
			@RequestParam(defaultValue="") String condition,
			BoardDto dto){
		dto.setBoardSeq(boardSeq);
		dto.setKeyword(keyword);
		dto.setCondition(condition);
		ModelAndView mView = boardService.detail(dto);
		boardService.increaseViewCount(boardSeq);
		return mView;
	}

	@RequestMapping("/board/updateform")
	public ModelAndView privateUpdateForm(@RequestParam int boardSeq,
			@ModelAttribute BoardDto dto, ModelAndView mView){
		dto.setBoardSeq(boardSeq);
		mView = boardService.getData(dto);
		mView.setViewName("board/update_form");
		return mView;
	}

	@RequestMapping("/board/update")
	public String idCheckUpdate(@ModelAttribute BoardDto dto){
		boardService.update(dto);
		return "redirect:/board/boardlist.do";
	}

	@RequestMapping("/board/delete")
	public String idCheckDelete(@RequestParam int boardSeq){
		boardService.delete(boardSeq);
		return "redirect:/board/boardlist.do";
	}

	@RequestMapping("/board/writeform")
	public ModelAndView privateWriteForm(){
		return new ModelAndView("board/write_form");
	}

	@RequestMapping("/board/write")
	public ModelAndView idCheckWrite(@ModelAttribute BoardDto dto, HttpSession session){
		dto.setWriter((String)session.getAttribute("id"));
		boardService.insert(dto);
		return new ModelAndView("redirect:/board/boardlist.do");
	}

	@RequestMapping("/board/commentInsert")
	public ModelAndView privateCommentInsert(@ModelAttribute BoardCommentDto dto,
			ModelAndView mView){
		mView = boardService.commentInsert(dto);
		return mView;
	}
}

