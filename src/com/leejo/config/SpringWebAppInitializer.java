package com.leejo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.leejo.config.ApplicationContextConfig;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
public class SpringWebAppInitializer implements WebApplicationInitializer{
//spring 4 demo leejo jose
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    	appContext.register(ApplicationContextConfig.class);
         
        ServletRegistration.Dynamic dispatcher = container.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
		
	}

}
