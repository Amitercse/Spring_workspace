package com.amit.hibernate;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class HIbernateUtil {

	@Autowired
	private LocalSessionFactoryBean sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getObject().getCurrentSession();
	}
}
