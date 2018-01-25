package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Building;
import com.revature.hibernate.model.Location;

public interface LocationDao {

	void insertLocation(Location location);
	Location selectById(int id);
	Location selectByName(String name);
	int getLocationIdByName(String name);
	void updateLocation(int id, String locationName, String locationCity, String locationState);
	List<Location> selectAll();
	void addBuilding(String locationName, Building building);
}
