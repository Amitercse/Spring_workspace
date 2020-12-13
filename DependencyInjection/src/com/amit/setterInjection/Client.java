package com.amit.setterInjection;

import com.amit.serviceProvider.EmailServiceProvider;

public class Client {

	public static void main(String[] args) {
		EmailServiceProvider emailServiceProvider = new EmailServiceProvider();
		EmailService emailService = new EmailService();
		emailService.setServiceProvider(emailServiceProvider);
		emailService.sendMail("abc@gmail.com", "This is test message via setter injection");
	}
}
