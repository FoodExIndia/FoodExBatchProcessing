package com.foodex.util;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {/*
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from com.foodex.model.OrderEntity");
		List<OrderEntity> orderEntityList = query.list();
		System.out.println(orderEntityList.get(0).getOrderId());
	*/}
}
