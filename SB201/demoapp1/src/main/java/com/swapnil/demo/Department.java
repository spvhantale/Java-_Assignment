package com.swapnil.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int deptId;
	private String dname;
	private String location;
	
	@OneToMany(mappedBy="dept" ,cascade=CascadeType.ALL)
	private List<Employee> emps=new ArrayList<Employee>();

	public Department(int deptId, String dname, String location, List<Employee> emps) {
		super();
		this.deptId = deptId;
		this.dname = dname;
		this.location = location;
		this.emps = emps;
	}

	public Department() {
		super();
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", dname=" + dname + ", location=" + location + ", emps=" + emps + "]";
	}
	
	
	
	
}
