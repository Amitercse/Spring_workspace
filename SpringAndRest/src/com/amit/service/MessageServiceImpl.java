package com.amit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.exception.DataNotFoundException;
import com.amit.model.MessageResource;
import com.amit.util.Util;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Override
	public List<MessageResource> getMessages() {
		List<MessageResource> messageList= Util.getMessagesList();
		if(messageList== null)
		{
			throw new DataNotFoundException("No message found");
		}
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