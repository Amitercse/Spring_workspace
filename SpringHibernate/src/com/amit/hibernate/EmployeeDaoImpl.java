package com.amit.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private HIbernateUtil hibernateUtil;
	
	@Override
	public void saveEmployee(Employee employee) {
		Session session= hibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
	}

}
