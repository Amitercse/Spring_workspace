package com.amit.collectionDependency;

import java.util.List;
import java.util.Map;

public class XMLConfigDept {

	private List<String> dummyList;
	private Map<String, String> dummyMap;
	private List<XMLConfigStudent> studentList;
	private Map<String, XMLConfigStudent> studentMap;
	/**
	 * @return the dummyList
	 */
	public List<String> getDummyList() {
		return dummyList;
	}
	/**
	 * @param dummyList the dummyList to set
	 */
	public void setDummyList(List<String> dummyList) {
		this.dummyList = dummyList;
	}
	/**
	 * @return the dummyMap
	 */
	public Map<String, String> getDummyMap() {
		return dummyMap;
	}
	/**
	 * @param dummyMap the dummyMap to set
	 */
	public void setDummyMap(Map<String, String> dummyMap) {
		this.dummyMap = dummyMap;
	}
	/**
	 * @return the studentList
	 */
	public List<XMLConfigStudent> getStudentList() {
		return studentList;
	}
	/**
	 * @param studentList the studentList to set
	 */
	public void setStudentList(List<XMLConfigStudent> studentList) {
		this.studentList = studentList;
	}
	/**
	 * @return the studentMap
	 */
	public Map<String, XMLConfigStudent> getStudentMap() {
		return studentMap;
	}
	/**
	 * @param studentMap the studentMap to set
	 */
	public void setStudentMap(Map<String, XMLConfigStudent> studentMap) {
		this.studentMap = studentMap;
	}

}
