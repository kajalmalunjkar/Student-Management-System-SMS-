package org.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory=HibernateConfig.getSessionFactory();
        Session session=factory.openSession();
        
        if(session!=null)
        {
        	System.out.println("session initialized!!");
        }
        Transaction transaction=session.beginTransaction();
        
        Projects project1=new Projects(111, "Ecommerce");       
        Projects project2=new Projects(222, "Banking");
        
        List<Projects> projects=new ArrayList<>();
        projects.add(project1);
        projects.add(project2);
        
        
        
        Employees employee1=new Employees("Aman", "Roy", 40000);
        Employees employee2=new Employees("Kumar", "Roy", 60000);
        
        List<Employees> employees=new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        
        employee1.setProjects(projects);
        employee2.setProjects(projects);
        
        project1.setEmployees(employees);
        project2.setEmployees(employees);
        
        
        session.save(project1);
        session.save(project2);
        
        session.save(employee1);
        session.save(employee2);
        
        
        
        
        transaction.commit();
        
        session.close();
        factory.close();
        
        
        
        
        
    }
}
