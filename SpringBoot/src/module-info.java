module SpringBoot {
	requires spring.context;
	requires spring.beans;
	requires spring.boot.autoconfigure;
	requires spring.boot;
	requires spring.core;
	requires spring.jdbc;
	requires java.sql;
	requires spring.tx;
	requires spring.batch.core;
	requires spring.batch.infrastructure;
	requires javax.batch.api;
	exports com.amit.dao;
	exports com.amit.service;
	exports com.amit.model;
	opens com.amit.app;
	opens com.amit.dao;
	opens com.amit.service;
	opens com.amit.model;
}