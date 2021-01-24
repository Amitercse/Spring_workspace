package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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
	
	private static final Logger logger = Logger.getLogger(MessageServiceImpl.class.getName());
	
	@Override
	public List<MessageResource> getMessages() {
		List<MessageResource> messageList = Util.getMessagesList();
		if (messageList == null) {
			logger.error("No available message found");
			throw new DataNotFoundException("No message found");
		}
		// Add URI link to resources
		linkBuilder.addLinksToMessages(messageList);
		logger.info("Returning message list with size: " + messageList.size());
		return messageList;
	}
	
	@Override
	public MessageResource getMessagesById(int messageId) {
		List<MessageResource> messageList = Util.getMessagesList();
		MessageResource newMessage = null;
		for (MessageResource message : messageList) {
			if (message.getId() == messageId) {
				newMessage = message;
			}
		}
		if (newMessage == null) {
			logger.error("No message found with id: " + messageId);
			throw new DataNotFoundException("Not able to find message with id: " + messageId);
		}
		// Remove if any link is already existed and add new URI link to resource
		newMessage.removeLinks();
		Link selfLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(MessageController.class).getMessageById(messageId)).withSelfRel();
		newMessage.add(selfLink);
		logger.info("Found message with id: " + messageId);
		return newMessage;
	}

	@Override
	public void saveMessage(MessageResource messageResource) {
		if (messageResource.getCommentsList() == null) {
			messageResource.setCommentsList(new ArrayList<>());
		}
		Util.addMessage(messageResource);
		logger.info("Saved message successfully");
	}

	@Override
	public void updateMessage(int messageId, MessageResource messageResource) {
		List<MessageResource> messageList = Util.getMessagesList();
		boolean messageFound = false;
		for (MessageResource message : messageList) {
			if (message.getId() == messageId) {
				messageFound = true;
				message.setAuthor(messageResource.getAuthor());
				message.setMessage(messageResource.getMessage());
				message.setPostedDate(messageResource.getPostedDate());
				break;
			}
		}
		if (messageFound) {
			logger.info("Updated message with id: " + messageId);
		} else {
			logger.error("Can't update message because message with id: " + messageId + " not found");
			throw new DataNotFoundException(
					"Can't update message because message with id: " + messageId + " not found");
		}
	}

	@Override
	public void deleteMessage(int messageId) {
		List<MessageResource> messageList = Util.getMessagesList();
		boolean messageFound = false;
		for (MessageResource message : messageList) {
			if (message.getId() == messageId) {
				messageFound = true;
				messageList.remove(message);
				break;
			}
		}
		if (messageFound) {
			logger.info("Deleted message with id: " + messageId);
		} else {
			logger.error("Can't delete message because message with id: " + messageId + " not found");
			throw new DataNotFoundException(
					"Can't delete message because message with id: " + messageId + " not found");
		}
	}

	@Override
	public List<MessageResource> getMessagesByAuthorName(String authorName) {
		List<MessageResource> messageList = Util.getMessagesList();
		List<MessageResource> newMessageList = new ArrayList<>();
		for (MessageResource message : messageList) {
			if (message.getAuthor().equalsIgnoreCase(authorName)) {
				newMessageList.add(message);
			}
		}
		if (newMessageList.isEmpty()) {
			logger.error("Not able to find message with author name: " + authorName);
			throw new DataNotFoundException("Not able to find message with author name: " + authorName);
		}
		linkBuilder.addLinksToMessages(newMessageList);
		logger.info("Found message with author: " + authorName);
		return newMessageList;
	}

}