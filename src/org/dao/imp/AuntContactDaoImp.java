package org.dao.imp;

import java.util.List;

import org.dao.AuntContactDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.AuntContact;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class AuntContactDaoImp implements AuntContactDao{

	@Override
	public List getContactByAuntId(long auntId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from AuntContact where auntId=?");
			query.setParameter(0, auntId);
			
			List<AuntContact> li = query.list();
			
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
