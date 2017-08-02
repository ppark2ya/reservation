package com.myproject.reservation.board.dto;

public class BoardCommentDto {
	private int board_num;		// 댓글의 글번호
	private String writer;
	private String content;
	private String target_id;	// 댓글의 대상이 되는 아이디
	private	int ref_group;		// 댓글 그룹
	private int comment_group;	// 어떤 댓글에 대한 댓글들의 그룹 번호 
	private String regdate;
	
	public BoardCommentDto(){}

	public BoardCommentDto(int board_num, String writer, String content, String target_id, int ref_group, int comment_group,
			String regdate) {
		super();
		this.board_num = board_num;
		this.writer = writer;
		this.content = content;
		this.target_id = target_id;
		this.ref_group = ref_group;
		this.comment_group = comment_group;
		this.regdate = regdate;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
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

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public int getRef_group() {
		return ref_group;
	}

	public void setRef_group(int ref_group) {
		this.ref_group = ref_group;
	}

	public int getComment_group() {
		return comment_group;
	}

	public void setComment_group(int comment_group) {
		this.comment_group = comment_group;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}

