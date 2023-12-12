package com.bridgelabs.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bridgelabs.connection.DBConnection;
import com.bridgelabs.exceptions.EmployeePayrollException;
import com.bridgelabs.exceptions.Errors;

/*
 * @Description: This class is used to update the salary of an employee in the database Using PreparedStatement.
 * 
 * @Behavior: void updateSalaryInDatabase(String employeeName, double newSalary)
 */

public class DatabaseUpdate {
	Connection connection = DBConnection.DatabaseConnection();

	/*
	 * @Description: This method is used to update the salary of an employee in the
	 * database Using PreparedStatement.
	 * 
	 * @Exception: EmployeePayrollException-> Errors.NO_SUCH_EMPLOYEE,
	 * Errors.QUERY_ERROR
	 * 
	 * @Param: String employeeName, double newSalary
	 * 
	 * @Return: void
	 */
	public void updateSalaryInDatabase(String employeeName, double newSalary) throws EmployeePayrollException {

		String query = "UPDATE employee_payroll SET salary = ? WHERE name = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, newSalary);
			preparedStatement.setString(2, employeeName);

			int result = preparedStatement.executeUpdate();
			connection.close();
			if (result == 0) {
				throw new EmployeePayrollException(Errors.NO_SUCH_EMPLOYEE);
			}
		}

		// Catching row not found error
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error type: " + Errors.QUERY_ERROR);
		}

	}
}
