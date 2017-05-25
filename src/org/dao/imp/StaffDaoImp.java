package org.dao.imp;

import org.dao.StaffDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Staff;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class StaffDaoImp implements StaffDao{

	@Override
	public long addStaff(Staff o) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			
			long id = (Long) session.save(o);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Staff getStaff(Long phone) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			
			Query query = session.createQuery("from Staff where phone =?");
			query.setParameter(0, phone);
			query.setMaxResults(1);
			Staff s = (Staff) query.uniqueResult();
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return new Staff();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
