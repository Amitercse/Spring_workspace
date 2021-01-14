package com.amit.hibernate;

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
}
