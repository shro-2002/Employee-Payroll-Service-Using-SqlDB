package com.bridgelabs.main;

import java.util.List;

import com.bridgelabs.exceptions.EmployeePayrollException;
import com.bridgelabs.pojo.EmployeePayroll;
import com.bridgelabs.retrieve.ReadData;

public class JDBCMain {

	public static void main(String[] args) throws EmployeePayrollException {
		try {
			ReadData readData = new ReadData();
			List<EmployeePayroll> payrollData = readData.getEmployeePayrollData();

			for (EmployeePayroll payroll : payrollData) {
				System.out.println(payroll.toString());
			}

		} catch (EmployeePayrollException e) {
			e.printStackTrace();
		}

	}

}
