package com.bridgelabs.retrieve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bridgelabs.connection.DBConnection;
import com.bridgelabs.exceptions.EmployeePayrollException;
import com.bridgelabs.exceptions.Errors;
import com.bridgelabs.pojo.EmployeePayroll;

/*
 * @Description: This class is used to retrieve data from database
 * 
 * @Properties: List of EmployeePayroll
 * 
 * @Behaviour:  getEmployeePayrollData() method to retrieve data from database
 */

public class ReadData {

	List<EmployeePayroll> employeePayrolls = new ArrayList<>();
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
	public List<EmployeePayroll> getEmployeePayrollData() throws EmployeePayrollException {

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
				double basicPay = resultSet.getDouble("basic_pay");
				double deductions = resultSet.getDouble("deductions");
				double taxablePay = resultSet.getDouble("taxable_pay");
				double incomeTax = resultSet.getDouble("income_tax");
				double netPay = resultSet.getDouble("net_pay");

				EmployeePayroll employeePayroll = new EmployeePayroll(id, name, salary, startDate, gender, phone,
						address, department, basicPay, deductions, taxablePay, incomeTax, netPay);
				employeePayrolls.add(employeePayroll);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeePayrollException(Errors.QUERY_ERROR);
		}
		return employeePayrolls;
	}

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
				double basicPay = resultSet.getDouble("basic_pay");
				double deductions = resultSet.getDouble("deductions");
				double taxablePay = resultSet.getDouble("taxable_pay");
				double incomeTax = resultSet.getDouble("income_tax");
				double netPay = resultSet.getDouble("net_pay");

				return new EmployeePayroll(id, name1, salary, startDate, gender, phone, address, department, basicPay,
						deductions, taxablePay, incomeTax, netPay);
			}

			else
				throw new EmployeePayrollException(Errors.NO_SUCH_EMPLOYEE);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new EmployeePayrollException(Errors.QUERY_ERROR);
		}

	}

}
