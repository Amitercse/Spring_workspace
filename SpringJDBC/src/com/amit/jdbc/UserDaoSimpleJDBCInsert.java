package com.amit.jdbc;

import org.springframework.stereotype.Component;

@Component
public interface UserDaoSimpleJDBCInsert {

	public void  saveUserData(User user);
}
