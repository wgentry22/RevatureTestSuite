package com.revature.hibernate;

import com.revature.hibernate.dao.LocationDaoImpl;
import com.revature.hibernate.model.*;

public class TestClass {

	
	public static void main(String[] args) {
//		Location location = new Location("Southwest HQ", "San Diego", "California");
//		LocationDaoImpl.getInstance().insertLocation(location);
		
//		Building b1 = new Building("Cali Test 1");
//		LocationDaoImpl.getInstance().addBuilding("Southwest HQ", b1);
		
//		Building b2 = new Building("Cali Test 2");
//		LocationDaoImpl.getInstance().addBuilding(location.getLocationName(), b2);
		
//		Building b3 = new Building("Cali Test 3");
//		LocationDaoImpl.getInstance().addBuilding(location.getLocationName(), b3);
		
//		LocationDaoImpl.getInstance().deleteLocation(location.getLocationName());
		
		Room room = new Room("Test Room 1");
		LocationDaoImpl.getInstance().addRoom("Cali Test 1", room);
		
	}
	
}
