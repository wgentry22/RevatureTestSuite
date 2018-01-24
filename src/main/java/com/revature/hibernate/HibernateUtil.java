package com.revature.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session mySession;
	
	private HibernateUtil() {}
	
	
	public static Session getSession() {
		if (mySession == null) {
			mySession = HibernateUtil.getSessionFactory().openSession();
			return mySession;
		}
		return mySession;
	}
	
	
	private static SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
	
	

}
