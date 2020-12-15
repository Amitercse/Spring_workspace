package com.amit.appContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int employeeId;
	private String employeeName;
	private String department;
	private Address address;
	
	public Employee() {
		this.employeeId=1;
		this.employeeName= "employee 1";
		this.department="department";
	}
	
	@Autowired
	public Employee(@Value("2") int id, @Value("emp 2") String name, @Value("HR") String dept, Address address) {
		System.out.println("constructor call");
		this.employeeId=id;
		this.employeeName= name;
		this.department= dept;
		this.address= address;
	}
	
	@Autowired
	public void setAddress(Address address)
	{
		System.out.println("setter call");
		this.address= address;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", department=" + department
				+ ", address=" + address.toString() + "]";
	}
	
}
