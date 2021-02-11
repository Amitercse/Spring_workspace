package com.amit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee= new Employee();
		employee.setEmpId(rs.getString("emp_id"));
		employee.setName(rs.getString("name"));
		employee.setDepartment(rs.getString("department"));
		employee.setLocation(rs.getString("location"));
		return employee;
	}

	
}
