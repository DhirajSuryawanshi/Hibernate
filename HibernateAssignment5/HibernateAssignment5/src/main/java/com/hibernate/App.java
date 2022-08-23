package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Asset;
import com.model.Employee;
import com.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

		Session session = sessionfactory.openSession();
		Transaction t = session.beginTransaction();
		insert(session);
		session.getTransaction().commit();
	}

	private static void update(Session session) {
		Employee employee = session.get(Employee.class, 105);
		employee.setPassword("employee@123");
		session.saveOrUpdate(employee);
	}

	private static void delete(Session session) {
		Employee employee = session.get(Employee.class, 10);
		session.remove(employee);
	}

	private static void insert(Session session) {
		Asset asset = new Asset(105, 4844, 52852, "PC", 85000, "Pune");
		Employee employee = new Employee("Raj", 12, "abcdef", asset);
		session.save(asset);
		session.save(employee);

	}

	private static void read(Session session) {
		Asset a1 = session.get(Asset.class, 105);
		System.out.println(a1);

		Asset a2 = session.load(Asset.class, 106);
		System.out.println(a2);

	}
}
