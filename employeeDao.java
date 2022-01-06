package com.cognizant.customers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.customer.beans.Bookings;
import com.cognizant.customer.beans.Register;
import com.cognizant.customer.beans.room;
import com.cognizant.customer.util.ConnectionUtil;
import com.cognizant.customer.util.userExceptions;

public class employeeDao {
	Connection con=ConnectionUtil.getconnection();
	public String AddRoom(room r) throws userExceptions {
		String sql="select count(*) from rooms where roomid=?";
		PreparedStatement pstmt;
		try {
			 pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,r.getRoomid());
			ResultSet rs=pstmt.executeQuery();
			int count=0;
			while(rs.next()) {
				count=rs.getInt(1);
			}
			if(count==0) {
				String sql1="insert into rooms values(?,?,?,?,?)";
				try {
				PreparedStatement pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1, r.getRoomid());
				pstmt1.setString(2, r.getRoomtype());
				pstmt1.setInt(3, r.getPrice());
				pstmt1.setString(4, r.getView());
				pstmt1.setString(5, r.getRoomstatus());
				System.out.println(pstmt1.executeUpdate());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				throw new userExceptions("please enter the different roomid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success" ;
	}
	
	
	public String DeleteRoom(int roomid) {
		String sql1="select count(*) from rooms where roomid=?";
		PreparedStatement pstmt1;
		try {
			 pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1,roomid);
			ResultSet rs=pstmt1.executeQuery();
			int count=0;
			while(rs.next()) {
				count=rs.getInt(1);
			}
		
      if(count==1) {			
		 String sql="delete  from rooms where roomid=?";
		 try {
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, roomid);
				System.out.println(pstmt.executeUpdate());
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      }
      else {
    	  try {
			throw new userExceptions("please enter correct roomid");
		} catch (userExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      
		return "Success";
	}
	
	public String UpdateRoomid(int roomid,int newroomid) {
		
		String sql1="select count(*) from rooms where roomid=?";
		PreparedStatement pstmt1;
		try {
			 pstmt1=con.prepareStatement(sql1);
			pstmt1.setInt(1,roomid);
			ResultSet rs=pstmt1.executeQuery();
			int count=0;
			while(rs.next()) {
				count=rs.getInt(1);
			}
		
      if(count==1) {
		String sql="update rooms set roomid=? where roomid=?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newroomid);
			pstmt.setInt(2, roomid);
			System.out.println(pstmt.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      else {
    	  try {
			throw new userExceptions("please enter correct roomid");
		} catch (userExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "Success";
	}
	
	public String UpdateRoomtype(int roomid, String roomtype) {
		String sql3="update rooms set roomtype = ? where roomid=?";
 		PreparedStatement pstmt1;
 		try {
 			pstmt1 = con.prepareStatement(sql3);
 			pstmt1.setString(1, roomtype);
 			pstmt1.setInt(2, roomid);
 			System.out.println(pstmt1.executeUpdate());
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		
		return "Success";
	}
	
	public String Updateprice(int roomid, int price) {
		String sql4="update rooms set price = ? where roomid=?";
		PreparedStatement pstmt2;
		try {
			pstmt2 = con.prepareStatement(sql4);
			pstmt2.setInt(1, price);
			pstmt2.setInt(2, roomid);
			System.out.println(pstmt2.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}
	
	public String Updateview(int roomid, String view) {
		String sql5="update rooms set view = ? where roomid=?";
		PreparedStatement pstmt3;
		try {
			pstmt3 = con.prepareStatement(sql5);
			pstmt3.setString(1, view);
			pstmt3.setInt(2, roomid);
			System.out.println(pstmt3.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}

	public String UpdateRoomstatus(int roomid, String roomstatus) {
		 String sql6="update rooms set roomstatus = ? where roomid=?";
			PreparedStatement pstmt4;
			try {
				pstmt4 = con.prepareStatement(sql6);
				pstmt4.setString(1, roomstatus);
				pstmt4.setInt(2, roomid);
				System.out.println(pstmt4.executeUpdate());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return "Success";
	}

	public List<room> getrooms() {
		List<room> list=new ArrayList<room>();
		
		String sql="select roomid,roomtype,price,view,roomstatus from rooms";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				room r=new room();
				r.setRoomid(rs.getInt(1));
				r.setRoomtype(rs.getString(2));
				r.setPrice(rs.getInt(3));
				r.setView(rs.getString(4));
				r.setRoomstatus(rs.getString(5));
				list.add(r);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}
	
	public List<Register> AllCustomers() {
		// TODO Auto-generated method stub
       List<Register> list=new ArrayList<Register>();
		
		String sql="select customerid,name1,emailid,phonenumber,password1 from customer";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				Register c=new Register();
				c.setCustomerid(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmailid(rs.getString(3));
				c.setPhoneNumber(rs.getString(4));
				c.setPassword(rs.getString(5));
				
				list.add(c);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return list;
	}
	
	
	public List<Bookings> AllBookings() {
		List<Bookings> list=new ArrayList<Bookings>();
		String sql3="select bookid,customername,roomid,checkin,checkout,totalprice,roomstatus from booking";
		PreparedStatement pstmt2;
		try {
    	   pstmt2=con.prepareStatement(sql3);
    	  
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
}
