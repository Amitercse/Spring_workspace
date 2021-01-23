package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("messages")
@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;

//	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	@GetMapping
	public List<MessageResource> getMessages()
	{
		return messageService.getMessages();
	}
	
	@GetMapping("/{id}")
	public MessageResource getMessageById(@PathVariable("id") int messageId)
	{
		return messageService.getMessagesById(messageId);
	}
	
	@PostMapping(produces = "text/html")
	public String postMessage(@RequestBody MessageResource messageResource)
	{
		messageService.saveMessage(messageResource);
		return "Message Saved Successfully";
	}
	
	@PutMapping("/{id}")
	public String updateMessage(@RequestBody MessageResource messageResource, @PathVariable("id") int messageId)
	{
		messageService.updateMessage(messageId, messageResource);
		return "Message updated successfully";
	}
	
	@DeleteMapping("/{id}")
	public String deleteMessage(@PathVariable("id") int messageId)
	{
		messageService.deleteMessage(messageId);
		return "Message deleted successfully";
	}
}
