package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void saveEmployeeData(Employee emp) {
		// Mock saving object data
		System.out.println("emp details: "+ emp);
	}

	@Override
	public List<String> getDepartmentList() {
		List<String> deptList= new ArrayList<String>();
		deptList.add("Developer");
		deptList.add("HR");
		deptList.add("Sales");
		return deptList;
	}

}