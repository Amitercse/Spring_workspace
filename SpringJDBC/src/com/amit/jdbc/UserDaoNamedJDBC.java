package com.amit.jdbc;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface UserDaoNamedJDBC {

	public void saveUser(User user);
	
	public void saveUserWithBeanParam(User user);
	
	public void saveUserInBatch(List<User> userList);
}
