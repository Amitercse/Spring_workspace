package com.amit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amit.dao.EmployeeDAO;
import com.amit.model.Employee;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;
	
	public void getData()
	{
		System.out.println("Hello world");
	}
	
	public List<Employee> getEmployees()
	{
		return employeeDao.getEmployees();
	}
}
