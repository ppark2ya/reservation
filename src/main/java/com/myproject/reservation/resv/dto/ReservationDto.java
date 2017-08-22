package com.myproject.reservation.resv.dto;

/*
 * create table reservation(
    rv_seq     number primary key,		-- 예약 번호(pk)
    id     		varchar2(30),	-- 고객 아이디(fk)
    room_seq	number,			-- 객실 고유 번호(fk)
    checkin     varchar2(30),	-- 체크인 날짜
    checkout    varchar2(30),	-- 체크아웃 날짜
    amount      number,			-- 결제 요금
    payment     varchar2(10),	-- 결제 수단(cash/card)
    numof_rvcust number			-- 예약 인원
	);
 *
 */
public class ReservationDto {
	private int rvSeq;
	private String id;
	private int roomSeq;
	private String checkIn;
	private String checkOut;
	private int amount;
	private String payment;
	private int numofRvcust;

	public ReservationDto(){}

	public ReservationDto(int rvSeq, String id, int roomSeq, String checkIn, String checkOut, int amount,
			String payment, int numofRvcust) {
		super();
		this.rvSeq = rvSeq;
		this.id = id;
		this.roomSeq = roomSeq;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.amount = amount;
		this.payment = payment;
		this.numofRvcust = numofRvcust;
	}

	public int getRvSeq() {
		return rvSeq;
	}

	public void setRvSeq(int rvSeq) {
		this.rvSeq = rvSeq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRoomSeq() {
		return roomSeq;
	}

	public void setRoomSeq(int roomSeq) {
		this.roomSeq = roomSeq;
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
