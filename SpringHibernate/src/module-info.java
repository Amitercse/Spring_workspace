/**
 * @author Amit sharma
 */
module SpringHibernate {
	requires spring.context;
	requires spring.orm;
	requires spring.beans;
	requires java.persistence;
	requires org.hibernate.orm.core;
	requires spring.core;
	requires java.sql;
	exports com.amit.hibernate;
	opens com.amit.hibernate;
}