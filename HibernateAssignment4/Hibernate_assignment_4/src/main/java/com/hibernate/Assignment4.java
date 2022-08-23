package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.util.HibernateUtil;

public class Assignment4 {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Query q1 = session.createQuery("SELECT MAX(revenueInDollars) FROM Movie");

		Query q2 = session.createQuery("SELECT MIN(revenueInDollars) FROM Movie");

		Query q3 = session.createQuery("SELECT SUM(revenueInDollars) FROM Movie");

		Query q4 = session.createQuery("SELECT AVG(revenueInDollars) FROM Movie");

		String language = "English";
		Query q5 = session.createQuery("SELECT COUNT(*) FROM Movie where language=:lan");
		q5.setString("lan", language);
		System.out.println("\nAs per Provided language total count -->  " + q5.list() + "\n");

		Query q6 = session.createQuery("SELECT COUNT(*) FROM Movie m GROUP BY m.language");
		System.out.println(q6.list() + "\n");
	}
}
