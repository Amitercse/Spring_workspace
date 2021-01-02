package com.amit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.model.Employee;

@Service
public interface EmployeeService {

	public void saveEmployeeData(Employee emp);
	
	public List<String> getDepartmentList();
}
