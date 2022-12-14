package com.luv2code.testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setup connection variables
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user = "springstudent";
		String password = "springstudent";
		String driver = "com.mysql.jdbc.Driver";

		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database - "+jdbcURL);
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(jdbcURL,user,password);
			
			out.println("Connection succssful");
			
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
