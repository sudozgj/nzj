package org.dao.imp;

import org.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.User;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;
import org.view.VUser;
import org.view.VUserId;

@Service
public class UserDaoImp implements UserDao {

	@Override
	public long addUser(User u) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			long id = (Long) session.save(u);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteUser(Long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts=  session.beginTransaction();
			User u = (User) session.load(User.class, id);
			session.delete(u);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	@Override
	public boolean updateUser(User u) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			session.update(u);
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	@Override
	public User getUser(Long phone) {		
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from User where phone=?");
			query.setParameter(0, phone);
			query.setMaxResults(1);
			User u = (User) query.uniqueResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return new User();			//注意，这里应该返回对象，因为phone能用，返回的是null
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public User getUser(Long phone, String password) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from User where phone=? and password=?");
			query.setParameter(0, phone);
			query.setParameter(1, password);
			query.setMaxResults(1);
			User u = (User) query.uniqueResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public VUserId getUserById(Long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			SQLQuery sqlQuery = session.createSQLQuery("select * from v_user where id=?");
			sqlQuery.setParameter(0, id);
			sqlQuery.addEntity(VUser.class);
			sqlQuery.setMaxResults(1);

			VUser v = (VUser) sqlQuery.uniqueResult();
			
			return v.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
