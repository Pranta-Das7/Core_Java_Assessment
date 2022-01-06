package com.cognizant.customers.services;



import java.util.List;

import com.cognizant.customer.beans.Bookings;
import com.cognizant.customer.beans.Register;
import com.cognizant.customer.beans.room;
import com.cognizant.customer.util.userExceptions;
import com.cognizant.customers.dao.employeeDao;

public class Employeeimp implements IEmployee{
      employeeDao dao=new employeeDao();
	@Override
	public String AddRoom(room r) throws userExceptions {
		// TODO Auto-generated method stub
		return dao.AddRoom(r);
	}

	@Override
	public String DeleteRoom(int roomid) {
		// TODO Auto-generated method stub
		return dao.DeleteRoom(roomid);
	}

	@Override
	public String UpdateRoomid(int roomid,int newroomid) {
		// TODO Auto-generated method stub
		return dao.UpdateRoomid(roomid, newroomid);
	}

	@Override
	public List<room> getrooms() {
		// TODO Auto-generated method stub
		return dao.getrooms();
	}

	@Override
	public String UpdateRoomtype(int roomid, String roomtype) {
		// TODO Auto-generated method stub
		return dao.UpdateRoomtype(roomid, roomtype);
	}

	@Override
	public String Updateprice(int roomid, int price) {
		// TODO Auto-generated method stub
		return dao.Updateprice(roomid, price);
	}

	@Override
	public String Updateview(int roomid, String view) {
		// TODO Auto-generated method stub
		return dao.Updateview(roomid, view);
	}

	@Override
	public String UpdateRoomstatus(int roomid, String roomstatus) {
		// TODO Auto-generated method stub
		return dao.UpdateRoomstatus(roomid, roomstatus);
	}

	@Override
	public List<Register> AllCustomers() {
		// TODO Auto-generated method stub
		return dao.AllCustomers();
	}

	@Override
	public List<Bookings> AllBookings() {
		// TODO Auto-generated method stub
		return dao.AllBookings();
	}

	

}
