package com.amit.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired
	private UserDao dao;
	@Autowired
	private User user;
	@Autowired
	private UserDaoNamedJDBC userDaoNamedJDBC;
	@Autowired
	private UserDaoSimpleJDBCInsert simpleJDBInsert;
	
	public void saveUserData(int id, String name, String dateOfBirth, String location)
	{
		user.setId(id);
		user.setName(name);
		user.setDateOfBirth(dateOfBirth);
		user.setLocation(location);
		dao.saveUser(user);
	}
	
	public void updateUserData(int id, String name, String dateOfBirth, String location)
	{
		user.setId(id);
		user.setName(name);
		user.setDateOfBirth(dateOfBirth);
		user.setLocation(location);
		dao.updateUser(user);
	}
	
	public User getUserById(int id)
	{
		return dao.getUserById(id);
	}
	
	public List<User> getUsersList()
	{
		return dao.getAllUsers();
	}
	
	public List<String> getUsersNames()
	{
		return dao.getAllUserNames();
	}
	
	public void deleteUserById(int id)
	{
		dao.deleteUser(id);
	}
	
	public Map<String, List<User>> userListGroupedByLoc()
	{
		return dao.userListGroupedByLoc();
	}
	
	public void saveUserWithNamedJDBCParams(int id, String name, String dateOfBirth, String location)
	{
		user.setId(id);
		user.setName(name);
		user.setDateOfBirth(dateOfBirth);
		user.setLocation(location);
		userDaoNamedJDBC.saveUser(user);
	}
	
	public void saveUserWithNamedJDBCBeanParams(int id, String name, String dateOfBirth, String location)
	{
		user.setId(id);
		user.setName(name);
		user.setDateOfBirth(dateOfBirth);
		user.setLocation(location);
		userDaoNamedJDBC.saveUserWithBeanParam(user);
	}
	
	public void saveUserWithSimpleJDBCInsert(int id, String name, String dateOfBirth, String location)
	{
		user.setId(id);
		user.setName(name);
		user.setDateOfBirth(dateOfBirth);
		user.setLocation(location);
		simpleJDBInsert.saveUserData(user);
	}
}
