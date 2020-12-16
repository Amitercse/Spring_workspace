package com.amit.setterInjection;

import java.lang.reflect.Field;

import com.amit.serviceProvider.EmailServiceProvider;

public class EmailService {

	private EmailServiceProvider emailServiceProvider;
	private Field field;

	/*
	 * Client pass the instance of service provider instead of hard coding it in
	 * service class.
	 */
	public void setServiceProvider(EmailServiceProvider emailServiceProvider) {
		this.emailServiceProvider = emailServiceProvider;
	}

	public void sendMail(String receiver, String message) {
		/*
		 * Business logic before sending mail
		 */
		emailServiceProvider.sendMail(receiver, message);
	}
}
