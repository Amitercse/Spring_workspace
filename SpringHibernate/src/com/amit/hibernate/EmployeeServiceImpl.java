package com.amit.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public void saveEmployee(Employee emp) {
		employeeDao.saveEmployee(emp);
	}

}
