package com.amit.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private HIbernateUtil hibernateUtil;
	
	@Override
	public void saveEmployee(Employee employee) {
		Session session = hibernateUtil.getSession();
		session.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = hibernateUtil.getSession();
		session.update(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Session session = hibernateUtil.getSession();
		Employee employee = session.get(Employee.class, employeeId);
		return employee;
	}

	@Override
	public List<Employee> getEmployeeList() {
		Session session = hibernateUtil.getSession();
		CriteriaQuery<Employee> criteriaQuery = session.getCriteriaBuilder().createQuery(Employee.class);
		criteriaQuery.from(Employee.class);
		List<Employee> employeeList = session.createQuery(criteriaQuery).getResultList();
		return employeeList;
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Session session = hibernateUtil.getSession();
		Employee employee = new Employee();
		employee.setId(employeeId);
		session.delete(employee);
		System.out.println("deleted employee with id: " + employeeId);
	}

	@Override
	public void firstLevelCache(int employeeId) {
		Session session = hibernateUtil.getSession();
		Employee employee = session.get(Employee.class, employeeId);
		System.out.println("employee details using first session: "+employee);
		Session tempSession = hibernateUtil.openSession();
		System.out.println("is same session: "+ (session==tempSession));
		employee= tempSession.get(Employee.class, employeeId);
		System.out.println("employee details using second session: "+employee);
	}

	@Override
	public void secondLevelCache(int employeeId) {
		Session session = hibernateUtil.getSession();
		Employee employee = session.get(Employee.class, employeeId);
		System.out.println("employee details using first session: "+employee);
		Session tempSession = hibernateUtil.openSession();
		System.out.println("is same session: "+ (session==tempSession));
		employee= tempSession.get(Employee.class, employeeId);
		System.out.println("employee details using second session: "+employee);
	}

}
