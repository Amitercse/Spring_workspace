package com.amit.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao {

	public void saveEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public Employee getEmployeeById(int employeeId);
	
	public List<Employee> getEmployeeList();
}
