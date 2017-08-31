package com.myproject.reservation.admin.dto;

public class AdminDto {
	// Customer
	private String id;			// 회원 아이디(pk)
	private String name;		// 회원 이름
	private String phone;		// 회원 전화번호
	private String email;		// 회원 이메일
	private String custRegdate;	// 회원 가입일

	// Board
	private int boardSeq;			// 글번호(pk)
	private String writer;			// 작성자(fk - customerID)
	private String title;			// 글제목
	private String category;		// 글의 카테고리
	private String content;			// 글내용
	private int viewCount;			// 조회수
	private String boardRegdate;	// 작성일

	// BoardComment
	// private String boardSeq;		// 글번호(fk)
	private String commentWriter;	// 댓글 작성자(fk - customerID)
	private String commentContent;	// 댓글 내용
	private String targetId;		// 댓글의 대상이 되는 아이디
	private	int refGroup;			// 댓글 그룹
	private int commentGroup;		// 어떤 댓글에 대한 댓글들의 그룹 번호
	private String commentRegdate;	// 댓글 작성일

	// Room
	private int roomSeq;			// 객실번호(pk)
	private String roomName;		// 객실이름
	private int roomCharge;			// 객실의 가격
	private String roomDesc;		// 객실에 대한 설명
	private int availGuest;			// 객실 투숙 가능 인원 수
	private String smokingYn;		// 흡연 가능 여부
	private String bathAmenityYn;	// 세면 도구 비치 여부
	private String wifiFreeYn;		// 무료 와이파이 여부
	private String breakfastYn;		// 조식 여부
	private String imgSrc;			// 객실 이미지 경로

	private String checkIn;			// 체크인 날짜
	private String checkOut;		// 체크 아웃 날짜

	// RoomOrder
	// private int roomSeq;			// 객실 번호(fk)
	private String resvDate;		// 예약 날짜 (365일)
	private String resvYn;			// 예약 가능 여부

	// Reservation
	private int rvSeq;				// 예약 번호
	// private String id;			// 고객 아이디(fk - customerID)
	// private int roomSeq;			// 객실 번호(fk)
	// private String checkIn;		// 체크인 날짜
	// private String checkOut;		// 체크 아웃 날짜
	private int amount;				// 지불한 가격
	private String payment;			// 결제 수단
	private int numofRvcust;		// 객실에 예약한 인원 수

	public AdminDto(){}

	public AdminDto(String id, String name, String phone, String email, String custRegdate, int boardSeq, String writer,
			String title, String category, String content, int viewCount, String boardRegdate, String commentWriter,
			String commentContent, String targetId, int refGroup, int commentGroup, String commentRegdate, int roomSeq,
			String roomName, int roomCharge, String roomDesc, int availGuest, String smokingYn, String bathAmenityYn,
			String wifiFreeYn, String breakfastYn, String imgSrc, String checkIn, String checkOut, String resvDate,
			String resvYn, int rvSeq, int amount, String payment, int numofRvcust) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.custRegdate = custRegdate;
		this.boardSeq = boardSeq;
		this.writer = writer;
		this.title = title;
		this.category = category;
		this.content = content;
		this.viewCount = viewCount;
		this.boardRegdate = boardRegdate;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
		this.targetId = targetId;
		this.refGroup = refGroup;
		this.commentGroup = commentGroup;
		this.commentRegdate = commentRegdate;
		this.roomSeq = roomSeq;
		this.roomName = roomName;
		this.roomCharge = roomCharge;
		this.roomDesc = roomDesc;
		this.availGuest = availGuest;
		this.smokingYn = smokingYn;
		this.bathAmenityYn = bathAmenityYn;
		this.wifiFreeYn = wifiFreeYn;
		this.breakfastYn = breakfastYn;
		this.imgSrc = imgSrc;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.resvDate = resvDate;
		this.resvYn = resvYn;
		this.rvSeq = rvSeq;
		this.amount = amount;
		this.payment = payment;
		this.numofRvcust = numofRvcust;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustRegdate() {
		return custRegdate;
	}

	public void setCustRegdate(String custRegdate) {
		this.custRegdate = custRegdate;
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

	public String getBoardRegdate() {
		return boardRegdate;
	}

	public void setBoardRegdate(String boardRegdate) {
		this.boardRegdate = boardRegdate;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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

	public String getCommentRegdate() {
		return commentRegdate;
	}

	public void setCommentRegdate(String commentRegdate) {
		this.commentRegdate = commentRegdate;
	}

	public int getRoomSeq() {
		return roomSeq;
	}

	public void setRoomSeq(int roomSeq) {
		this.roomSeq = roomSeq;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomCharge() {
		return roomCharge;
	}

	public void setRoomCharge(int roomCharge) {
		this.roomCharge = roomCharge;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public int getAvailGuest() {
		return availGuest;
	}

	public void setAvailGuest(int availGuest) {
		this.availGuest = availGuest;
	}

	public String getSmokingYn() {
		return smokingYn;
	}

	public void setSmokingYn(String smokingYn) {
		this.smokingYn = smokingYn;
	}

	public String getBathAmenityYn() {
		return bathAmenityYn;
	}

	public void setBathAmenityYn(String bathAmenityYn) {
		this.bathAmenityYn = bathAmenityYn;
	}

	public String getWifiFreeYn() {
		return wifiFreeYn;
	}

	public void setWifiFreeYn(String wifiFreeYn) {
		this.wifiFreeYn = wifiFreeYn;
	}

	public String getBreakfastYn() {
		return breakfastYn;
	}

	public void setBreakfastYn(String breakfastYn) {
		this.breakfastYn = breakfastYn;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getResvDate() {
		return resvDate;
	}

	public void setResvDate(String resvDate) {
		this.resvDate = resvDate;
	}

	public String getResvYn() {
		return resvYn;
	}

	public void setResvYn(String resvYn) {
		this.resvYn = resvYn;
	}

	public int getRvSeq() {
		return rvSeq;
	}

	public void setRvSeq(int rvSeq) {
		this.rvSeq = rvSeq;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getNumofRvcust() {
		return numofRvcust;
	}

	public void setNumofRvcust(int numofRvcust) {
		this.numofRvcust = numofRvcust;
	}

}
