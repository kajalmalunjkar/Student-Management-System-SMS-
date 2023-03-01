package org.mapping;

import java.util.Properties;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateConfig {
  
	private static SessionFactory factory=null;
  	
	
	public static SessionFactory getSessionFactory()
	{
		if(factory==null)
		{
			try
			{
			Configuration configuration=new Configuration();
			
			Properties properties=new Properties();
			properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/manytomany_db");
			properties.setProperty(Environment.USER, "root");
			properties.setProperty(Environment.PASS, "root");
			properties.setProperty(Environment.SHOW_SQL, "true");
			properties.setProperty(Environment.HBM2DDL_AUTO, "update");
			
			configuration.setProperties(properties);
			
			configuration.addAnnotatedClass(Employees.class);
			configuration.addAnnotatedClass(Projects.class);
			
			StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			factory=configuration.buildSessionFactory(serviceRegistry);
			
		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
	
		}
		return factory;
	}
	
	
}
