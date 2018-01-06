package oracle.java.s20180102.model;

import java.sql.Date;

public class ReservDto {
	private String memberId;
	private int gServNo;
	private int gNo;
	private String payCode;
	private Date reservDate;
	private Date tourDate;
	private String pay_yn;
	private int reMemSize;
	private String cancel_yn;
	private String success_yn;
	private String confirm;
	
	
	//------------------
	//    지영 추가
	
	private String gServTitle;
	private String amount;
	private int rvNum;
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getgServTitle() {
		return gServTitle;
	}
	public void setgServTitle(String gServTitle) {
		this.gServTitle = gServTitle;
	}
	public int getRvNum() {
		return rvNum;
	}
	public void setRvNum(int rvNum) {
		this.rvNum = rvNum;
	}
	//--------------------------------
	
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getgServNo() {
		return gServNo;
	}
	public void setgServNo(int gServNo) {
		this.gServNo = gServNo;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	public Date getReservDate() {
		return reservDate;
	}
	public void setReservDate(Date reservDate) {
		this.reservDate = reservDate;
	}
	public Date getTourDate() {
		return tourDate;
	}
	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}
	public String getPay_yn() {
		return pay_yn;
	}
	public void setPay_yn(String pay_yn) {
		this.pay_yn = pay_yn;
	}
	public int getReMemSize() {
		return reMemSize;
	}
	public void setReMemSize(int reMemSize) {
		this.reMemSize = reMemSize;
	}
	public String getCancel_yn() {
		return cancel_yn;
	}
	public void setCancel_yn(String cancel_yn) {
		this.cancel_yn = cancel_yn;
	}
	public String getSuccess_yn() {
		return success_yn;
	}
	public void setSuccess_yn(String success_yn) {
		this.success_yn = success_yn;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	
}	
