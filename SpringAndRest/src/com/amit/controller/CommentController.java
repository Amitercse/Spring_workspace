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

import com.amit.model.CommentResource;
import com.amit.service.CommentService;

@RequestMapping("/messages/{messageId}/comments")
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping
	public List<CommentResource> getComments(@PathVariable("messageId") int messageId) {
		return commentService.getComments(messageId);
	}

	@GetMapping("/{commentId}")
	public CommentResource getCommentById(@PathVariable("messageId") int messageId,
			@PathVariable("commentId") int commentId) {
		return commentService.getCommentById(messageId, commentId);
	}

	@PostMapping
	public String postComment(@PathVariable("messageId") int messageId, @RequestBody CommentResource commentResource) {
		commentService.postComment(messageId, commentResource);
		return "comment posted successfully";
	}

	@PutMapping("/{commentId}")
	public String updateComment(@PathVariable("messageId") int messageId, @PathVariable("commentId") int commentId,
			@RequestBody CommentResource commentResource) {
		commentService.updateComment(messageId, commentId, commentResource);
		return "comment updated successfully";
	}

	@DeleteMapping("/{commentId}")
	public String deleteComment(@PathVariable("messageId") int messageId, @PathVariable("commentId") int commentId) {
		commentService.deleteComment(messageId, commentId);
		return "comment deleted successfully";
	}
}
