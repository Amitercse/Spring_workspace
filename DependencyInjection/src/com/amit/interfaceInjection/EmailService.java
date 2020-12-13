package com.amit.interfaceInjection;

import com.amit.serviceProvider.EmailServiceProvider;

public class EmailService implements DependencyProvider{
	
	private EmailServiceProvider emailServiceProvider;

	@Override
	public void injectEmailServiceProvider(EmailServiceProvider serviceProvider) {
		this.emailServiceProvider= serviceProvider;
	}
	
	public void sendMail(String receiver, String message) {
		emailServiceProvider.sendMail(receiver, message);
	}
}
