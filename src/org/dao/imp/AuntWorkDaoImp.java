package org.dao.imp;

import java.util.List;

import org.dao.AuntWorkDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.AuntWork;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class AuntWorkDaoImp implements AuntWorkDao{

	@Override
	public List getWorkByAuntId(long auntId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from AuntWork where auntId=?");
			query.setParameter(0, auntId);
			
			List<AuntWork> li = query.list();
			
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
