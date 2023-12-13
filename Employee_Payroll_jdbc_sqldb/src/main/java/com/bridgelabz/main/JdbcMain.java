package com.bridgelabz.main;

import java.sql.Date;

import java.sql.SQLException;
import java.util.List;

import com.bridgelabz.dboperations.DatabaseOperations;
import com.bridgelabz.model.EmployeePayroll;

public class JdbcMain {

	public static void main(String[] args) throws SQLException {
		DatabaseOperations readData = new DatabaseOperations();

		Date startDate = Date.valueOf("2023-01-01");
		Date endDate = Date.valueOf("2023-05-01");

		// UC: 2

		List<EmployeePayroll> payrollData = readData.getEmployeePayrollData();
		for (EmployeePayroll payroll : payrollData) {
			System.out.println(payroll.toString());
		}

		// UC-5

		System.out.println();
		System.out.println("Employee Joining between " + startDate + " and " + endDate);
		readData.retrieveEmployeesByDateRange(startDate, endDate);

		// UC 6
		System.out.println();
		readData.CalculateEmployeeSalariesByGender();
	}

}
