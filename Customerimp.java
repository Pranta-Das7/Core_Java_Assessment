package com.cognizant.customers.services;



import java.sql.Date;
import java.util.List;

import com.cognizant.customer.beans.Bookings;
import com.cognizant.customer.beans.Register;
import com.cognizant.customer.beans.room;
import com.cognizant.customer.util.userExceptions;
import com.cognizant.customers.dao.customerDao;

public class Customerimp implements ICustomer{
       customerDao dao=new customerDao();
	@Override
	public String addCustomer(Register c) throws userExceptions {
		
		return dao.addCustomer(c);
	}
	@Override
	public String UpdateEmail(String email, int customerid) {
		// TODO Auto-generated method stub
		return dao.UpdateEmail(email, customerid);
	}
	@Override
	public int Login(String email, String password) {
		// TODO Auto-generated method stub
		return dao.Login(email, password);
	}
	
	
	@Override
	public List<Bookings> quit(int bookid) {
		// TODO Auto-generated method stub
		return dao.quit(bookid);
	}
	@Override
	public double fetchPrice(Bookings br) {
		// TODO Auto-generated method stub
		return dao.fetchPrice(br);
	}
	@Override
	public List<room> searchRoom(Bookings b,String roomtype) {
		// TODO Auto-generated method stub
		return dao.searchRoom(b,roomtype);
	}
	@Override
	public List<Bookings> BookAroom(int roomid, Bookings b,  Date checkin) {
		// TODO Auto-generated method stub
		return dao.BookAroom(roomid, checkin, b);
	}
	
	
	
	

}
