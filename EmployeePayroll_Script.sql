
-- USE-CASE-1 Ability to create a payroll service database

CREATE DATABASE payroll_service;
SHOW DATABASES;
USE payroll_service;


-- USE-CASE-2 Ability to create a employee payroll table in the payroll service database to manage employee payrolls

CREATE TABLE employee_payroll (
    ID INT auto_increment primary key,
    Name VARCHAR(255) NOT NULL,
    Salary DECIMAL(10,2) NOT NULL,
    Start_Date DATE NOT NULL
);

-- USE-CASE-3 Ability to create employee payroll data in the payroll service database as part of CRUD Operation

INSERT INTO employee_payroll (name, salary, start_date)
VALUES 
    ('Avery Grambs', 65000.00, '2023-05-01'),
    ('Tobias Hawthorne', 80000.00, '2023-06-01'),
    ('Gray Hawthorne', 70000.00, '2023-07-01'),
    ('Jameson Hawthorne', 60000.00, '2023-08-01'),
    ('Nash Hawthorne', 72000.00, '2023-09-01');
    
-- USE-CASE-4 Retrieve the records of the table

SELECT * FROM employee_payroll;

-- USE-CASE-5 retrieve salary data for a particular employee as well as all employees who have joined in a particular data range from the payroll service database

SELECT salary 
FROM employee_payroll 
WHERE name = 'Gray Hawthorne';

SELECT * 
FROM employee_payroll 
WHERE start_date BETWEEN CAST('2023-07-01' AS DATE) AND now();

-- USE-CASE-6 Ability to add Gender to Employee Payroll Table and Update the Rows to reflect the correct Employee Gender
ALTER TABLE employee_payroll
ADD gender CHAR(1);

SET SQL_SAFE_UPDATES = 0;

UPDATE employee_payroll 
set gender ='M' 
Where Name in ('Tobias Hawthorne','Gray Hawthorne' , 'Jameson Hawthorne' , 'Nash Hawthorne');

UPDATE employee_payroll 
set gender ='F' 
Where Name in ('Avery Grambs');

-- USE-CASE-7: Ability to find sum, average, min, max and number of male and female employees

-- Sum of salary by gender
SELECT gender, SUM(salary) AS TotalSalary
FROM employee_payroll
GROUP BY gender;

-- Average salary by gender
SELECT gender, AVG(salary) AS AverageSalary
FROM employee_payroll
GROUP BY gender;

-- Minimum salary by gender
SELECT gender, MIN(salary) AS MinSalary
FROM employee_payroll
GROUP BY gender;

-- Maximum salary by gender
SELECT gender, MAX(salary) AS MaxSalary
FROM employee_payroll
GROUP BY gender;

-- Number of employees by gender
SELECT gender, COUNT(*) AS NumberOfEmployees
FROM employee_payroll
GROUP BY gender;


-- USE-CASE-8 Ability to extend employee_payroll data to store employee information like employee phone, address and department

ALTER TABLE employee_payroll
ADD  phone VARCHAR(15),
ADD address VARCHAR(255) default null ,
ADD department VARCHAR(50) NOT NULL;


-- USE-CASE-9 Ability to extend employee_payroll table to have Basic Pay, Deductions, Taxable Pay, Income Tax, Net Pay 

ALTER TABLE employee_payroll
ADD basic_pay DECIMAL(10,2),
ADD deductions DECIMAL(10,2),
ADD taxable_pay DECIMAL(10,2),
ADD income_tax DECIMAL(10,2),
ADD net_pay DECIMAL(10,2);

-- USE-CASE-10

UPDATE employee_payroll
SET department = 'Sales and Marketing'
WHERE Name = 'Terrisa Walker';


-- USE-CASE-11


-- Employee Table


CREATE TABLE employee (
    employee_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    gender CHAR(1),
    date_of_birth DATE
);

INSERT INTO employee (employee_id, name, salary, start_date, gender, date_of_birth)
VALUES
    (1, 'Gray Hawthorne', 60000.00, '2023-01-15', 'M', '2002-05-20'),
    (2, 'Avery Kylie', 70000.00, '2023-02-20', 'F', '2001-09-10'),
    (3, 'Bob Johnson', 80000.00, '2023-03-25', 'M', '2000-12-05'),
    (4, 'Terrisa Brown', 75000.00, '2023-04-10', 'F', '1999-07-15'),
    (5, 'Charlie Davis', 90000.00, '2023-05-15', 'M', '1998-03-30');


-- Company Table
CREATE TABLE company (
    company_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone_number VARCHAR(15),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

INSERT INTO company (company_id, name, address, phone_number, employee_id)
VALUES (1, 'ABC Corporation', '123 Main St', '555-1234', 1),
       (2, 'XYZ Enterprises', '456 Oak St', '555-5678', 2),
       (3, 'LMN Inc.', '789 Pine St', '555-9876', 3),
       (4, 'PQR Ltd.', '101 Elm St', '555-4321', 4),
       (5, 'UVW Industries', '202 Maple St', '555-8765', 5);


-- Payroll Table
CREATE TABLE payroll (
    payroll_id INT PRIMARY KEY,
    salary DECIMAL(10,2) NOT NULL,
    start_date DATE NOT NULL,
    basic_pay DECIMAL(10,2),
    deductions DECIMAL(10,2),
    taxable_pay DECIMAL(10,2),
	income_tax DECIMAL(10,2),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

INSERT INTO payroll (payroll_id, salary, start_date, basic_pay, deductions, taxable_pay, income_tax, employee_id)
VALUES
    (1, 60000.00, '2023-01-15', 55000.00, 5000.00, 50000.00, 2000.00, 1),
    (2, 70000.00, '2023-02-20', 65000.00, 5000.00, 60000.00, 2500.00, 2),
    (3, 80000.00, '2023-03-25', 72000.00, 8000.00, 64000.00, 3000.00, 3),
    (4, 75000.00, '2023-04-10', 70000.00, 5000.00, 65000.00, 2200.00, 4),
    (5, 90000.00, '2023-05-15', 85000.00, 7000.00, 78000.00, 3500.00, 5);

-- Department Table
CREATE TABLE department (
    department_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

INSERT INTO department (department_id, name, employee_id)
VALUES
    (1, 'Sales',1),
    (2, 'Marketing',2),
    (3, 'IT',3),
    (4, 'Finance',4),
    (5, 'Operations',5);

CREATE TABLE employee_department (
    employee_id INT,
    department_id INT,
    PRIMARY KEY (employee_id, department_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);

INSERT INTO employee_department (employee_id, department_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

-- Use Case 7: Ability to find sum, average, min, max, and the number of male and female employees

-- Sum of salary by gender
SELECT e.gender, SUM(p.salary) AS TotalSalary
FROM employee e
JOIN payroll p ON e.employee_id = p.employee_id
GROUP BY e.gender;

-- Average of salary by gender
SELECT e.gender , AVG(p.salary) AS AverageSalary
FROM employee e
JOIN payroll p ON e.employee_id= p.employee_id
GROUP BY e.gender;

-- Minimum of salary by gender
SELECT e.gender , MIN(p.salary) AS MinSalary
FROM employee e
JOIN payroll p ON e.employee_id= p.employee_id
GROUP BY e.gender;

-- Maximum of salary by gender
SELECT e.gender , MAX(p.salary) AS MaxSalary
FROM employee e
JOIN payroll p ON e.employee_id= p.employee_id
GROUP BY e.gender;




