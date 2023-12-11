package com.bridgelabs.main;

import java.util.List;

import com.bridgelabs.exceptions.EmployeePayrollException;
import com.bridgelabs.pojo.EmployeePayroll;
import com.bridgelabs.retrieve.ReadData;

public class JDBCMain {

	public static void main(String[] args) throws EmployeePayrollException {
		ReadData readData = new ReadData();
//		try {
//
//			List<EmployeePayroll> payrollData = readData.getEmployeePayrollData();
//
//			for (EmployeePayroll payroll : payrollData) {
//				System.out.println(payroll.toString());
//			}
//
//		} catch (EmployeePayrollException e) {
//			e.printStackTrace();
//		}

		try {
			EmployeePayroll employee = readData.getEmployeeByName("Terrisa Walker");
			System.out.println(employee.toString());
		} catch (EmployeePayrollException e) {
			e.printStackTrace();
		}

	}

}
