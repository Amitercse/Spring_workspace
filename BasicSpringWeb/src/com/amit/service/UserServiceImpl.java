package com.amit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.amit.dao.UserDao;
import com.amit.model.User;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String userName) {
		User user= userDao.getUserByUserName(userName);
		UserBuilder builder= null;
		if(user!= null)
		{
			builder= org.springframework.security.core.userdetails.User.withUsername(userName);
			builder.disabled(!user.isEnabled());
			builder.password(user.getPassword());
			String[] authorities= {user.getRole()};
			builder.authorities(authorities);
		}
		else
		{
			throw new UsernameNotFoundException("User not found");
		}
		return builder.build();
	}

}
