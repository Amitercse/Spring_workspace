package com.amit.constructorInjection;

import com.amit.serviceProvider.EmailServiceProvider;
import com.amit.serviceProvider.GmailServiceProvider;
import com.amit.serviceProvider.OutlookServiceProvider;

public class Client {

	public static void main(String[] args) {
		EmailServiceProvider serviceProvider= new OutlookServiceProvider();
		EmailService emailService= new EmailService(serviceProvider);
		emailService.sendMail("abc@gmail.com", "This is test message via constructor injection");
	}
}
