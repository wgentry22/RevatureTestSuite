package com.revature.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.HibernateUtil;
import com.revature.hibernate.model.Building;
import com.revature.hibernate.model.Location;
import com.revature.hibernate.model.Room;

public class LocationDaoImpl implements LocationDao {

	private static LocationDaoImpl daoImpl;
	private static final Logger logger = Logger.getLogger(LocationDaoImpl.class);
	
	private LocationDaoImpl() {}
	
	public static LocationDaoImpl getInstance() {
		if (daoImpl == null) {
			daoImpl = new LocationDaoImpl();
		}
		return daoImpl;
	}
	
	public void insertLocation(Location location) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(location);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public Location selectById(int id) {
		Location location = null;
		Session session = HibernateUtil.getSession();
		try {
			location = (Location) session.createCriteria(Location.class).add(Restrictions.eq("locationId", id)).list().get(0);
			
		} catch (HibernateException h) {
			logger.warn(h);
			h.printStackTrace();
		} finally {
			session.close();
		}
		return location;
	}
	
	public Location selectByName(String name) {
		Location location = null;
		Session session = HibernateUtil.getSession();
		try {
			location = (Location) session.createCriteria(Location.class).add(Restrictions.eq("locationName", name)).list().get(0);
		} catch (HibernateException e) {
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return location;
	}
	
	public List<Location> selectAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Location> list = null;
		try {
			list = session.createQuery("from Location").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	
	
	public void updateLocation(int id, String locationName, String locationCity, String locationState) {
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		Location l1 = null;
		try {
			t = session.beginTransaction();
			l1 = (Location) session.createCriteria(Location.class).add(Restrictions.eq("locationId", id)).list().get(0);
			l1.setLocationName(locationName);
			l1.setLocationCity(locationCity);
			l1.setLocationState(locationState);
			session.saveOrUpdate(l1);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public int getLocationIdByName(String name) {
		int locationId = 0;
		Session session = HibernateUtil.getSession();
		Transaction t = null;
		Location location = null;
		try {
			t = session.beginTransaction();
			location = (Location) session.createCriteria(Location.class).add(Restrictions.eq("locationName", name)).list().get(0);
			locationId = location.getLocationId();
		} catch (HibernateException e) {
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return locationId;
	}
	
	public void deleteLocation(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			Location location = (Location) session.createCriteria(Location.class).add(Restrictions.eq("locationName", name)).list().get(0);
			t = session.beginTransaction();
			session.delete(location);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void addBuilding(String locationName, Building building) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			Location location = (Location) session.createCriteria(Location.class).add(Restrictions.eq("locationName", locationName)).list().get(0);
			location.getBuildings().add(building);
			building.setLocation(location);
			
			t = session.beginTransaction();
			session.persist(location);
//			session.saveOrUpdate(location);
//			session.saveOrUpdate(building);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	public void addRoom(String buildingName, Room room) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			Building building = (Building) session.createCriteria(Building.class).add(Restrictions.eq("buildingName", buildingName)).list().get(0);
			building.getRooms().add(room);
			room.setBuilding(building);
			
			t = session.beginTransaction();
			session.persist(building); 
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
