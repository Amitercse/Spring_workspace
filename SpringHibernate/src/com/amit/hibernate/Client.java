package com.amit.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	static Controller controller;
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		controller= context.getBean(Controller.class);
		saveEmployee();
	}
	
	private static void saveEmployee() {
		controller.saveEmployee("Employee 1", "development", "Bangalore");
	}
}
