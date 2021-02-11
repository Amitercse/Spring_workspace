package com.amit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.amit.model.Employee;
import com.amit.model.EmployeeRowMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> getEmployees() {
		String query = "select * from employee";
		return jdbcTemplate.query(query, new EmployeeRowMapper());
	}

}
