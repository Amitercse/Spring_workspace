package com.amit.dao;

import org.springframework.stereotype.Repository;

import com.amit.model.User;

@Repository
public interface UserDao {

	public User getUserByUserName(String userName);
}
