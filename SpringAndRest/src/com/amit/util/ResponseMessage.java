package com.amit.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseMessage {

	private int messageCode;
	private String message;
	/**
	 * @return the messageCode
	 */
	public int getMessageCode() {
		return messageCode;
	}
	/**
	 * @param messageCode the messageCode to set
	 */
	public void setMessageCode(int messageCode) {
		this.messageCode = messageCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
