package com.amit.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

/**
 * @author Amit sharma
 * Class demonstrate DB operations using NamedParameterJdbcTemplate
 */
@Component
public class UserDaoNamedJDBCImpl implements UserDaoNamedJDBC {

	@Autowired
	NamedParameterJdbcTemplate namedJDBCTemplate;
	
	@Override
	public void saveUser(User user) {
		String query= "insert into user values(:id, :name, :dateOfBirth, :location)";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", user.getId()).addValue("name", user.getName()).addValue("dateOfBirth", user.getDateOfBirth()).addValue("location", user.getLocation());
		int out= namedJDBCTemplate.update(query, namedParameters);
		if(out!=0)
		{
			System.out.println("Data stored successfully using named param");
		}
		else
		{
			System.out.println("Some error occurred");
		}
	}

	@Override
	public void saveUserWithBeanParam(User user) {
		String query= "insert into user values(:id, :name, :dateOfBirth, :location)";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
		int out= namedJDBCTemplate.update(query, namedParameters);
		if(out!=0)
		{
			System.out.println("Data stored successfully using bean param");
		}
		else
		{
			System.out.println("Some error occurred");
		}
	}
	
	@Override
	public void saveUserInBatch(List<User> userList) {
		String query= "insert into user values(:id, :name, :dateOfBirth, :location)";
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(userList.toArray());
		namedJDBCTemplate.batchUpdate(query,batch);
		System.out.println("Records inserted successfully");
	}

}
