package com.revature.hibernate;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session mySession;
	private static SessionFactory mySessionFactory;
	
	private HibernateUtil() {}
	
	
	public static Session getSession() {
		if (mySession == null) {
			mySession = HibernateUtil.buildSessionFactory().openSession();
			return mySession;
		}
		return mySession;
	}
	
	public static SessionFactory getSessionFactory() {
		if (mySessionFactory == null) {
			mySessionFactory = HibernateUtil.buildSessionFactory();
		}
		return mySessionFactory;
	}
	
	
	
	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
	
	

}
