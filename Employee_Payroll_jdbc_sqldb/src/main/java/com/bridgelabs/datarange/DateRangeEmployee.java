package com.bridgelabs.datarange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bridgelabs.connection.DBConnection;
import com.bridgelabs.exceptions.EmployeePayrollException;
import com.bridgelabs.exceptions.Errors;


/*
 * @Description: This class is used to retrieve employees who joined between a given date range
 * 
 * @Properties: q
 * 
 * @Behaviour: RetrieveEmployeesByDateRange(String start, String end)
 */
public class DateRangeEmployee {

	String query = "SELECT * FROM employee_payroll WHERE start_date BETWEEN ? AND ?";
	Connection connection = DBConnection.DatabaseConnection();

	/*
	 * @Description: This method is used to retrieve employees who joined between a given date range
	 * 
	 * @Param: String start, String end
	 * 
	 * @Exception: EmployeePayrollException-> Errors.NO_SUCH_EMPLOYEE, Errors.QUERY_ERROR
	 * 
	 * @Return: void
	 */
	public void retrieveEmployeesByDateRange(String start, String end) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, convertStringToDate(start));
			preparedStatement.setDate(2, convertStringToDate(end));

			try {
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					Date startdate = resultSet.getDate("Start_Date");

					System.out.println("ID: " + id + " Name: " + name + " Join Date: " + startdate);

				}
			}

			catch (SQLException e) {
				e.printStackTrace();
				throw new EmployeePayrollException(Errors.NO_SUCH_EMPLOYEE);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeePayrollException(Errors.QUERY_ERROR);
		}

		connection.close();
	}

	/*
	 * @Description: This method is used to convert String to Date
	 * 
	 * @Param: String dateString
	 * 
	 * @Exception: RuntimeException
	 * 
	 * @Return: java.sql.Date
	 */
	private static java.sql.Date convertStringToDate(String dateString) {
		try {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = dateFormat.parse(dateString);
			return new java.sql.Date(parsedDate.getTime());
		}

		catch (ParseException e) {
			throw new RuntimeException("Error converting date", e);
		}
	}

}
