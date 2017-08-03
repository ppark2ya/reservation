package com.myproject.reservation.board.dto;

public class BoardDto {
	private int boardSeq;		// 글번호
	private String writer;	// 작성자
	private String title;	// 글제목
	private String category;
	private String content;	// 글내용
	private int viewCount;
	private String regdate;	// 작성일
	
	private int startRowNum; // 시작 row 번호
	private int endRowNum;	 // 끝 row 번호
	private int prevNum;	// 이전 글의 글 번호
	private int nextNum;	// 다음 글의 글 번호

	// 디폴트 생성자
	public BoardDto(){}

	public BoardDto(int boardSeq, String writer, String title, String category, String content, int viewCount,
			String regdate, int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.boardSeq = boardSeq;
		this.writer = writer;
		this.title = title;
		this.category = category;
		this.content = content;
		this.viewCount = viewCount;
		this.regdate = regdate;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
	}

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}


}
