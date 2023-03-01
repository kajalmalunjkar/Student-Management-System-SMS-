package org.demo.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App 
{
    public static void main( String[] args )
    {
    	Resource resource=new ClassPathResource("applicationContext.xml"); 
    	BeanFactory factory=new XmlBeanFactory(resource);
    	
    	System.out.println(factory.getBean("student1"));
    	System.out.println(factory.getBean("student2"));
    	System.out.println(factory.getBean("student3"));
    	System.out.println(factory.getBean("student4"));
    }
}
