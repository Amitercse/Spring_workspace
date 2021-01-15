package com.amit.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

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

	@Override
	public void updateEmployee(Employee employee) {
		Session session= hibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		session.update(employee);
		tx.commit();
		session.close();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Session session= hibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		Employee employee= session.get(Employee.class, employeeId);
		tx.commit();
		session.close();
		return employee;
	}

	@Override
	public List<Employee> getEmployeeList() {
		Session session= hibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		CriteriaQuery<Employee> criteriaQuery = session.getCriteriaBuilder().createQuery(Employee.class);
		criteriaQuery.from(Employee.class);
		List<Employee> employeeList= session.createQuery(criteriaQuery).getResultList();
		tx.commit();
		session.close();
		return employeeList;
	}

}
