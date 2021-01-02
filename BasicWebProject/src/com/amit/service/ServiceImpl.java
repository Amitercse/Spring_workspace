package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import com.amit.model.Employee;

public class ServiceImpl implements Service {

	@Override
	public List<Employee> getEmployeeList() {
		// Mock the employee list
		Employee emp1= new Employee(1, "emp1");
		Employee emp2= new Employee(2, "emp2");
		Employee emp3= new Employee(3, "emp3");
		List<Employee> empList= new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		System.out.println(empList);
		return empList;
	}

}
