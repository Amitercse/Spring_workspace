package com.amit.collectionDependency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.amit.collectionDependency")
public class AppConfig {
	
	@Bean
	public Map<String, Student> studentMap()
	{
		Map map= new HashMap<String, Student>();
		map.put("student1", student1());
		map.put("student2", student2());
		map.put("student3", student3());
		return map;
	}

	@Bean
	public Student student1()
	{
		return new Student(1, "student1");
	}
	
	@Bean
	public Student student2()
	{
		return new Student(2, "student2");
	}
	
	@Bean
	public Student student3()
	{
		return new Student(3, "student3");
	} 
}
