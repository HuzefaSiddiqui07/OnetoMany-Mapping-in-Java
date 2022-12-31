package com.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	// Create Configuration return type Method

	public static Configuration getConfiguration() {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		return configuration;
	}

	public static void main(String[] args) {

		Configuration configuration = getConfiguration();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// Create an Object of User Class
		User user = new User();

		// Pass the Value through Constructor

		Policy policy1 = new Policy("H2", "Car Insurance", "Active", user);

		Policy policy2 = new Policy("H4", "Bike Insurance", "Active", user);

		Set<Policy> set = new HashSet<Policy>();

		set.add(policy1);
		set.add(policy2);

		user.setPolicy(set);
		user.setName("Huzefa");
		user.setEmail("huzefa45@gmail.com");

		session.save(user);
		session.save(policy1);
		session.save(policy2);

		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
