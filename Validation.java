package com.cognizant.customer.util;

import java.util.Date;

public class Validation {
	
		public static boolean nameValidation(String name) {
			String arg1="[A-Za-z]+";
			if( name.matches(arg1)) {
				return true;
			}
			else {
				try {
					throw new userExceptions("only alphabets");
				} catch (userExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
		}
	    public static boolean numberValidation(String number) {
	    	String arg2="[0-9]{10}";
	    	if( number.matches(arg2)) {
	    		return true;
	    	}
	    	else {
	    		try {
					throw new userExceptions("enter 10 numbers");
				} catch (userExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
			return false;
	    	
	    }
	    public static boolean emailValidation(String email) {
	    	String arg3="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\.[a-zA-Z]{2,4}";
	    	if( email.matches(arg3)) {
	    		return true;
	    	}
	    	else {
	    		try {
					throw new userExceptions("enter mail like:'name@gmail.com'");
				} catch (userExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
			return false;
	    }
	    
	    public static boolean DateComparison(Date dte) throws userExceptions {
	    long now = System.currentTimeMillis();
	    Date sqlDate = new Date(now);
	    if(dte.compareTo(sqlDate)>=0) {
	    return true;
	    }
	    else {
	    throw new userExceptions("Date is not in range.\nEnter the correct date");
	    }
	    }


	

}
