package com.amit.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		PaymentController controller= context.getBean(PaymentController.class);
		controller.makePayment();
		// Get dummy controller and service for JSR annotations demonstration
		DummyController dummyController= context.getBean(DummyController.class);
		dummyController.performOperation();
	}
}
