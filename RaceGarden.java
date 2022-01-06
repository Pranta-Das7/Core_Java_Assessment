package com.cognizant.customer.main;

import java.sql.Connection;
import java.sql.Date;
import com.cognizant.customers.services.*;
import java.util.Scanner;


import com.cognizant.customer.beans.*;

import com.cognizant.customer.util.ConnectionUtil;
import com.cognizant.customer.util.Utility;
import com.cognizant.customer.util.UtilityTest;
import com.cognizant.customer.util.Validation;
import com.cognizant.customer.util.userExceptions;

public class RaceGarden {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		
		
		Scanner src=new Scanner(System.in);
		Register reg=new Register();
		room roo=new room();
        Bookings boo=new Bookings();  
		
		Connection con=ConnectionUtil.getconnection();
		
		IEmployee employeeService=new Employeeimp();
		ICustomer customerService=new Customerimp();
		
		while(true) {
		System.out.println("enter 1: employee,\n enter 2: customer \n enter 3: exit");
		int n=src.nextInt();
		switch(n) {
		case 1:boolean emp=true;
			while(emp) {
			System.out.println("Employee....... ");
		System.out.println("enter 1: add a room\n enter 2: delete a room"
				+ "\n enter 3:update a room"
				+ "\n enter 4:display all rooms"
				+ "\n enter 5:all customers"
				+ "\n enter 6: all bookings"
				+ "\n enter 7: exit"
			);
		int e=src.nextInt();
		switch(e) {
		case 1: System.out.println("ADD A ROOM");
		System.out.println("roomid");
		        int roomid=src.nextInt();
		        roo.setRoomid(roomid);
		        System.out.println("room type");
		        String roomtype=src.next();
		        roo.setRoomtype(roomtype);
		        System.out.println("price");
		        int price =src.nextInt();
		        roo.setPrice(price);
		        System.out.println("view");
		        String view=src.next();
		        view=view +src.nextLine();
		        roo.setView(view);
		        System.out.println("room status");
		        String roomstatus=src.next();
		        roo.setRoomstatus(roomstatus);
		        
			try {
				employeeService.AddRoom(roo);
			} catch (userExceptions e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		       
		break;
		case 2: System.out.println("delete a room");
		System.out.println("enter a room id");
		int roomid1=src.nextInt();
	 
		  employeeService.DeleteRoom(roomid1);
			 
		
		 
		 
		 
			break;
		case 3:
			System.out.println("update a room");
		
		
		
		System.out.println("enter roomid");
        int roomids=src.nextInt();
        
   		     
   		
       boolean oo=true;
       while(oo){
      System.out.println("enter 1:roomid\n enter 2: roomtype\n enter 3:price \n enter 4:view\n enter 5: roomstatus \n enter 6:exit");
      int s=src.nextInt();
      switch(s) {
      case 1: System.out.println("enter new roomid");
              int newroomid=src.nextInt();
              employeeService.UpdateRoomid(roomids, newroomid);
			  
      break;
      case 2:System.out.println("enter roomtype");
             String roomtype1=src.next();
             employeeService.UpdateRoomtype(roomids, roomtype1);
    	  break;
      case 3: System.out.println("enter price");
              int price1=src.nextInt();
              employeeService.Updateprice(roomids, price1);
    	  break;
      case 4:System.out.println("enter view");
             String view2=src.next();
             view2=view2+src.nextLine();
             employeeService.Updateview(roomids, view2);
    	  break;
      case 5:System.out.println("enter roomstatus");
             String roomstatus1=src.next();
             employeeService.UpdateRoomstatus(roomids, roomstatus1);
      
    	  break;
      case 6:oo=false;
             break;
     }
  }
	
			break;
		case 4:
			    System.out.println("all rooms");
			    Utility.generateRoomsXml(employeeService.getrooms());
		        UtilityTest.roomXmlTest();
			break;
		case 5:  System.out.println("all customers");
			      Utility.generateXml(employeeService.AllCustomers());
			      UtilityTest.customerxml();
			      
			
			break;
		case 6: System.out.println(" all bookings");	
		        Utility.generateBookingsXml(employeeService.AllBookings());
		        UtilityTest.bookingXmlTest();
		break;
		case 7:emp=false;break;
		}
		}
		
		
		break;
		
		case 2: boolean cus=true;
			while(cus) {
			System.out.println("Customer......");
		
		System.out.println("enter 1: register\n enter 2: login"
				+"\n enter 3:exit");
		int c=src.nextInt();
		switch(c) {
		case 1:
			while(true) {
		           System.out.println("enter your name");
		            String name=src.next();
		            if(Validation.nameValidation(name)) {
		        	    reg.setName(name);
		        	    break;
		            }
		            
		           }
		           while(true) {
		           System.out.println("enter email id");
		           String em=src.next();
		           if(Validation.emailValidation(em)) {
		             reg.setEmailid(em);
		             break;
		           }
		           
		           }
		           while(true) {
		           System.out.println("enter phone number");
		           String num=src.next();
		           if(Validation.numberValidation(num)) {
		             reg.setPhoneNumber(num);
		             break;
		           }
		           
		           }
		           System.out.println("enter password");
		           reg.setPassword(src.next());
		           System.out.println("enter customer id");
		           reg.setCustomerid(src.nextInt());
			try {
				customerService.addCustomer(reg);
			} catch (userExceptions e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;
		case 2:System.out.println("enter email");
		      String email=src.next();
		      String email1=null;
		      if(Validation.emailValidation(email)) {
		    	   email1 = email;
		      }
		      System.out.println("enter password");
		      String pass=src.next();
		      
		      
		      System.out.println(customerService.Login(email, pass));
		      
			if(customerService.Login(email1, pass)==1) {
		    	  System.out.println("login successful");
		    	  boolean opn=true;
		    	  while(opn) {
		    	  System.out.println("enter 1:email update\n enter 2: book a room\n"  
		    	  					+ "\n enter 3: quit\n enter 4: exit");
		    	  int l=src.nextInt();
		    	  int id = 0;
				switch(l) {
		    	  case 1:    for(Register d:employeeService.AllCustomers()) {
			            	if(d.getEmailid().matches(email))
   			            		id=d.getCustomerid();
   			            }
		    	        
		    	        	 System.out.println("enter new email");
		    	        	 String email2=src.next();
		    	        	 email=email2;
		    	        	 if(Validation.emailValidation(email1)) { 
		    	        	   customerService.UpdateEmail(email1, id);
		   					
		    	        	   break;
		    	         
		    	         }
		    		  break;
		    	  case 2:  System.out.println("Book a room");
		    		  
			            

		    	  String roomtype = null;
		    	  Date dte;
		    	  while(true) {
		    		  
		    		  System.out.println("enter roomtype");
		    		  System.out.println(" roomtype : AC ,NONAC, conference, banquet");
		    		   roomtype=src.next();
		    		  System.out.println("Enter the CheckIn date ");
		    		  String dt = src.next();
		    		   dte = Date.valueOf(dt);
		    		  try {
		    		  if(Validation.DateComparison(dte)) {
		    		  boo.setCheckin(dte);
		    		  break;
		    		  }
		    		  } catch (userExceptions e) {
		    		  // TODO Auto-generated catch block
		    		  e.printStackTrace();
		    		  }

		    		  }
		    		  while(true) {
		    		  System.out.println("Enter the CheckOut date");
		    		  String dt1 = src.next();
		    		  Date dte1 = Date.valueOf(dt1);
		    		  try {
		    		  if(Validation.DateComparison(dte1)) {
		    		  boo.setCheckout(dte1);
		    		  break;
		    		  }
		    		  } catch (userExceptions e) {
		    		  // TODO Auto-generated catch block
		    		  e.printStackTrace();
		    		  }
		    		  }

		    		 
					
					System.out.println(customerService.searchRoom(boo,roomtype));

		    		  System.out.println("Enter the room number you want to book");
		    		  int brid = src.nextInt();
		    		  roo.setRoomid(brid);
		    		  boo.setRoomid(brid);
		    		  int rp = (int)customerService.fetchPrice(boo);
		    		  boo.setTotalprice(rp);
		    		  java.util.Date endDate = new java.util.Date(boo.getCheckout().getTime());
		    		  java.util.Date startDate = new java.util.Date(boo.getCheckin().getTime());
		    		  long diff = endDate.getTime() - startDate.getTime();
		    		  long dateDiff = (diff/(1000 * 60 * 60 * 24)) % 365;
		    		  int price = (int) (dateDiff*boo.getTotalprice());
		    		  boo.setTotalprice(price);
		    		  System.out.println("Enter your employee name to confirm booking");
		    		  String epid = src.next();
		    		  boo.setCustomername(epid);
		    		  boo.setRoomstatus("booked");
		    		  
					
					System.out.println(customerService.BookAroom(brid, boo,dte));
		    		  break;
		    	  
			   		case 3: System.out.println("quit");
			   		        System.out.println("enter bookid");
			   		        int bookid=src.nextInt();
			   		        
			   		       
			   		        System.out.println(customerService.quit(bookid));
			   		
                            break;
	                case 4: opn =false;
                            break;
			   			        
			   	 }
					     }
                                 }
		 
	     else {
		    	  try {
					throw new userExceptions("enter correct email and password");
				} catch (userExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		      
		  break;    
		
		
		case 3: cus=false;
		break;
		
		
	}		    	  
 }  
			
		break;	
	  
		
		case 3: System.exit(1);
		break;
	 }
		
  }
}
}