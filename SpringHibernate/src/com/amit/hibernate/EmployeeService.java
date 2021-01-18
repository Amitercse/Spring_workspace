package com.amit.hibernate;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

	public void saveEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public List<Employee> getEmployeeList();
	
	public Employee getEmployeeById(int employeeId);
	
	public void deleteEmployee(int employeeId);
}
