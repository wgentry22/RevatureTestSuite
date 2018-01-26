package com.revature.hibernate.dao;

import static com.revature.hibernate.HibernateUtil.getSession;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.model.Skill;

public class SkillDaoImpl implements SkillDao {

	@Override
	public void insertSkill(Skill skill) {
		Session session = null;
		try {
			session = getSession();
			Transaction t = session.beginTransaction();
			session.saveOrUpdate(skill);
			t.commit();
		} catch (HibernateException e) {
			
		} finally {
			session.close();
		}
	}

}
