package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void saveEmployeeData(Employee emp) {
		// Mock saving object data
		System.out.println("emp details: "+ emp);
	}

	@Override
	public List<String> getDepartmentList() {
		List<String> deptList= new ArrayList<String>();
		deptList.add("Developer");
		deptList.add("HR");
		deptList.add("Sales");
		return deptList;
	}

	@Override
	public List<Employee> getEmployeeList() {
		Employee emp1= new Employee("emp1", "Employee1", "emp1", "01/01/1993", "emp1@gmail.com", "HR");
		Employee emp2= new Employee("emp2", "Employee2", "emp2", "03/01/1994", "emp2@gmail.com", "Developer");
		Employee emp3= new Employee("emp3", "Employee3", "emp3", "03/03/1992", "emp3@gmail.com", "Sales");
		List<Employee> empList= new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		return empList;
	}

}