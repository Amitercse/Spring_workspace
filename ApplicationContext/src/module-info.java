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
	requires jdk.jdi;
	exports com.amit.appContext;
	exports com.amit.autowire;
	exports com.amit.profile;
	opens com.amit.appContext;
	opens com.amit.annotation;
	opens com.amit.multipleConfig;
	opens com.amit.bean;
	opens com.amit.collectionDependency;
	opens com.amit.lazy;
	opens com.amit.i18n;
	opens com.amit.spel;
	opens com.amit.profile;
}