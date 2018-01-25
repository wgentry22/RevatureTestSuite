package com.revature.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.dao.LocationDaoImpl;
import com.revature.hibernate.model.Building;
import com.revature.hibernate.model.Location;

public class TestClass {

	
	public static void main(String[] args) {
		Building building = new Building("Test Building 2");
		LocationDaoImpl.getInstance().addBuilding("Southeast HQ", building);
		
		
		
	}
	
}
