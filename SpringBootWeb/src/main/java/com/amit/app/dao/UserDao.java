package com.amit.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.app.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

}
