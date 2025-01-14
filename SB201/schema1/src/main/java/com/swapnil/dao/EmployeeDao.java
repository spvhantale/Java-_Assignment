package com.swapnil.dao;

import com.swapnil.bean.Employee;
import com.swapnil.exeption.EmployeeException;

public interface EmployeeDao {

	public Employee registerEmployee(Employee employee)throws EmployeeException;
	
	
	public Employee getEmployeeById(int empId)throws EmployeeException;
	
	public Employee deleteEmployeeById(int empId) throws EmployeeException;
	
	public Employee updateEmployee(Employee employee)throws EmployeeException;
	
	
	
	
}
