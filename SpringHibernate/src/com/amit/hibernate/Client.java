package com.amit.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	static Controller controller;
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		controller= context.getBean(Controller.class);
	//	saveEmployee();
		updateEmployee();
		getEmployeeList();
		getEmployeeById();
	}
	
	private static void saveEmployee() {
		controller.saveEmployee("Employee 2", "development", "Bangalore");
	}
	
	private static void updateEmployee() {
		controller.updateEmployee(2, "Employee 2", "development", "Hyderabad");
	}
	
	private static void getEmployeeList()
	{
		List<Employee> employeeList= controller.getEmployeeList();
		System.out.println(employeeList);
	}
	
	private static void getEmployeeById()
	{
		Employee employee= controller.getEmployeeById(1);
		System.out.println(employee);
	}
}
