package com.amit.constructorInjection;

import com.amit.serviceProvider.EmailServiceProvider;

public class EmailService {

	private EmailServiceProvider serviceProvider;

	public EmailService(EmailServiceProvider serviceProvider) {
		/*
		 * Instead of hard coding creation of service provider, passing object as
		 * constructor parameter.
		 */
		this.serviceProvider = serviceProvider;
	}

	public void sendMail(String receiver, String message) {
		/*
		 * Before sending mail we can perform business operation here.
		 */
		serviceProvider.sendMail(receiver, message);
	}
}
