/**
 * @author Amit sharma
 *
 */
module SpringJDBC {
	requires spring.context;
	requires spring.jdbc;
	requires spring.beans;
	requires spring.tx;
	requires spring.core;
	requires java.sql;
	exports com.amit.jdbc;
	opens com.amit.jdbc;
}