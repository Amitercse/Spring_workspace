package com.amit.jdbc;

import org.springframework.stereotype.Component;

@Component
public interface UserDaoNamedJDBC {

	public void saveUser(User user);
	
	public void saveUserWithBeanParam(User user);
}
