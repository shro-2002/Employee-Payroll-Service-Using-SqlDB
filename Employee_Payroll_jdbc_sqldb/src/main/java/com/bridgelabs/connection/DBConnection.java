package com.bridgelabs.connection;

import java.sql.Connection;

public class DBConnection {
	
	static String url = "jdbc:mysql://localhost:3306/payroll_service"; 
	static String username = "root"; 
	static String password = "root";
	String query = "select *from employee_payroll";

	// method to connect to database
	public static void main(String[] arg) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection = java.sql.DriverManager.getConnection(url, username, password); 
			System.out.println("Connection established");
		} catch (Exception e) {
			System.out.println("Connection not established");
			e.printStackTrace();
		}
		System.out.print(connection);
	}

}
