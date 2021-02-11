package com.amit.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amit.model.Employee;

@Component
public interface EmployeeDAO {

	public List<Employee> getEmployees();
}
