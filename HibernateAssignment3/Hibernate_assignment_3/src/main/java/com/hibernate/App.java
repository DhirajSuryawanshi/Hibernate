package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.util.HibernateUtil;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		String language = "English";
		String str1 = "from Movie m where m.language = :lan";
		Query q1 = session.createQuery(str1);
		q1.setString("lan", language);
		List list = q1.list();
		for (Object l : list) {

		}

		String str2 = "from Movie where director_directorID='D101'";
		Query q2 = session.createQuery(str2);
		List list2 = q2.list();
		for (Object l : list2) {

		}

		String str4 = "UPDATE Movie set revenueInDollars = revenueInDollars + 2233 WHERE movieId = :movieId";
		Query q4 = session.createQuery(str4);
		q4.setParameter("movieId", "M1001");

		Query q5 = session.createQuery("delete from Movie where movieId='M1005'");

		Query q6 = session.createQuery("SELECT DISTINCT(language) FROM Movie");
		List resultList = q6.getResultList();

		Query q7 = session.createQuery("select m.movieName, m.director.directorName from Movie m");
		List<Object[]> list7 = q7.list();
		System.out.println("\nMovie Name -- \t\tDirector Name -- ");
		for (Object[] string : list7) {
			System.out.println(string[0] + "\t\t" + string[1]);
		}
		t.commit();
		session.close();
	}
}
