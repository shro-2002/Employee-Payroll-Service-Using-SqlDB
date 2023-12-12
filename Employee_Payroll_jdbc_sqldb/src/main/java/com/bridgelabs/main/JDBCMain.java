package com.bridgelabs.main;

import java.sql.SQLException;
import java.util.List;

import com.bridgelabs.datarange.DateRangeEmployee;
import com.bridgelabs.exceptions.EmployeePayrollException;
import com.bridgelabs.model.EmployeePayroll;
import com.bridgelabs.retrieve.ReadData;

public class JDBCMain {

	public static void main(String[] args) throws SQLException {
		ReadData readData = new ReadData();
		DateRangeEmployee datarange = new DateRangeEmployee();

		// UC: 2
		try {

			List<EmployeePayroll> payrollData = readData.getEmployeePayrollData();

			for (EmployeePayroll payroll : payrollData) {
				System.out.println(payroll.toString());
			}

		} catch (EmployeePayrollException e) {
			e.printStackTrace();
		}

		// UC-5
		try {
			System.out.println();
			System.out.println("Employee Joining between 2023-01-01 and 2023-05-01");
			datarange.retrieveEmployeesByDateRange("2023-01-01", "2023-05-01");
		}

		catch (EmployeePayrollException e) {
			e.printStackTrace();
		}

	}

}
