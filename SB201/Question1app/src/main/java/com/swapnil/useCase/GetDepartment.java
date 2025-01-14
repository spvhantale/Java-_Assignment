package com.swapnil.useCase;

import java.util.Scanner;

import com.swapnil.dao.EmployeeDao;
import com.swapnil.dao.EmployeeDaoImpl;
import com.swapnil.exception.DepartmentException;
import com.swapnil.model.Department;

public class GetDepartment {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the employee id");
		int eid=sc.nextInt();
		
		EmployeeDao ed=new EmployeeDaoImpl();
		
		try {
			Department d=ed.getDepartmentDetailsByEmployeeId(eid);
		
			System.out.println("id "+d.getDeptId());
			System.out.println("dept name "+d.getDeptName());
			System.out.println("loca "+d.getLocation());
		} catch (DepartmentException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}
