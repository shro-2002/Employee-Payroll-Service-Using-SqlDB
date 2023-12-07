
-- USE-CASE-1 

CREATE DATABASE payroll_service;

SHOW DATABASES;

USE payroll_service;


-- USE-CASE-2

CREATE TABLE employee_payroll (
    ID int auto_increment primary key,
    Name VARCHAR(255) NOT NULL,
    Salary DECIMAL(10,2) NOT NULL,
    Start_Date DATE NOT NULL
);

-- USE-CASE-3

INSERT INTO employee_payroll (name, salary, start_date)
VALUES 
    ('Avery Grambs', 65000.00, '2023-05-01'),
    ('Tobias Hawthorne', 80000.00, '2023-06-01'),
    ('Gray Hawthorne', 70000.00, '2023-07-01'),
    ('Jameson Hawthorne', 60000.00, '2023-08-01'),
    ('Nash Hawthorne', 72000.00, '2023-09-01');
    
-- USE-CASE-4

SELECT * FROM employee_payroll;

-- USE-CASE-5 retrieve salary data for a particular employee as well as all employees who have joined in a particular data range from the payroll service database

SELECT salary 
FROM employee_payroll 
WHERE name = 'Gray Hawthorne';

SELECT * 
FROM employee_payroll 
WHERE start_date BETWEEN CAST('2023-07-01' AS DATE) AND now();