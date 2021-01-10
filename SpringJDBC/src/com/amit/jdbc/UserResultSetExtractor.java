package com.amit.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/*
 * Extractor to group users based on location.
 */
public class UserResultSetExtractor implements ResultSetExtractor<Map<String, List<User>>> {

	@Override
	public Map<String, List<User>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, List<User>> userLocationMap= new HashMap<String, List<User>>();
		while(rs.next())
		{
			int id= Integer.parseInt(rs.getString("user_id"));
			String name= rs.getString("name");
			String dateOfBirth= rs.getString("date_of_birth");
			String location= rs.getString("location");
			User user= new User(id, name, dateOfBirth, location);
			if(userLocationMap.containsKey(location))
			{
				userLocationMap.get(location).add(user);
			}
			else
			{
				List<User> userList= new ArrayList<User>();
				userList.add(user);
				userLocationMap.put(location, userList);
			}
		}
		return userLocationMap;
	}

}
