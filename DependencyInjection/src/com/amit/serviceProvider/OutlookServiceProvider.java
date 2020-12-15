package com.amit.serviceProvider;

public class OutlookServiceProvider implements EmailServiceProvider {

	@Override
	public void sendMail(String receiver, String message) {
		System.out.println("Sending mail using outlook");
		// code to send mail
		System.out.println("receiver: " + receiver + ", message: " + message);
	}

}
