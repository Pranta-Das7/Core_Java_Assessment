package com.cognizant.customers.services;

import java.util.List;

import com.cognizant.customer.beans.Bookings;
import com.cognizant.customer.beans.Register;
import com.cognizant.customer.beans.room;
import com.cognizant.customer.util.userExceptions;

public interface IEmployee {
	public String AddRoom(room r)throws userExceptions ;
	
	public String DeleteRoom(int roomid);
	
	public String UpdateRoomid(int roomid,int newroomid);
	public String UpdateRoomtype(int roomid,String roomtype);
	public String Updateprice(int roomid,int price);
	public String Updateview(int roomid,String view);
	public String UpdateRoomstatus(int roomid,String roomstatus);
	
	
	public List<room> getrooms();
//	public void CheckStatus();
	public List<Bookings> AllBookings();
	public List<Register> AllCustomers();
	

}