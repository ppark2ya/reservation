package com.myproject.reservation.board.dto;

public class BoardCommentDto {
	private int boardSeq;		// 댓글의 글번호
	private String writer;
	private String content;
	private String targetId;	// 댓글의 대상이 되는 아이디
	private	int refGroup;		// 댓글 그룹
	private int commentGroup;	// 어떤 댓글에 대한 댓글들의 그룹 번호 
	private String regdate;
	
	public BoardCommentDto(){}

	public BoardCommentDto(int boardSeq, String writer, String content, String targetId, int refGroup, int commentGroup,
			String regdate) {
		super();
		this.boardSeq = boardSeq;
		this.writer = writer;
		this.content = content;
		this.targetId = targetId;
		this.refGroup = refGroup;
		this.commentGroup = commentGroup;
		this.regdate = regdate;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public int getRefGroup() {
		return refGroup;
	}

	public void setRefGroup(int refGroup) {
		this.refGroup = refGroup;
	}

	public int getCommentGroup() {
		return commentGroup;
	}

	public void setCommentGroup(int commentGroup) {
		this.commentGroup = commentGroup;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}

