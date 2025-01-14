package com.swapnil.dao;

import java.util.List;

import com.swapnil.exception.DepartmentException;
import com.swapnil.exception.EmployeeException;
import com.swapnil.model.Department;
import com.swapnil.model.Employee;

public interface EmployeeDao {

	public void addDepartment(Department dept);
	
	public void addEmployee(Employee emp);
	
	public void registerEmployeeTODepartment(int empId, int deptId)throws EmployeeException, DepartmentException;
	
	public List<Employee> getAllEmployeeWithDeptName(String deptName)throws EmployeeException;
	 
	public Department getDepartmentDetailsByEmployeeId(int empId)throws DepartmentException;
}

