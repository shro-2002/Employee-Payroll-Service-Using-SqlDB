package com.bridgelabs.exceptions;

/*
 * @Description: This class is used to throw exception for retrieving data from Employee Payroll Database
 * 
 * @Properties: serialVersionUID
 * 
 * @Behaviour: Parameterized Constructor
 * 
 */
public class EmployeePayrollException extends Exception {

	private static final long serialVersionUID = 1L;

	/*
	 * @Description: Throw exception for retrieving data from Employee Payroll
	 * Database
	 * 
	 * @Param: message, cause
	 * 
	 * @Return: voids
	 * 
	 */
	public EmployeePayrollException(Errors err) {
		super(err.getMessage());
	}

}
