package com.amit.appContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigClient {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp= context.getBean(Employee.class);
		System.out.println(emp);
		Employee emp1= (Employee) context.getBean("employeeBean");
		System.out.println(emp1);
	}
}
