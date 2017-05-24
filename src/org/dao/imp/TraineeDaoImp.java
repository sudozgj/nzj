package org.dao.imp;

import org.dao.TraineeDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.OrderTrainee;
import org.model.Trainee;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class TraineeDaoImp implements TraineeDao {

	@Override
	public long addTrainee(Trainee o) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			long id = (Long) session.save(o);
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
	public boolean getOrderTrainee(Long trainee_id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("from OrderTrainee where traineeId=?");
			query.setParameter(0, trainee_id);
			query.setMaxResults(1);
			OrderTrainee ot = (OrderTrainee) query.uniqueResult();
			
			if(ot==null)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
