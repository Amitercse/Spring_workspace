package com.amit.model;

import org.springframework.hateoas.RepresentationModel;

public class CommentResource extends RepresentationModel<CommentResource> {

	private int id;
	private String authorName;
	private String comment;
	private String postedDate;
	private int messageId;
	
	/**
	 * Default constructor
	 */
	public CommentResource() {
		super();
	}
	
	/**
	 * @param id
	 * @param authorName
	 * @param comment
	 * @param postedDate
	 * @param messageId
	 */
	public CommentResource(int id, String authorName, String comment, String postedDate, int messageId) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.comment = comment;
		this.postedDate = postedDate;
		this.messageId = messageId;
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
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @return the messageId
	 */
	public int getMessageId() {
		return messageId;
	}
	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "CommentResource [id=" + id + ", authorName=" + authorName + ", comment=" + comment + ", postedDate="
				+ postedDate + ", messageId=" + messageId + "]";
	}
}
