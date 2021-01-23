package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.amit.controller.MessageController;
import com.amit.exception.DataNotFoundException;
import com.amit.model.MessageResource;
import com.amit.util.LinkBuilder;
import com.amit.util.Util;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private LinkBuilder linkBuilder;
	
	@Override
	public List<MessageResource> getMessages() {
		List<MessageResource> messageList= Util.getMessagesList();
		if(messageList== null)
		{
			throw new DataNotFoundException("No message found");
		}
		// Add URI link to resources
		linkBuilder.addLinksToMessages(messageList);
		return messageList;
	}
	
	@Override
	public MessageResource getMessagesById(int messageId) {
		List<MessageResource> messageList= Util.getMessagesList();
		MessageResource newMessage= null;
		for(MessageResource message: messageList)
		{
			if(message.getId()==messageId)
			{
				newMessage= message;
			}
		}
		if(newMessage== null)
		{
			throw new DataNotFoundException("Not able to find message with id: "+ messageId);
		}
		// Remove if any link is already existed and add new URI link to resource
		newMessage.removeLinks();
		Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MessageController.class).getMessageById(messageId)).withSelfRel();
		newMessage.add(selfLink);
		return newMessage;
	}

	@Override
	public void saveMessage(MessageResource messageResource) {
		if (messageResource.getCommentsList() == null) {
			messageResource.setCommentsList(new ArrayList<>());
		}
		Util.addMessage(messageResource);
	}

	@Override
	public void updateMessage(int messageId, MessageResource messageResource) {
		List<MessageResource> messageList= Util.getMessagesList();
		for(MessageResource message: messageList)
		{
			if(message.getId()==messageId)
			{
				message.setAuthor(messageResource.getAuthor());
				message.setMessage(messageResource.getMessage());
				message.setPostedDate(messageResource.getPostedDate());
				break;
			}
		}
	}

	@Override
	public void deleteMessage(int messageId) {
		List<MessageResource> messageList= Util.getMessagesList();
		for(MessageResource message: messageList)
		{
			if(message.getId()==messageId)
			{
				messageList.remove(message);
				break;
			}
		}
	}

}