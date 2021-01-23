package com.amit.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.amit.controller.CommentController;
import com.amit.controller.MessageController;
import com.amit.model.CommentResource;
import com.amit.model.MessageResource;

@Component
public class LinkBuilder {

	public void addLinksToMessages(List<MessageResource> messageList)
	{
		for (MessageResource message : messageList) {
			Link selfLink = WebMvcLinkBuilder.linkTo(MessageController.class).slash(message.getId()).withSelfRel();
			message.add(selfLink);
			addLinksToComments(message.getId(), message.getCommentsList());
		}
	}
	
	public void addLinksToComments(int messageId, List<CommentResource> commentList)
	{
		final Map<String, Object> parameters = new HashMap<>();
		parameters.put("messageId", messageId);
		for(CommentResource commentResource: commentList)
		{
			commentResource.removeLinks();
			Link selfLink = WebMvcLinkBuilder.linkTo(CommentController.class,parameters).slash(commentResource.getId()).withSelfRel();
			commentResource.add(selfLink);
		}
	}
}
