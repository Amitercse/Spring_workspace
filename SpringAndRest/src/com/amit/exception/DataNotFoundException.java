package com.amit.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * Default serial version id
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException()
	{
		
	}

	public DataNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
