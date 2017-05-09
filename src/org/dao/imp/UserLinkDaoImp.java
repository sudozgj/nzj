package org.dao.imp;

import org.dao.UserLinkDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.UserLink;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class UserLinkDaoImp implements UserLinkDao{

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
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
}
