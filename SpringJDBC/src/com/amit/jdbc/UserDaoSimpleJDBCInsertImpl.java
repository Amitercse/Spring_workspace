package com.amit.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

/**
 * @author Amit sharma
 * Class to insert data in table using SimpleJDBCInsert
 */
@Component
public class UserDaoSimpleJDBCInsertImpl implements UserDaoSimpleJDBCInsert{

	@Autowired
	SimpleJdbcInsert simpleJDBCInsert;
	
	@Override
	public void saveUserData(User user) {
		simpleJDBCInsert.withTableName("user");
		Map<String, Object> params = new HashMap<>();
		params.put("user_id", user.getId());
		params.put("name", user.getName());
		params.put("date_of_birth", user.getDateOfBirth());
		params.put("location", user.getLocation());
		int out= simpleJDBCInsert.execute(params);
		if(out!=0)
		{
			System.out.println("Data stored successfully using JDBCSimpleInsert");
		}
		else
		{
			System.out.println("Some error occurred");
		}
	}

}
