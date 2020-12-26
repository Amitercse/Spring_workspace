package com.amit.collectionDependency;

public class XMLConfigStudent {

	private int id;
	private String name;
	/**
	 * @param id
	 * @param name
	 */
	public XMLConfigStudent(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "XMLConfigStudent [id=" + id + ", name=" + name + "]";
	}
}
