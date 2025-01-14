package com.swapnil.useCase;

import java.util.List;
import java.util.Scanner;

import com.swapnil.dao.EmployeeDao;
import com.swapnil.dao.EmployeeDaoImpl;
import com.swapnil.exception.EmployeeException;
import com.swapnil.model.Employee;

public class GetallEmployee {

	
	public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the department name");
	String did=sc.next();
	
	EmployeeDao ed=new EmployeeDaoImpl();
	try {
		List<Employee>list=ed.getAllEmployeeWithDeptName(did);
	
			list.forEach(s->{
				System.out.println("id "+s.getEmpId());
				System.out.println("name "+s.getEmpName());
				System.out.println("sal "+s.getSalary());
				System.out.println("city "+s.getAddress().getCity());
				System.out.println("state "+s.getAddress().getState());
				System.out.println("pincode "+s.getAddress().getPincode());
				System.out.println("depname "+s.getDept().getDeptName());
			System.out.println("==========================");
			
			});
			
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	
}
}
