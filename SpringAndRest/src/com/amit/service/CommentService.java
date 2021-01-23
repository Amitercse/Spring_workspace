package com.amit.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amit.model.CommentResource;

@Component
public interface CommentService {

	public List<CommentResource> getComments(int messageId);
	
	public CommentResource getCommentById(int messageId, int commentId);
	
	public void postComment(int messageId, CommentResource comment);
	
	public void updateComment(int messageId, int commentId, CommentResource comment);
	
	public void deleteComment(int messageId, int commentId);
}
