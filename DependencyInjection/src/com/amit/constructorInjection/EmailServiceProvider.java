package com.amit.constructorInjection;

public class EmailServiceProvider {

	public void sendMail(String receiver, String message) {
		// code to send mail
		System.out.println("receiver: " + receiver + ", message: " + message);
	}
}
