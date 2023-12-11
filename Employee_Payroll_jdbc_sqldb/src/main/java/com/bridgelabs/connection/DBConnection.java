package com.bridgelabs.connection;

import java.sql.Connection;

/*
 * @Description: This class is used to establish connection with database
 * 
 * @Properties: url, username, password
 * 
 * @Behaviour: DatabaseConnection()
 */
public class DBConnection {
	
	static String url = "jdbc:mysql://localhost:3306/payroll_service"; 
	static String username = "root"; 
	static String password = "root";


	/*
	 * @Description: This method is used to establish connection with database
	 * 
	 * @Param: void
	 * 
	 * @Return Type: void
	 *
	 * @Exception: ClassNotFoundException, SQLException, SQLTimeoutException
	 */
	public static Connection DatabaseConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			connection = java.sql.DriverManager.getConnection(url, username, password); 
			System.out.println("Connection established");
		} catch (Exception e) {
			System.out.println("Connection not established");
		}
		return connection;
	}

}
