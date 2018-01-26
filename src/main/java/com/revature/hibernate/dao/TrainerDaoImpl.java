package com.revature.hibernate.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.model.Skill;
import com.revature.hibernate.model.Trainer;
import static com.revature.hibernate.HibernateUtil.*;

public class TrainerDaoImpl implements TrainerDao {
	
	
	private static final Logger logger = Logger.getLogger(TrainerDaoImpl.class);

	@Override
	public void insertTrainer(Trainer trainer) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.save(trainer);
			t.commit();
			
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Trainer> selectAllTraineres() {
		Session session = getSession();
		List<Trainer> list = null;
		try {
			list = session.createQuery("from trainer").list();
		} catch (HibernateException e){
			logger.warn(e);
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public Trainer selectTrainerByName(String name) {
		Session session = getSession();
		Trainer trainer = null;
		try {
			trainer = (Trainer) session.createCriteria(Trainer.class).add(Restrictions.eq("trainerName", name)).list().get(0);
		} catch (HibernateException e) {
			logger.warn(e);
			e.printStackTrace();
		}
		return trainer;
	}

	@Override
	public Trainer selectTrainerById(int id) {
		Trainer trainer = null;
		Session session = getSession();
		try {
			trainer = (Trainer) session.get(Trainer.class, id);
		} catch (HibernateException e) {
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		return trainer;
	}

	@Override
	public void deleteTrainer(String name) {
		Session session = getSession();
		try {
			Trainer trainer = (Trainer) session.createCriteria(Trainer.class).add(Restrictions.eq("trainerName", name)).list().get(0);
			Transaction t = session.beginTransaction();
			session.delete(trainer);
			t.commit();
		} catch (HibernateException e) {
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void addSkill(String trainerFirstName, String trainerLastName, Skill skill) {
		Session session = null;
		try {
			session = getSession();
			Transaction t = session.beginTransaction();
			Criterion crit = Restrictions.conjunction().add(Restrictions.eq("trainerFirstName", trainerFirstName)).add(Restrictions.eq("trainerLastName", trainerLastName));
			Trainer trainer = (Trainer) session.createCriteria(Trainer.class).add(crit).list().get(0);
			trainer.getTrainerSkill().add(skill);
			session.saveOrUpdate(trainer);
			t.commit();
		} catch (HibernateException e) {
			logger.warn(e);
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void addResume() {
		
	}

}
