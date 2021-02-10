module SpringBatch {
	requires spring.context;
	requires spring.jdbc;
	requires spring.beans;
	requires spring.tx;
	requires spring.core;
	requires java.sql;
	requires spring.batch.core;
	requires spring.batch.infrastructure;
	requires javax.batch.api;
	requires spring.retry;
	requires aspectjrt;
	requires spring.aop;
	exports com.amit.model;
	exports com.amit.service;
	exports com.amit.aop;
	opens com.amit.service;
	opens com.amit.aop;
}