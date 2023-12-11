package com.bridgelabs.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bridgelabs.exceptions.EmployeePayrollException;
import com.bridgelabs.pojo.EmployeePayroll;
import com.bridgelabs.update.DatabaseUpdate;


/*
 * @Description: This class is used to test the update operation.
 * 
 * @Behavior: void test()
 */
class UpdateTest {

	/*
	 * @Description: This method is used to test the update operation.
	 * 
	 * @Param: void
	 * 
	 * @Return: void
	 */
	
	@Test
	void test() throws EmployeePayrollException {
		DatabaseUpdate databaseUpdate = new DatabaseUpdate();
		databaseUpdate.updateSalaryInDatabase("Terrisa Walker", 4000000.00);
		EmployeePayroll EmployeeUpdate = new EmployeePayroll();
		EmployeeUpdate.setSalary(3000000.00);
		assertEquals(3000000, EmployeeUpdate.getSalary());
	}

}
