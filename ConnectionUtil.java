package com.cognizant.customer.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static String url="jdbc:mysql://localhost:3306/java";
	private static String uname="root";
	private static String pass="4567";
	
	
	public static Connection getconnection() {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,uname,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return con;	
		
	}

}
