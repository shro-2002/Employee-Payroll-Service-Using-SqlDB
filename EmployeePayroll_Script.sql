
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

