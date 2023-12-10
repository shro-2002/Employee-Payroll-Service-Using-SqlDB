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

SELECT e.gender , COUNT(*) AS NumberOfFemale
FROM employee e
JOIN payroll p ON e.employee_id= p.employee_id
GROUP BY e.gender;

-- USE-CASE-12

-- REDO USE-CASE-4
SELECT * FROM payroll;

-- REDO USE-CASE-5

SELECT e.name,p.salary
FROM  payroll p
JOIN employee e ON e.employee_id = p.employee_id
WHERE e.name = 'Bob Johnson';

SELECT * 
FROM payroll 
WHERE start_date BETWEEN CAST('2023-03-01' AS DATE) AND NOW();