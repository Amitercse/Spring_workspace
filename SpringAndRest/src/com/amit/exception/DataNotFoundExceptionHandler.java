package com.amit.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.amit.util.ResponseMessage;

@ControllerAdvice
public class DataNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ResponseMessage responseMessage;
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ResponseMessage> handleDataNotFoundException(DataNotFoundException ex)
	{
		responseMessage.setMessageCode(804);
		responseMessage.setMessage(ex.getMessage());
		return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
	}
}
