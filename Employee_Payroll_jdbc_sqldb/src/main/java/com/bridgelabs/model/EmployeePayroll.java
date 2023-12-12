package com.bridgelabs.model;

import java.util.Date;

/*
 * @Description: Employee Payroll Service to Read and Write Employee Payroll to a Console
 * 
 * @Properties: id,name,salary, startDate, gender, phone, address, department, basicPay, deductions, taxablePay, incomeTax, netPay
 * 
 * @Methods: Parameterized Constructor, Getter and Setter Methods
 * 
 */
public class EmployeePayroll {

	private int id;
	private String name;
	private double salary;
	private Date startDate;
	private String gender;
	private String phone;
	private String address;
	private String department;
	private double deductions;
	private double incomeTax;

	/*
	 * @Description: Parameterized Constructor to initialize the variables
	 * 
	 * @Param: name, empID, salary
	 * 
	 * @Return: void
	 * 
	 */
	public EmployeePayroll(int id, String name, double salary, Date startDate, String gender, String phone,
			String address, String department, double deductions, double incomeTax) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.startDate = startDate;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.department = department;
		this.deductions = deductions;
		this.incomeTax = incomeTax;
	}

	public EmployeePayroll() {

	}

	/*
	 * @Description: Getter Method to get the id of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: id
	 * 
	 */
	public int getId() {
		return id;
	}

	/*
	 * @Description: Setter Method to set the id of the employee
	 * 
	 * @Param: id
	 * 
	 * @Return: void
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * @Description: Getter Method to get the name of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: name
	 * 
	 */
	public String getName() {
		return name;
	}

	/*
	 * @Description: Setter Method to set the name of the employee
	 * 
	 * @Param: name
	 * 
	 * @Return: void
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * @Description: Getter Method to get the salary of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: salary
	 * 
	 */
	public double getSalary() {
		return salary;
	}

	/*
	 * @Description: Setter Method to set the salary of the employee
	 * 
	 * @Param: salary
	 * 
	 * @Return: void
	 * 
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/*
	 * @Description: Getter Method to get the start date of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: startDate
	 * 
	 */
	public Date getStartDate() {
		return startDate;
	}

	/*
	 * @Description: Setter Method to set the start date of the employee
	 * 
	 * @Param: startDate
	 * 
	 * @Return: void
	 * 
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/*
	 * @Description: Getter Method to get the gender of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: gender
	 * 
	 */
	public String getGender() {
		return gender;
	}

	/*
	 * @Description: Setter Method to set the gender of the employee
	 * 
	 * @Param: gender
	 * 
	 * @Return: void
	 * 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * @Description: Getter Method to get the phone of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: phone
	 * 
	 */
	public String getPhone() {
		return phone;
	}

	/*
	 * @Description: Setter Method to set the phone of the employee
	 * 
	 * @Param: phone
	 * 
	 * @Return: void
	 * 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*
	 * @Description: Getter Method to get the address of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: address
	 * 
	 */
	public String getAddress() {
		return address;
	}

	/*
	 * @Description: Setter Method to set the address of the employee
	 * 
	 * @Param: address
	 * 
	 * @Return: void
	 * 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * @Description: Getter Method to get the department of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: department
	 * 
	 */
	public String getDepartment() {
		return department;
	}

	/*
	 * @Description: Setter Method to set the department of the employee
	 * 
	 * @Param: department
	 * 
	 * @Return: void
	 * 
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/*
	 * @Description: Getter method to get the deductions of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: deductions
	 * 
	 */
	public double getDeductions() {
		return deductions;
	}

	/*
	 * @Description: Setter method to set the deductions of the employee
	 * 
	 * @Param: deductions
	 * 
	 * @Return: void
	 * 
	 */
	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	/*
	 * @Description: Getter method to get the income tax of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: incomeTax
	 * 
	 */
	public double getIncomeTax() {
		return incomeTax;
	}

	/*
	 * @Description: Setter method to set the income tax of the employee
	 * 
	 * @Param: incomeTax
	 * 
	 * @Return: void
	 * 
	 */
	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}

	/*
	 * @Description: Overriding toString method to print the details of the employee
	 * 
	 * @Param: void
	 * 
	 * @Return: String
	 * 
	 */
	@Override
	public String toString() {
		return "EmployeePayroll [id=" + id + ", name=" + name + ", salary=" + salary + ", startDate=" + startDate
				+ ", gender=" + gender + ", phone=" + phone + ", address=" + address + ", department=" + department
				+ ", deductions=" + deductions + ", incomeTax=" + incomeTax + "]";
	}

}