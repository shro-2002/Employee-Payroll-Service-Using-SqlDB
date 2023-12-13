package com.bridgelabz.dboperations;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.bridgelabz.connection.DBConnection;
import com.bridgelabz.exceptions.EmployeePayrollException;
import com.bridgelabz.exceptions.Errors;
import com.bridgelabz.model.EmployeePayroll;

/*
 * @Description: This class is used to retrieve data from database
 * 
 * @Properties: List of EmployeePayroll
 * 
 * @Behaviour:  getEmployeePayrollData() method to retrieve data from database
 */

public class DatabaseOperations {

	Connection connection = DBConnection.DatabaseConnection();

	/*
	 * @Description: This method is used to retrieve data from database
	 * 
	 * @Param: void
	 * 
	 * @Exception: EmployeePayrollException
	 * 
	 * @Return: List of EmployeePayroll
	 * 
	 */
	public List<EmployeePayroll> getEmployeePayrollData() throws SQLException {
		List<EmployeePayroll> employeePayrolls = new ArrayList<>();
		String query = "SELECT * FROM employee_payroll";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String name = resultSet.getString("name");
				double salary = resultSet.getDouble("Salary");
				Date startDate = resultSet.getDate("Start_date");
				String gender = resultSet.getString("gender");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				String department = resultSet.getString("department");
				double deductions = resultSet.getDouble("deductions");
				double incometax = resultSet.getDouble("income_tax");

				EmployeePayroll employeePayroll = new EmployeePayroll(id, name, salary, startDate, gender, phone,
						address, department, deductions, incometax);
				employeePayrolls.add(employeePayroll);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeePayrollException(Errors.QUERY_ERROR);
		}
		return employeePayrolls;
	}

	/*
	 * @Description: This method is used to retrieve data from database by name
	 * 
	 * @Param: String name
	 * 
	 * @Exception: EmployeePayrollException
	 * 
	 * @Return: EmployeePayroll
	 * 
	 */
	public EmployeePayroll getEmployeeByName(String name) throws EmployeePayrollException {

		try {
			String query = "SELECT * FROM employee_payroll WHERE name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String name1 = resultSet.getString("Name");
				double salary = resultSet.getDouble("Salary");
				Date startDate = resultSet.getDate("Start_date");
				String gender = resultSet.getString("gender");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");
				String department = resultSet.getString("department");
				double incometax = resultSet.getDouble("income_tax");
				double deductions = resultSet.getDouble("deductions");
				return new EmployeePayroll(id, name1, salary, startDate, gender, phone, address, department, deductions,
						incometax);

			}

			else
				throw new EmployeePayrollException(Errors.NO_SUCH_EMPLOYEE);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeePayrollException(Errors.QUERY_ERROR);
		}

	}

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

	/*
	 * @Description: This method is used to retrieve employees who joined between a
	 * given date range
	 * 
	 * @Param: String start, String end
	 * 
	 * @Exception: EmployeePayrollException-> Errors.NO_SUCH_EMPLOYEE,
	 * Errors.QUERY_ERROR
	 * 
	 * @Return: void
	 */
	public void retrieveEmployeesByDateRange(Date start, Date end) throws SQLException {
		String query = "SELECT * FROM employee_payroll WHERE start_date BETWEEN ? AND ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, start);
			preparedStatement.setDate(2, end);

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
			throw new EmployeePayrollException(Errors.QUERY_ERROR);
		}

	}

	/*
	 * @Description: This method is used to retrieve and analyze employees' salary
	 * data for a given date range, grouped by gender (sum, avg, min, max, count).
	 *
	 * @Param: Date start, Date end
	 *
	 * @Exception: EmployeePayrollException-> Errors.NO_SUCH_EMPLOYEE,
	 * Errors.QUERY_ERROR
	 *
	 * @Return: void
	 */
	public void CalculateEmployeeSalariesByGender() throws SQLException {
		String query = "SELECT gender, SUM(salary) as sum_salary, AVG(salary) as avg_salary, "
				+ "MIN(salary) as min_salary, MAX(salary) as max_salary, COUNT(*) as employee_count "
				+ "FROM employee_payroll GROUP BY gender";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String gender = resultSet.getString("gender");
				double sumSalary = resultSet.getDouble("sum_salary");
				double avgSalary = resultSet.getDouble("avg_salary");
				double minSalary = resultSet.getDouble("min_salary");
				double maxSalary = resultSet.getDouble("max_salary");
				int employeeCount = resultSet.getInt("employee_count");

				System.out.println("Gender: " + gender);
				System.out.println("Sum Salary: " + sumSalary);
				System.out.println("Average Salary: " + avgSalary);
				System.out.println("Minimum Salary: " + minSalary);
				System.out.println("Maximum Salary: " + maxSalary);
				System.out.println("Employee Count: " + employeeCount);
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeePayrollException(Errors.QUERY_ERROR);
		}
	}
}
