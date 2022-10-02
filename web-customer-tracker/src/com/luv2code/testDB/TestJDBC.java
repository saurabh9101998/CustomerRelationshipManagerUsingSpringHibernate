package com.luv2code.testDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user = "springstudent";
		String password = "springstudent";

		try {
			System.out.println("Connecting to Database "+jdbcURL);
			Connection myConn = DriverManager.getConnection(jdbcURL,user,password); 
			System.out.println("Connected to Database "+jdbcURL);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
