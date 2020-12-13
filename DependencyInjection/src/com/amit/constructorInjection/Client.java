package com.amit.constructorInjection;

import com.amit.serviceProvider.EmailServiceProvider;

public class Client {

	public static void main(String[] args) {
		EmailServiceProvider serviceProvider= new EmailServiceProvider();
		EmailService emailService= new EmailService(serviceProvider);
		emailService.sendMail("abc@gmail.com", "This is test message via constructor injection");
	}
}
