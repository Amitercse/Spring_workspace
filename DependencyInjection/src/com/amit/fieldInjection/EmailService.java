package com.amit.fieldInjection;

import com.amit.serviceProvider.EmailServiceProvider;

public class EmailService {
	
	@Dependency
	private EmailServiceProvider serviceProvider;

	public void sendMail(String receiver, String message) {
		serviceProvider.sendMail(receiver, message);
	}
}
