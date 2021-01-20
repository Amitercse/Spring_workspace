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
	//	updateEmployee();
	//	getEmployeeList();
	//	getEmployeeById();
	//	deleteEmployee();
	//	firstLevelCacheExample();
		secondLevelCacheExample();
	}

	private static void saveEmployee() {
		controller.saveEmployee("Employee 2", "Development", "Bangalore");
	}
	
	private static void updateEmployee() {
		controller.updateEmployee(6, "Employee 2", "HR", "Chennai");
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
	
	private static void deleteEmployee()
	{
		controller.deleteEmployee(6);
	}
	
	private static void firstLevelCacheExample() {
		controller.firstLevelCache(1);
	}
	
	private static void secondLevelCacheExample() {
		controller.secondLevelCache(1);
	}
}
