package com.amit.setterInjection;

import com.amit.serviceProvider.EmailServiceProvider;
import com.amit.serviceProvider.GmailServiceProvider;
import com.amit.serviceProvider.OutlookServiceProvider;

public class Client {

	public static void main(String[] args) {
		EmailServiceProvider emailServiceProvider = new OutlookServiceProvider();
		EmailService emailService = new EmailService();
		emailService.setServiceProvider(emailServiceProvider);
		emailService.sendMail("abc@gmail.com", "This is test message via setter injection");
	}
}
