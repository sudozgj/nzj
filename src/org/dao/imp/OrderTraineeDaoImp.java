package org.dao.imp;

import java.util.List;

import org.dao.OrderTraineeDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Order;
import org.model.OrderTrainee;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class OrderTraineeDaoImp implements OrderTraineeDao{

	@Override
	public long addOrderTrainee(OrderTrainee ot) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			long id  = (Long) session.save(ot);
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
	public List<OrderTrainee> getOrderTraineeList(Long orderId,Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from OrderTrainee where orderId = ? order by id desc");
			query.setParameter(0, orderId);
			if (start == null) {
				start = 0;
			}
			query.setParameter(0, orderId);
			if (limit == null) {
				limit = 15;
				query.setMaxResults(limit);
			} else if (limit == -1) {

			} else {
				query.setMaxResults(limit);
			}
			List<OrderTrainee> li = query.list();

			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long getOrderTraineeCount(Long orderId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("select count(id) from OrderTrainee where orderId=?");
			query.setParameter(0, orderId);
			query.setMaxResults(1);
			long count = (long) query.uniqueResult();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
