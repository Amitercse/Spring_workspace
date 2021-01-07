package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.amit.model.Employee;

@Service
@Profile("test")
public class EmployeeServiceMockImpl implements EmployeeService {

	@Override
	public void saveEmployeeData(Employee emp) {
		System.out.println("Saving employee details using test profile service");
		// Mock DB calls and save data
		System.out.println("emp details: "+ emp);
	}

	@Override
	public List<String> getDepartmentList() {
		System.out.println("Getting dept list from test profile service");
		List<String> deptList= new ArrayList<String>();
		deptList.add("Developer");
		deptList.add("HR");
		return deptList;
	}

	@Override
	public List<Employee> getEmployeeList() {
		System.out.println("Get employee list from test profile service");
		Employee emp1= new Employee("emp1", "Mock Employee1", "emp1", "01/01/1993", "emp1@gmail.com", "HR");
		Employee emp2= new Employee("emp2", "Mock Employee2", "emp2", "03/01/1994", "emp2@gmail.com", "Developer");
		List<Employee> empList= new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		return empList;
	}

}
