package com.amit.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user= new User();
		int id= Integer.parseInt(rs.getString("user_id"));
		user.setId(id);
		user.setName(rs.getString("name"));
		user.setDateOfBirth(rs.getString("date_of_birth"));
		user.setLocation(rs.getString("location"));
		return user;
	}

}
