package com.cognizant.customers.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.customer.beans.Bookings;
import com.cognizant.customer.beans.Register;
import com.cognizant.customer.beans.room;
import com.cognizant.customer.util.ConnectionUtil;
import com.cognizant.customer.util.userExceptions;

public class customerDao {
	Connection con=ConnectionUtil.getconnection();	
    public String addCustomer(Register c) throws userExceptions {
    	String sql="select count(*) from customer where customerid=?";
		PreparedStatement pstmt;
		try {
			 pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,c.getCustomerid());
			ResultSet rs=pstmt.executeQuery();
			int count=0;
			while(rs.next()) {
				count=rs.getInt(1);
			}
			if(count==0) {
				String sql1="insert into customer values(?,?,?,?,?)";
				try {
				PreparedStatement pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1, c.getCustomerid());
				pstmt1.setString(2, c.getName());
				pstmt1.setString(3, c.getEmailid());
				pstmt1.setString(4, c.getPhoneNumber());
				pstmt1.setString(5, c.getPassword());
				System.out.println(pstmt1.executeUpdate());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				throw new userExceptions("please enter the different customerid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success";
	}
    public String UpdateEmail(String email,int customerid) {
    	String sql3="update customer set emailid = ? where customerid=?";
 		PreparedStatement pstmt1;
 		try {
 			pstmt1 = con.prepareStatement(sql3);
 			pstmt1.setString(1, email);
 			pstmt1.setInt(2, customerid);
 			System.out.println(pstmt1.executeUpdate());
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		return "Success";
	}
    
    public int Login(String email,String password) {
    	int count=0;
		String sql="select count(*) from customer where emailid=? and password1=?";
		PreparedStatement pstmt;
 		try {
 			pstmt = con.prepareStatement(sql);
 			pstmt.setString(1,email);
 			pstmt.setString(2,password);
 			ResultSet rs=pstmt.executeQuery();
 			
 			    while( rs.next()) {
 				count=rs.getInt(1);
 			    }
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		return count;
	}
//    List<room> list1=new ArrayList<room>();
//    public List<room> allrooms(Bookings b){
//    	
//    	String sql="select rooms.roomid,roomtype,price,view,roomstatus from rooms where rooms.roomid not in (select roomid from booking where checkout > ?)";
//		PreparedStatement pstmt;
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setDate(1,b.getCheckin());
//			ResultSet rs=pstmt.executeQuery();
//			
//			
//			while(rs.next()) {
//				room r=new room();
//				r.setRoomid(rs.getInt(1));
//				r.setRoomtype(rs.getString(2));
//				r.setPrice(rs.getInt(3));
//				r.setView(rs.getString(4));
//				r.setRoomstatus(rs.getString(5));
//				list1.add(r);
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return list1;
//		
//	}
    public List<room> searchRoom(Bookings b,String roomtype) {
    	List<room> rl = new ArrayList<room>();
    	String ssql = "select rooms.roomid,roomtype,price,view,roomstatus  from rooms where roomtype=? and rooms.roomid not in (select roomid from booking where checkout > ? and checkin < ?) ";
    	try {
    	PreparedStatement sp = con.prepareStatement(ssql);
    	sp.setString(1, roomtype);
    	sp.setDate(2, b.getCheckin());
    	sp.setDate(3, b.getCheckout());
    	ResultSet rs = sp.executeQuery();
    	while (rs.next()) {
    	room r = new room();
    	
    	r.setRoomid(rs.getInt(1));
    	r.setRoomtype(rs.getString(2));
    	r.setPrice(rs.getInt(3));
    	r.setView(rs.getString(4));
    	r.setRoomstatus(rs.getString(5));
    	rl.add(r);
    	}
    	} catch (SQLException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	}
    	return rl;
    	}

    	

    
    
    public List<Bookings> BookAroom(int roomid,Date checkin,Bookings b) {
    	List<Bookings> list=new ArrayList<Bookings>();
		String sql1="insert into booking(customername,roomid,checkin,checkout,totalprice,roomstatus) values(?,?,?,?,?,?)"; 
    	PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql1);
			
			pstmt.setString(1, b.getCustomername());
			pstmt.setInt(2, b.getRoomid());
			pstmt.setDate(3,b.getCheckin());
			pstmt.setDate(4, b.getCheckout());
			pstmt.setInt(5, b.getTotalprice());
			pstmt.setString(6, b.getRoomstatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String sql3="select bookid,customername,roomid,checkin,checkout,totalprice,roomstatus from booking where roomid=? and checkin=?";
		
		PreparedStatement pstmt2;
		try {
    	   pstmt2=con.prepareStatement(sql3);
    	   pstmt2.setDate(2, (java.sql.Date) checkin);
    	   pstmt2.setInt(1, roomid);
    	   
    	  
    	   ResultSet rs=pstmt2.executeQuery();
    	   while(rs.next()) {
    		   
    		   b.setBookid(rs.getInt(1));
    		   b.setCustomername(rs.getString(2));
    		   b.setRoomid(rs.getInt(3));
    		   b.setCheckin(rs.getDate(4));
    		   b.setCheckout(rs.getDate(5));
    		   b.setTotalprice(rs.getInt(6));
    		   b.setRoomstatus(rs.getString(7));
    		   list.add(b);
    	   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return list;
	} 
    
    
    public List<Bookings> quit(int bookid) {
  	    String sql1="update booking set roomstatus='quit' where bookid=?";
    	PreparedStatement pstmt;
		try {
    	   pstmt=con.prepareStatement(sql1);
    	   pstmt.setInt(1, bookid);
    	   
    	   pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List<Bookings> list=new ArrayList<Bookings>();
		String sql3="select bookid,customername,roomid,checkin,checkout,totalprice,roomstatus from booking where bookid=? ";
		PreparedStatement pstmt2;
		try {
    	   pstmt2=con.prepareStatement(sql3);
    	   pstmt2.setInt(1, bookid);
    	   
    	  
    	   ResultSet rs=pstmt2.executeQuery();
    	   while(rs.next()) {
    		   Bookings b=new Bookings();
    		   b.setBookid(rs.getInt(1));
    		   b.setCustomername(rs.getString(2));
    		   b.setRoomid(rs.getInt(3));
    		   b.setCheckin(rs.getDate(4));
    		   b.setCheckout(rs.getDate(5));
    		   b.setTotalprice(rs.getInt(6));
    		   b.setRoomstatus(rs.getString(7));
    		   list.add(b);
    	   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	} 
	
    public double fetchPrice(Bookings br) {

    	double price = 0;
    	String ssql = "select price from rooms where roomid =? ";
    	try {
    	PreparedStatement sps = con.prepareStatement(ssql);
    	sps.setInt(1, (int) br.getRoomid());
    	ResultSet rs = sps.executeQuery();
    	rs.next();
    	price = rs.getDouble(1);

    	} catch (SQLException e1) {
    	// TODO Auto-generated catch block
    	e1.printStackTrace();
    	}
    	return price;
    	}
    
    
}