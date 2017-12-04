package com.leejo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.leejo.bo.Interceptor;
import com.leejo.model.Student;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Configuration
@ComponentScan("com.leejo")
@EnableWebMvc
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{
	@Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }  
	
	//leejo jose demo
	@Autowired
	private Environment env;
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));       
		return dataSource;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory);
		return htm;
	}
	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
	{
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);	 
	    //sessionBuilder.addAnnotatedClasses(User.class,UserProfile.class,Student.class);
	    sessionBuilder.scanPackages("com.leejo.model");
	    return sessionBuilder.buildSessionFactory();
	}
	
	@Bean
	public Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.current_session_context_class", env.getProperty("hibernate.current_session_context_class"));
		
		return properties;
	}

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
             registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
             registry.addResourceHandler("/uploads/**").addResourceLocations("/uploads/");
             registry.addResourceHandler("/albums/**").addResourceLocations("/albums/");
    }
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
	
	
	@Autowired
	@Bean(name = "studentService")
	public Student getUserDetails(){
		return new Student();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new Interceptor());
	}
}
