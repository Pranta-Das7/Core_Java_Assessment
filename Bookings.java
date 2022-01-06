package com.cognizant.customer.beans;

import java.sql.Date;



public class Bookings {
	private int bookid;
	 private String  customername ;
	 private int roomid ;
	 private Date checkin ;
	 private Date checkout ;
	 private int totalprice ;
	 private String roomstatus ;
	
	
	@Override
	public String toString() {
		return "Bookings [bookid=" + bookid + ", customername=" + customername + ", roomid=" + roomid + ", checkin="
				+ checkin + ", checkout=" + checkout + ", totalprice=" + totalprice + ", roomstatus=" + roomstatus
				+ "]";
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date startdate) {
		this.checkin = startdate;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	public String getRoomstatus() {
		return roomstatus;
	}
	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	
}
