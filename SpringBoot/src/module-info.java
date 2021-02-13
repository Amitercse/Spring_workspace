module SpringBoot {
	requires spring.context;
	requires spring.beans;
	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.core;
	requires spring.jdbc;
	requires java.sql;
	requires spring.tx;
	exports com.amit.dao;
	exports com.amit.service;
	exports com.amit.model;
	opens com.amit.app;
	opens com.amit.dao;
	opens com.amit.service;
	opens com.amit.model;
}