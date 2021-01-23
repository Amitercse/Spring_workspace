package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.amit.util.ResponseMessage;

@RequestMapping("/messages/{messageId}/comments")
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ResponseMessage responseMessage;

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
	public ResponseEntity<ResponseMessage> postComment(@PathVariable("messageId") int messageId,
			@RequestBody CommentResource commentResource) {
		commentService.postComment(messageId, commentResource);
		responseMessage.setMessageCode(800);
		responseMessage.setMessage("Comment posted successfully");
		return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
	}

	@PutMapping("/{commentId}")
	public ResponseEntity<ResponseMessage> updateComment(@PathVariable("messageId") int messageId,
			@PathVariable("commentId") int commentId, @RequestBody CommentResource commentResource) {
		commentService.updateComment(messageId, commentId, commentResource);
		responseMessage.setMessageCode(800);
		responseMessage.setMessage("Comment updated successfully");
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

	@DeleteMapping("/{commentId}")
	public ResponseEntity<ResponseMessage> deleteComment(@PathVariable("messageId") int messageId,
			@PathVariable("commentId") int commentId) {
		commentService.deleteComment(messageId, commentId);
		responseMessage.setMessageCode(800);
		responseMessage.setMessage("Comment deleted successfully");
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}
}
