package com.amit.setterInjection;

import com.amit.constructorInjection.EmailServiceProvider;

public class EmailService {

	private EmailServiceProvider emailServiceProvider;

	/*
	 * Client pass the instance of service provider instead of hard coding it in
	 * service class.
	 */
	public void setServiceProvider(EmailServiceProvider emailServiceProvider) {
		this.emailServiceProvider = emailServiceProvider;
	}

	public void sendMail(String receiver, String message) {
		emailServiceProvider.sendMail(receiver, message);
	}
}
