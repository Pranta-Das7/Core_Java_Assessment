package com.cognizant.customer.beans;

public class Room {
	
    private int roomid;
    private String roomtype;
    private int price;
    private String view;
    private String roomstatus;
    
    
    
	@Override
	public String toString() {
		return "room [roomid=" + roomid + ", roomtype=" + roomtype + ", price=" + price + ", view=" + view
				+ ", roomstatus=" + roomstatus + "]"+"\n";
	}
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getRoomstatus() {
		return roomstatus;
	}
	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}
    
     
	
	
}
