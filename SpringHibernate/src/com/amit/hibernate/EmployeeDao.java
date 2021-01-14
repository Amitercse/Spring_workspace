package com.amit.hibernate;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao {

	public void saveEmployee(Employee employee);
}
