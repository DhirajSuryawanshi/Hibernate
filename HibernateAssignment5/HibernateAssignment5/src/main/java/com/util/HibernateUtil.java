package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.Asset;
import com.model.Employee;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties properties = new Properties();
				properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
				properties.put(Environment.URL, "jdbc:sqlserver://CM1VA819\\SQLEXPRESS;databaseName=assignment4-2");
				properties.put(Environment.USER, "sa");
				properties.put(Environment.PASS, "password_123");
				properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
				properties.put(Environment.SHOW_SQL, "true");
				properties.put(Environment.FORMAT_SQL, "true");
				properties.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(properties);

				configuration.addAnnotatedClass(Asset.class);
				configuration.addAnnotatedClass(Employee.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {

			}

		}

		return sessionFactory;

	}

}
