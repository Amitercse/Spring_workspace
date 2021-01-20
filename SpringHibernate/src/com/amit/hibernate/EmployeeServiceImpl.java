package com.amit.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@Override
	public List<Employee> getEmployeeList() {
		return employeeDao.getEmployeeList();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@Override
	public Employee getEmployeeById(int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	@Override
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@Override
	public void firstLevelCache(int employeeId) {
		employeeDao.firstLevelCache(employeeId);
	}

}
