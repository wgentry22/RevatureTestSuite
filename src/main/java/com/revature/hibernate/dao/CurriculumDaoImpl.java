package com.revature.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.HibernateUtil;
import com.revature.hibernate.model.Curriculum;

public class CurriculumDaoImpl implements CurriculumDao {

	private static CurriculumDaoImpl currDao;
	
	private CurriculumDaoImpl () {}
	
	public static CurriculumDaoImpl getInstance() {
		if (currDao == null) {
			currDao = new CurriculumDaoImpl();
		}
		return currDao;
	}
	
	
	public void insertCurriculum(Curriculum curriculum) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(curriculum);
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
	
	public Curriculum selectCurriculumByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		Curriculum curriculum = null;
		try {
			curriculum = (Curriculum) session.createCriteria(Curriculum.class).add(Restrictions.eq("curriculumName", name)).list().get(0);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return curriculum;
	}
	
	public Curriculum selectCurriculumById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Curriculum curriculum = null;
		try {
			curriculum = (Curriculum) session.createCriteria(Curriculum.class).add(Restrictions.eq("curriculumId", id)).list().get(0);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return curriculum;
	}
	
	public List<Curriculum> selectAllCurriculum() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Curriculum> list = null;
		try {
			list = session.createQuery("from Curriculum").list();
		} finally {
			session.close();
		}
		return list;
	}
	
	public void updateCurriculum(Curriculum curriculum, String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			curriculum.setCurriculumName(name);
			session.saveOrUpdate(curriculum);
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
