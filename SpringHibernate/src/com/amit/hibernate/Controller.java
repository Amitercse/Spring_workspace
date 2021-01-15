package com.amit.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired
	private Employee emp;
	
	@Autowired
	private EmployeeService empService;

	public void saveEmployee(String name, String department, String location)
	{
		emp.setName(name);
		emp.setDepartment(department);
		emp.setLocation(location);
		empService.saveEmployee(emp);
	}
	
	public void updateEmployee(int id, String name, String department, String location)
	{
		emp.setId(id);
		emp.setName(name);
		emp.setDepartment(department);
		emp.setLocation(location);
		empService.updateEmployee(emp);
	}
	
	public List<Employee> getEmployeeList()
	{
		return empService.getEmployeeList();
	}
	
	public Employee getEmployeeById(int employeeId)
	{
		return empService.getEmployeeById(employeeId);
	}
}
