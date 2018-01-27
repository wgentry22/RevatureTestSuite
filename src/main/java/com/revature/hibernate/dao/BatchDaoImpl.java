package com.revature.hibernate.dao;

import static com.revature.hibernate.HibernateUtil.getSession;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.model.Batch;

public class BatchDaoImpl implements BatchDao {
	
	private static final Logger logger = Logger.getLogger(BatchDaoImpl.class);

	@Override
	public void createBatch(Batch batch) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			
			session.save(batch);				// creates a new batch
			
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
	
	@Override
	public void editBatch(Batch batch) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			
			session.update(batch);				// updated a current batch
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
		} finally {
			session.close();
		}

	}

	@Override
	public void cloneBatch(Batch batch) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			
			session.save(batch);				// creates a new batch with the same details of another batch (except batch ID)
			
			session.getTransaction().commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void deleteBatch(Batch batch) {
		Session session = getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			
			session.delete(batch);				// delete a batch
			
			session.getTransaction().commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			logger.warn(e);
		} finally {
			session.close();
		}
	}
	
}
