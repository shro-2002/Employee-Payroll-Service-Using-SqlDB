
-- USE-CASE-1 Ability to create a payroll service database

CREATE DATABASE payroll_service;

SHOW DATABASES;

USE payroll_service;


-- USE-CASE-2 Ability to create a employee payroll table in the payroll service database to manage employee payrolls

CREATE TABLE employee_payroll (
    ID int auto_increment primary key,
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