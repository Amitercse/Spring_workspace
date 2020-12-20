package com.amit.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(BeanConfig.class);
		Person person= context.getBean(Person.class);
		System.out.println(person);
		Person person1= context.getBean(Person.class);
		System.out.println(person1);
		User user= (User) context.getBean("user");
		System.out.println(user);
		System.out.println(user.getContactDetails());
		// Get employee bean using bean name
		User user1= (User) context.getBean(user.getBeanName());
		System.out.println(user1); 
	}
}
