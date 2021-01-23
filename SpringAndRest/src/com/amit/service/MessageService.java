package com.amit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.model.MessageResource;

@Service
public interface MessageService {

	public List<MessageResource> getMessages();
	
	public MessageResource getMessagesById(int messageId);
	
	public void saveMessage(MessageResource messageResource);
	
	public void updateMessage(int messageId, MessageResource messageResource);
	
	public void deleteMessage(int messageId);
}
