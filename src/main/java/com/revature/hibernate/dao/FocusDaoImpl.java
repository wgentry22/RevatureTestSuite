package com.revature.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.HibernateUtil;
import com.revature.hibernate.model.Focus;
import com.revature.hibernate.model.Skill;

public class FocusDaoImpl implements FocusDao {

	public void insertFocus(Focus focus) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(focus);
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

	@Override
	public List<Focus> selectAllFocuses() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Focus> list = null;
		try {
			list = session.createQuery("from Focus").list();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Focus selectFocusByName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Focus focus = null;
		try {
			focus = (Focus) session.createCriteria(Focus.class).add(Restrictions.eq("focusName", name)).list().get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return focus;
	}

	@Override
	public Focus selectFocusById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Focus focus = null;
		try {
			focus = (Focus) session.createCriteria(Focus.class).add(Restrictions.eq("focusId", id)).list().get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return focus;
	}

	@Override
	public void deleteFocus(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {
			Focus focus = (Focus) session.createCriteria(Focus.class).add(Restrictions.eq("focusName", name)).list().get(0);
			t = session.beginTransaction();
			session.delete(focus);
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

	@Override
	public void addSkill(String focusName, Skill skill) {
		// TODO Auto-generated method stub
		
	}

}
