package org.dao.imp;

import java.util.List;

import org.dao.AuntPhotoDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.AuntPhoto;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class AuntPhotoDaoImp implements AuntPhotoDao{

	@Override
	public List getPhotoByAuntId(long auntId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from AuntPhoto where auntId=?");
			query.setParameter(0, auntId);
			
			List<AuntPhoto> li = query.list();
			
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
}
