package com.amit.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		// Reading custom init and destroy using xml
		ApplicationContext xmlContext= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserXmlBean xmlBean= (UserXmlBean) xmlContext.getBean("xmlUser");
		System.out.println(xmlBean);
	}
}
