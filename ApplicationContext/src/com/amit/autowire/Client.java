package com.amit.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		Controller controller= (Controller) context.getBean("controller");
		controller.invokeService();
		Controller1 controller1= (Controller1) context.getBean("controller1");
		controller1.invokeService();
	}
}
