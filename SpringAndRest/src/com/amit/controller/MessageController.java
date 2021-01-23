package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.model.MessageResource;
import com.amit.service.MessageService;
import com.amit.util.ResponseMessage;

@RequestMapping("messages")
@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private ResponseMessage responseMessage;

//	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	@GetMapping
	public List<MessageResource> getMessages() {
		return messageService.getMessages();
	}

	@GetMapping("/{id}")
	public ResponseEntity<MessageResource> getMessageById(@PathVariable("id") int messageId) {
		MessageResource message= messageService.getMessagesById(messageId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ResponseMessage> postMessage(@RequestBody MessageResource messageResource) {
		messageService.saveMessage(messageResource);
		responseMessage.setMessageCode(800);
		responseMessage.setMessage("Message saved successfully");
		return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseMessage> updateMessage(@RequestBody MessageResource messageResource,
			@PathVariable("id") int messageId) {
		messageService.updateMessage(messageId, messageResource);
		responseMessage.setMessageCode(800);
		responseMessage.setMessage("Message updated successfully");
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseMessage> deleteMessage(@PathVariable("id") int messageId) {
		messageService.deleteMessage(messageId);
		responseMessage.setMessageCode(800);
		responseMessage.setMessage("Message deleted successfully");
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}
}
