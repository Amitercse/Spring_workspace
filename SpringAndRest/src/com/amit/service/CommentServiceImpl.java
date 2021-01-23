package com.amit.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amit.exception.DataNotFoundException;
import com.amit.model.CommentResource;
import com.amit.model.MessageResource;
import com.amit.util.Util;

@Component
public class CommentServiceImpl implements CommentService {

	@Override
	public List<CommentResource> getComments(int messageId) {
		List<MessageResource> messagesList = Util.getMessagesList();
		MessageResource messageResource = null;
		for (MessageResource message : messagesList) {
			if (message.getId() == messageId) {
				messageResource = message;
				break;
			}
		}
		if (messageResource == null) {
			throw new DataNotFoundException("No meesage found with id: " + messageId);
		}
		return messageResource.getCommentsList();
	}

	@Override
	public CommentResource getCommentById(int messageId, int commentId) {
		List<MessageResource> messagesList = Util.getMessagesList();
		MessageResource messageResource = null;
		for (MessageResource message : messagesList) {
			if (message.getId() == messageId) {
				messageResource = message;
				break;
			}
		}
		if (messageResource == null) {
			throw new DataNotFoundException("No message found with id: " + messageId);
		}
		CommentResource commentResource = null;
		for (CommentResource comment : messageResource.getCommentsList()) {
			if (comment.getId() == commentId) {
				commentResource = comment;
				break;
			}
		}
		if (commentResource == null) {
			throw new DataNotFoundException("No comment found with id: " + commentId);
		}
		return commentResource;
	}

	@Override
	public void postComment(int messageId, CommentResource comment) {
		List<MessageResource> messagesList = Util.getMessagesList();
		MessageResource messageResource = null;
		for (MessageResource message : messagesList) {
			if (message.getId() == messageId) {
				messageResource = message;
				break;
			}
		}
		if (messageResource == null) {
			throw new DataNotFoundException("No message found with id: " + messageId);
		}
		messageResource.getCommentsList().add(comment);
	}

	@Override
	public void updateComment(int messageId, int commentId, CommentResource comment) {
		List<MessageResource> messagesList = Util.getMessagesList();
		MessageResource messageResource = null;
		for (MessageResource message : messagesList) {
			if (message.getId() == messageId) {
				messageResource = message;
				break;
			}
		}
		if(messageResource== null)
		{
			throw new DataNotFoundException("No message found with id: "+ messageId);
		}
		for (CommentResource commentResource : messageResource.getCommentsList()) {
			if (commentResource.getId() == commentId) {
				commentResource.setAuthorName(comment.getAuthorName());
				commentResource.setComment(comment.getComment());
				commentResource.setPostedDate(comment.getPostedDate());
				break;
			}
		}
	}

	@Override
	public void deleteComment(int messageId, int commentId) {
		List<MessageResource> messagesList = Util.getMessagesList();
		MessageResource messageResource = null;
		for (MessageResource message : messagesList) {
			if (message.getId() == messageId) {
				messageResource = message;
				break;
			}
		}
		if(messageResource == null)
		{
			throw new DataNotFoundException("No message found with id: "+ messageId);
		}
		for (CommentResource commentResource : messageResource.getCommentsList()) {
			if (commentResource.getId() == commentId) {
				messageResource.getCommentsList().remove(commentResource);
				break;
			}
		}
	}

}
