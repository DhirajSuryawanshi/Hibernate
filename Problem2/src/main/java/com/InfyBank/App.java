package com.InfyBank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.InfyBank.dao.Customer;
import com.InfyBank.dao.Locker;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session session = sf.openSession();
    	Locker locker = new Locker(101,"small", 1500);
    	Customer cust = new Customer(1004, "William", "17-05-1995", "Kolkata", "9067767872", locker);
    	
    	session.beginTransaction();
    	session.save(locker);
    	session.save(cust);
    	session.getTransaction().commit();
    	Customer customer = (Customer)session.get(Customer.class, 1004);
    	System.out.println(customer);
    	session.close();
    	sf.close();
    }
}
