package com.amit.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.hateoas.RepresentationModel;

@XmlRootElement(name="message")
@XmlType(propOrder = { "id", "author", "message", "postedDate", "commentsList"})
public class MessageResource extends RepresentationModel<MessageResource> {

	private int id;
	private String author;
	private String message;
	private String postedDate;
	List<CommentResource> commentsList;
	
	/**
	 * Default constructor
	 */
	public MessageResource() {
		super();
	}
	
	/**
	 * @param id
	 * @param message
	 * @param author
	 * @param postedDate
	 * @param commentsList
	 */
	public MessageResource(int id, String author, String message, String postedDate,
			List<CommentResource> commentsList) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.postedDate = postedDate;
		this.commentsList = commentsList;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the postedDate
	 */
	public String getPostedDate() {
		return postedDate;
	}
	/**
	 * @param postedDate the postedDate to set
	 */
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	/**
	 * @return the commentsList
	 */
	@XmlElement(name="comment")
	public List<CommentResource> getCommentsList() {
		return commentsList;
	}
	/**
	 * @param commentsList the commentsList to set
	 */
	public void setCommentsList(List<CommentResource> commentsList) {
		this.commentsList = commentsList;
	}

	@Override
	public String toString() {
		return "MessageResource [id=" + id + ", message=" + message + ", author=" + author + ", postedDate="
				+ postedDate + ", commentsList=" + commentsList + "]";
	}
}
