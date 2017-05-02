package org.dao.imp;

import org.dao.UserDetailDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.UserDetail;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class UserDetailDaoImp implements UserDetailDao {
	public long addUserDetail(UserDetail ud) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			long id = (Long) session.save(ud);
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
	public boolean updateUserDetail(UserDetail ud) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			session.update(ud);
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
	public UserDetail getUserDetail(String username) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from UserDetail where username=?");
			query.setParameter(0, username);
			query.setMaxResults(1);
			UserDetail ud = (UserDetail) query.uniqueResult();
			
			return ud;
		} catch (Exception e) {
			e.printStackTrace();
			return new UserDetail();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}
