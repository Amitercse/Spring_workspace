package com.amit.appContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
	//	ApplicationContext context1= new ClassPathXmlApplicationContext(new String[] {"file1.xml", "file2.xml"});
		Employee emp= context.getBean(Employee.class);
		System.out.println(emp);
	}
}
