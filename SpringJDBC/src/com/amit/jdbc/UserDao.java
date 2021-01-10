package com.amit.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface UserDao {

	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public User getUserById(int id);
	
	public List<User> getAllUsers();
	
	public List<String> getAllUserNames();
	
	public void deleteUser(int id);
	
	public Map<String, List<User>> userListGroupedByLoc();
}
