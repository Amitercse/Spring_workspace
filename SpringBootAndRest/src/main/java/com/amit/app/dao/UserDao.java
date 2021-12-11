package com.amit.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

	public User findByNameAndEmail(String name, String email);
	
	public List<User> findByDateOfBirthGreaterThan(Date dateOfBirth);
}
