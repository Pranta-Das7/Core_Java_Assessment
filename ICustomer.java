package com.cognizant.customers.services;



import java.sql.Date;
import java.util.List;

import com.cognizant.customer.beans.Bookings;
import com.cognizant.customer.beans.Register;
import com.cognizant.customer.beans.room;
import com.cognizant.customer.util.userExceptions;

public interface ICustomer {
    public String addCustomer(Register c) throws userExceptions;
    public int Login(String email,String password);
    public String UpdateEmail(String email,int customerid);
    public List<Bookings> BookAroom(int roomid,Bookings b,Date checkin);
    public List<room> searchRoom(Bookings b,String roomtype);
    public List<Bookings> quit(int bookid);
    public double fetchPrice(Bookings br) ;
}