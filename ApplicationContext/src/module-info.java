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
	exports com.amit.appContext;
	opens com.amit.appContext;
	opens com.amit.multipleConfig;
	opens com.amit.bean;
}