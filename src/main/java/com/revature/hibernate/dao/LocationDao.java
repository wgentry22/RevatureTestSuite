package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Location;

public interface LocationDao {

	void insertLocation(Location location);
	Location selectById(int id);
	Location selectByName(String name);
	void updateLocation(Location location);
	List<Location> selectAll();
}
