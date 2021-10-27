package com.amit.model;

public class DummyMessage {

	private int id;
	private String message;
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
	@Override
	public String toString() {
		return "DummyMessage [id=" + id + ", message=" + message + "]";
	}
}
