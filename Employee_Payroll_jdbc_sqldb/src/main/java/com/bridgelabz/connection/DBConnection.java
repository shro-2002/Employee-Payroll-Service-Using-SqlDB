package com.bridgelabz.connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/*
 * @Description: This class is used to establish connection with database
 * 
 * @Properties: url, username, password
 * 
 * @Behaviour: DatabaseConnection()
 */
public class DBConnection {

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
			// Load the config file
			Properties props = new Properties();
			String filePath = "ConfigDetails/config.properties";
			FileInputStream input = new FileInputStream(filePath);
			props.load(input);

			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");

			// Load Class Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = java.sql.DriverManager.getConnection(url, username, password);
			System.out.println("Connection established");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection not established");
		}
		return connection;
	}

}
