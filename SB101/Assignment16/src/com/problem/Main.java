package com.problem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
System.out.println("Enter the option"+"1.Insert 2.Update 3.Print");
int num=sc.nextInt();
		String url="jdbc:mysql://localhost:3306/sb101day5";
		try {
			Connection conn=DriverManager.getConnection(url, "root", "4935");
			if(num==1) {
				System.out.println("Enter the department id");
				int depid=sc.nextInt();
				System.out.println("Enter the Department name");
				String dname=sc.next();
				System.out.println("Enter the location");
				String dloc=sc.next();
				PreparedStatement statement=conn.prepareStatement("insert into department values(?,?,?)");
				statement.setInt(1, depid);
				statement.setString(2, dname);
				statement.setString(3, dloc);
				
				int x=statement.executeUpdate();
				if(x>0) {
					System.out.println("Inserted "+x);
				}else {
					System.out.println("Not inserted");
				}
			}else if(num==2) {
				System.out.println("Enter the department id");
				int depid=sc.nextInt();
				System.out.println("Enter the Department name");
				String dname=sc.next();
				PreparedStatement statement=conn.prepareStatement("update department set dname=? where depid=?");
				statement.setInt(2, depid);
				statement.setString(1, dname);
				
				int x=statement.executeUpdate();
				if(x>0) {
					System.out.println("update "+x);
				}else {
					System.out.println("Not update");
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
