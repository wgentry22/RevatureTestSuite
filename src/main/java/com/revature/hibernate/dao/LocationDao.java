package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Building;
import com.revature.hibernate.model.Location;
import com.revature.hibernate.model.Room;

public interface LocationDao {

	void insertLocation(Location location);
	Location selectById(int id);
	Location selectByName(String name);
	int getLocationIdByName(String name);
	void updateLocation(int id, String locationName, String locationCity, String locationState);
	List<Location> selectAll();
	void deleteLocation(String name);
	void addBuilding(String locationName, Building building);
	void addRoom(String buildingName, Room room);
}
