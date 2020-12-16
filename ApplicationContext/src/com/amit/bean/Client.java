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
		Employee employee= context.getBean(Employee.class);
		System.out.println(employee);
		// Get employee bean using bean name
		Employee employee1= (Employee) context.getBean(employee.getBeanName());
		System.out.println(employee1);
	}
}