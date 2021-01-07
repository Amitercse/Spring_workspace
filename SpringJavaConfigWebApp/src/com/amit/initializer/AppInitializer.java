package com.amit.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	  AnnotationConfigWebApplicationContext context
        = new AnnotationConfigWebApplicationContext();
      // setting config location to entire package which needs to be scanned for spring configuration.
	  // we can also register one class- context.register(AppConfig.class)
	  context.setConfigLocation("com.amit.config");
      servletContext.addListener(new ContextLoaderListener(context));
      servletContext.setInitParameter("spring.profiles.active", "dev");
      ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("*.view");
	}
}
