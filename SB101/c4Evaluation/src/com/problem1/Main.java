package com.problem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="jdbc:mysql://localhost:3306/c4evaluation";
		Scanner sc=new Scanner(System.in);
		System.out.println("choose the option "+"\n"+"1.insert Student"+"\n"+"2.insert Course"+"\n"+"3.insert Student_course"+"\n"+"4.print the all details of courses"+"\n"+"5.print the details on the basis of course enroll");
		int num=sc.nextInt();
		try (Connection conn=DriverManager.getConnection(url, "root", "4935")){
			if(num==1) {
				PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?,?)");
				System.out.println("Enter the roll number");
				int roll=sc.nextInt();
				System.out.println("Enter the name");
				String name=sc.next();
				System.out.println("Enter the address");
				String address=sc.next();
				System.out.println("Enter the mobile");
				String mobile=sc.next();
				ps.setInt(1, roll);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setString(4, mobile);
				
				int x=ps.executeUpdate();
				
				if(x>0) {
					System.out.println("Student details inserted "+x);
				}else {
					System.out.println("Student details not inserted ");
				}
			}
			else if(num==2) {
				PreparedStatement ps=conn.prepareStatement("insert into course values(?,?,?,?)");
				System.out.println("Enter the course number");
				int cid=sc.nextInt();
				System.out.println("Enter the Course name");
				String cname=sc.next();
				System.out.println("Enter the fee");
				int fee=sc.nextInt();
				System.out.println("Enter the duration");
				String duration=sc.next();
				ps.setInt(1, cid);
				ps.setString(2, cname);
				ps.setInt(3, fee);
				ps.setString(4, duration);
				
				int x=ps.executeUpdate();
				
				if(x>0) {
					System.out.println("Course details inserted "+x);
				}else {
					System.out.println("Course details not inserted ");
				}
			}else if(num==3) {
				System.out.println("Enter the student name");
				String sname=sc.next();
				PreparedStatement ps1=conn.prepareStatement("Select roll from student where name=?");
				ps1.setString(1, sname);
				ResultSet rs=ps1.executeQuery();
				
				System.out.println("Enter the course name");
				String cname=sc.next();
				PreparedStatement ps2=conn.prepareStatement("Select cid from course where cname=?");
				ps2.setString(1, cname);
				PreparedStatement ps=conn.prepareStatement("insert into student_course values(?,?)");
				if(rs.next()) {
					int r=rs.getInt("roll");
					ps.setInt(1, r);
				}else {
					System.out.println("not found student");
				}
				
				ResultSet rs1=ps2.executeQuery();
				if(rs1.next()) {
					int r1=rs1.getInt("cid");
					ps.setInt(2, r1);
				}else {
					System.out.println("not found course");
				}
				int x=ps.executeUpdate();
				
				if(x>0) {
					System.out.println("Student_Course details inserted "+x);
				}else {
					System.out.println("Student_Course details not inserted ");
				}
			}else if(num==4) {
				System.out.println("Enter the student roll");
				int roll=sc.nextInt();
				PreparedStatement ps=conn.prepareStatement("select s.name,s.address,s.mobile,c.cname,c.fee,c.duration from student s inner join course c inner join student_course sc ON s.roll=sc.roll AND c.cid=sc.cid AND s.roll=?");
				ps.setInt(1, roll);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {	
					String sname=rs.getString("name");
					String saddress=rs.getString("address");
					String smobile=rs.getString("mobile");
					String cname=rs.getString("cname");
					String cduration=rs.getString("duration");
					int cfee=rs.getInt("fee");
					System.out.println("Student name : "+sname);
					System.out.println("Student address : "+saddress);
					System.out.println("Student mobile : "+smobile);
					System.out.println("Student course name : "+cname);
					System.out.println("Student  course fee : "+cfee);
					System.out.println("Student course duration : "+cduration);
					System.out.println("===================================================");
				}
				
			}else if(num==5) {
				System.out.println("Enter the course name");
				String cname1=sc.next();
				PreparedStatement ps=conn.prepareStatement("select s.name,s.address,s.mobile,c.cname,c.fee,c.duration from student s inner join course c inner join student_course sc ON s.roll=sc.roll AND c.cid=sc.cid AND c.cname=?");
				ps.setString(1, cname1);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					
					String sname=rs.getString("name");
					String saddress=rs.getString("address");
					String smobile=rs.getString("mobile");
					String cname=rs.getString("cname");
					String cduration=rs.getString("duration");
					int cfee=rs.getInt("fee");
					System.out.println("Student name : "+sname);
					System.out.println("Student address : "+saddress);
					System.out.println("Student mobile : "+smobile);
					System.out.println("Student course name : "+cname);
					System.out.println("Student  course fee : "+cfee);
					System.out.println("Student course duration : "+cduration);
					System.out.println("===================================================");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
