package org.dao.imp;

import org.dao.UserLinkDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.UserLink;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class UserLinkDaoImp implements UserLinkDao {

	@Override
	public long addUserLink(UserLink ul) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			long id = (Long) session.save(ul);
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
	public long getParentByChild(Long child) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("select parent from UserLink where child=?");

			query.setParameter(0, child);
			query.setMaxResults(1);
			long id = (long) query.uniqueResult();
			
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}
