package com.amit.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.amit.controller.CommentController;
import com.amit.exception.DataNotFoundException;
import com.amit.model.CommentResource;
import com.amit.model.MessageResource;
import com.amit.util.LinkBuilder;
import com.amit.util.Util;

@Component
public class CommentServiceImpl implements CommentService {

	@Autowired
	private LinkBuilder linkBuilder;
	
	private static final Logger logger = Logger.getLogger(CommentServiceImpl.class.getName());
	
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
			logger.error("No comment found because message with id: " + messageId + " is not present");
			throw new DataNotFoundException(
					"No comment found because message with id: " + messageId + " is not present");
		}
		// Add URI link to resources
		List<CommentResource> commentList = messageResource.getCommentsList();
		linkBuilder.addLinksToComments(messageId, commentList);
		logger.info("Found comments for message id: " + messageId + ", comments size: " + commentList.size());
		return commentList;
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
			logger.error("Can't find comments because no message found with id: " + messageId);
			throw new DataNotFoundException("Can't find comments because no message found with id: " + messageId);
		}
		CommentResource commentResource = null;
		for (CommentResource comment : messageResource.getCommentsList()) {
			if (comment.getId() == commentId) {
				commentResource = comment;
				break;
			}
		}
		if (commentResource == null) {
			logger.error("No comment found with id: " + commentId);
			throw new DataNotFoundException("No comment found with id: " + commentId);
		}
		// Remove if any link is already existed and add new URI link to resource
		Link selfLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CommentController.class).getCommentById(messageId, commentId))
				.withSelfRel();
		commentResource.removeLinks();
		commentResource.add(selfLink);
		logger.info("Found comment for message id: " + messageId + ", and comment id: " + commentId);
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
			logger.error("Not able to save comment because no message found with id: " + messageId);
			throw new DataNotFoundException("Not able to save comment because no message found with id: " + messageId);
		}
		logger.info("Save comment successfully");
		messageResource.getCommentsList().add(comment);
	}

	@Override
	public void updateComment(int messageId, int commentId, CommentResource comment) {
		List<MessageResource> messagesList = Util.getMessagesList();
		MessageResource messageResource = null;
		boolean commentFound = false;
		for (MessageResource message : messagesList) {
			if (message.getId() == messageId) {
				messageResource = message;
				break;
			}
		}
		if (messageResource == null) {
			logger.error("Not able to update comment because not able to find message with id: " + messageId);
			throw new DataNotFoundException("Not able to update comment because no message found with id: " + messageId);
		}
		for (CommentResource commentResource : messageResource.getCommentsList()) {
			if (commentResource.getId() == commentId) {
				commentFound = true;
				commentResource.setAuthorName(comment.getAuthorName());
				commentResource.setComment(comment.getComment());
				commentResource.setPostedDate(comment.getPostedDate());
				break;
			}
		}
		if (commentFound) {
			logger.info("Updated comment with message id: " + messageId + " and comment id: " + commentId);
		} else {
			logger.error("Not able to update comment because comment with id: " + commentId + " and message id: "
					+ messageId + " not found");
			throw new DataNotFoundException("Not able to update comment because comment with id: " + commentId
					+ " and message id: " + messageId + " not found");
		}
	}

	@Override
	public void deleteComment(int messageId, int commentId) {
		List<MessageResource> messagesList = Util.getMessagesList();
		MessageResource messageResource = null;
		boolean commentFound = false;
		for (MessageResource message : messagesList) {
			if (message.getId() == messageId) {
				messageResource = message;
				break;
			}
		}
		if (messageResource == null) {
			logger.error("Can't delete comment because no message found with id: " + messageId);
			throw new DataNotFoundException("Can't delete comment because no message found with id: " + messageId);
		}
		for (CommentResource commentResource : messageResource.getCommentsList()) {
			if (commentResource.getId() == commentId) {
				commentFound = true;
				messageResource.getCommentsList().remove(commentResource);
				break;
			}
		}
		if (commentFound) {
			logger.info("Deleted comment with id: " + commentId);
		} else {
			logger.error("Can't delete comment because no comment found with id: " + commentId + " and message id: "
					+ messageId);
			throw new DataNotFoundException("Can't delete comment because no comment found with id: " + commentId
					+ " and message id: " + messageId);
		}
	}

}
