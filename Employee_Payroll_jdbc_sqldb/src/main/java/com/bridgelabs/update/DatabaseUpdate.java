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

	/*
	 * @Description: This method is used to update the salary of an employee in the database Using PreparedStatement.
	 * 
	 * @Exception: EmployeePayrollException-> Errors.NO_SUCH_EMPLOYEE, Errors.QUERY_ERROR
	 * 
	 * @Param: String employeeName, double newSalary
	 * 
	 * @Return: void
	 */
	public void updateSalaryInDatabase(String employeeName, double newSalary) throws EmployeePayrollException {
		try (Connection connection = DBConnection.DatabaseConnection()) {
			String query = "UPDATE employee_payroll SET salary = ? WHERE name = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setDouble(1, newSalary);
				preparedStatement.setString(2, employeeName);

				int result = preparedStatement.executeUpdate();
				if (result == 0) {
					throw new EmployeePayrollException(Errors.NO_SUCH_EMPLOYEE);
				}
			}

			// Catching row not found  errors
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error type: " + Errors.NO_SUCH_EMPLOYEE);
			}

			// Catching other possible exceptions
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeePayrollException(Errors.QUERY_ERROR);
		}
	}

}
