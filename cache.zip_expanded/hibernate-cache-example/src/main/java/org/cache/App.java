package org.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class App 
{
    public static void main( String[] args )
    {

        SessionFactory factory=HibernateConfig.getSessionFactory();
        Session session1=factory.openSession();
        
        
        Transaction transaction=session1.beginTransaction();
        
        
        //Book book=new Book(3222, "Programming in Java", "James Gosling", "ABC", 1500);
        
        //session.save(book);
        Book book=session1.get(Book.class, new Long(3222));
        System.out.println(book);
        
        Session session2=factory.openSession();
        Transaction transaction1=session2.beginTransaction();
        Book book1=session1.get(Book.class, new Long(3222));
        System.out.println(book1);
        
        //transaction.commit();
        session1.close();
        session2.close();
    	
    }
}
