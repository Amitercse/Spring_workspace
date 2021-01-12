package com.amit.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Amit sharma
 * Class to perform DB operations using JDBC template
 */
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveUser(User user) {
		String query= "insert into user values(?,?,?,?)";
		Object[] args = new Object[] {user.getId(), user.getName(), user.getDateOfBirth(), user.getLocation()};
		int out= jdbcTemplate.update(query, args);
		if(out!=0)
		{
			System.out.println("Data stored successfully");
		}
		else
		{
			System.out.println("Some error occurred");
		}
	}

	@Override
	public void updateUser(User user) {
		String query= "update user set name=?, date_of_birth=?, location=? where user_id=?";
		Object[] args = new Object[] {user.getName(), user.getDateOfBirth(), user.getLocation(), user.getId()};
		int out= jdbcTemplate.update(query, args);
		if(out!=0)
		{
			System.out.println("Data updated successfully");
		}
		else
		{
			System.out.println("Some error occurred");
		}
	}

	@Override
	public User getUserById(int id) {
		String query= "select * from user where user_id=?";
		Object[] args = new Object[] {id};
		User user= jdbcTemplate.queryForObject(query, args, new UserRowMapper());
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		String query= "select * from user";
		List<User> userList= jdbcTemplate.query(query, new UserRowMapper());
		return userList;
	}
	
	@Override
	public List<String> getAllUserNames() {
		String query= "select name from user";
		List<String> userNames= jdbcTemplate.queryForList(query, String.class);
		return userNames;
	}

	@Override
	public void deleteUser(int id) {
		String query= "delete from user where user_id=?";
		Object[] args= new Object[] {id};
		int count= jdbcTemplate.update(query, args);
		if(count==1)
		{
			System.out.println("user deleted successfully");
		}
		else
		{
			System.out.println("Some error occurred");
		}
	}

	@Override
	public Map<String, List<User>> userListGroupedByLoc() {
		String query= "select * from user";
		Map<String, List<User>> userLocationMap= jdbcTemplate.query(query, new UserResultSetExtractor());
		return userLocationMap;
	}

	public void batchInsert(List<User> listUsers) {
		String sql = "insert into user values(?,?,?,?)";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				User user = listUsers.get(i);
				ps.setInt(1, user.getId());
				ps.setString(2, user.getName());
				ps.setString(3, user.getDateOfBirth());
				ps.setString(4, user.getLocation());
			}

			@Override
			public int getBatchSize() {
				return listUsers.size();
			}
		});
	}
}
