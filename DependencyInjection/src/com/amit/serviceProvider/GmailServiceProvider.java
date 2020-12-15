package com.amit.serviceProvider;

public class GmailServiceProvider implements EmailServiceProvider{

	@Override
	public void sendMail(String receiver, String message) {
		System.out.println("Sending mail using gmail");
		// code to send mail
		System.out.println("receiver: " + receiver + ", message: " + message);
	}
}
