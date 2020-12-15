package com.amit.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Person person= context.getBean(Person.class);
		System.out.println(person);
		Person person1= context.getBean(Person.class);
		System.out.println(person1);
	}
}
