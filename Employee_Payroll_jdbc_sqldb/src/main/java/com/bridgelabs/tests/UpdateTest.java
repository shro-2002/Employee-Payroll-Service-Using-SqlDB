package com.bridgelabs.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabs.exceptions.EmployeePayrollException;
import com.bridgelabs.model.EmployeePayroll;
import com.bridgelabs.retrieve.ReadData;
import com.bridgelabs.update.DatabaseUpdate;

/*
 * @Description: This class is used to test the update operation.
 * 
 * @Properties: DatabaseUpdate databaseUpdate, ReadData readData, EmployeePayroll EmployeeUpdate
 * 
 * @Behavior: void test(), void UpdateEmployee()
 */
class UpdateTest {
	DatabaseUpdate databaseUpdate = new DatabaseUpdate();
	ReadData readData = new ReadData();
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

		databaseUpdate.updateSalaryInDatabase("Terrisa Walker", 6000000.00);

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

		assertEquals(6000000.00, EmployeeUpdate.getSalary());
	}

}
