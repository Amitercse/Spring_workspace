package com.amit.collectionDependency;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Department {

	@Autowired
	private List<Student> studentList;
	@Autowired
	private Map<String, Student> studentMap;

	/**
	 * @return the studentList
	 */
	public List<Student> getStudentList() {
		return studentList;
	}

	/**
	 * @param studentList the studentList to set
	 */
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	/**
	 * @return the studentMap
	 */
	public Map<String, Student> getStudentMap() {
		return studentMap;
	}

	/**
	 * @param studentMap the studentMap to set
	 */
	public void setStudentMap(Map<String, Student> studentMap) {
		this.studentMap = studentMap;
	}
	
}
