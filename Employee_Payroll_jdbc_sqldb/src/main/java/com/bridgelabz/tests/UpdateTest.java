package com.bridgelabz.tests;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabz.dboperations.DatabaseOperations;
import com.bridgelabz.exceptions.EmployeePayrollException;
import com.bridgelabz.model.EmployeePayroll;

/*
 * @Description: This class is used to test the update operation.
 * 
 * @Properties: DatabaseUpdate databaseUpdate, ReadData readData, EmployeePayroll EmployeeUpdate
 * 
 * @Behavior: void test(), void UpdateEmployee()
 */
class UpdateTest {
	DatabaseOperations readData = new DatabaseOperations();
	EmployeePayroll EmployeeUpdate;

	/*
	 * @Description: This method is used to update the salary of an employee in the
	 * database
	 * 
	 * @Param: void
	 * 
	 * @Return: void
	 */
	@BeforeEach
	void UpdateEmployee() throws EmployeePayrollException {

		readData.updateSalaryInDatabase("Terrisa Walker", 3000000.00);

		EmployeeUpdate = readData.getEmployeeByName("Terrisa Walker");

	}

	/*
	 * @Description: This method is used to test the update operation.
	 * 
	 * @Param: void
	 * 
	 * @Return: void
	 */

	@Test
	void test() {

		assertEquals(3000000.00, EmployeeUpdate.getSalary());
	}

}
