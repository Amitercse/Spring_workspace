/**
 * 
 */
/**
 * @author Amit sharma
 *
 */
module ApplicationContext {
	requires spring.beans;
	requires spring.core;
	requires spring.context;
	requires java.annotation;
	requires javax.inject;
	exports com.amit.appContext;
	exports com.amit.autowire;
	opens com.amit.appContext;
	opens com.amit.annotation;
	opens com.amit.multipleConfig;
	opens com.amit.bean;
	opens com.amit.collectionDependency;
}