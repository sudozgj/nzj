package org.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dao.TraineeDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.OrderTrainee;
import org.model.Trainee;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;
import org.view.VOrderTraineeLink;

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
	public boolean deleteTrainee(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			
			Trainee t=  (Trainee) session.load(Trainee.class, id);
			session.delete(t);
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List getTraineeListByOrderId(Long orderId, Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			
			String sql = "select * from v_order_trainee_link where order_id=?";
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setParameter(0, orderId);
			sqlQuery.addEntity(VOrderTraineeLink.class);
			
			if (start == null) {
				start = 0;
			}
			sqlQuery.setFirstResult(start);
			if (limit == null) {
				limit = 15;
				sqlQuery.setMaxResults(limit);
			}else if(limit==-1){
				
			}else{
				sqlQuery.setMaxResults(limit);
			}
			
			List<VOrderTraineeLink> li = sqlQuery.list();
			List list = new ArrayList<>();
			
			for(VOrderTraineeLink v:li){
				list.add(v.getId());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long getTraineeCountByOrderId(Long orderId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			
			String sql = "select count(v.id.id) from VOrderTraineeLink v where v.id.orderId=?";
			Query query = session.createQuery(sql);
			query.setParameter(0, orderId);
			
			query.setMaxResults(1);
			long count= (long) query.uniqueResult();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List getUnBindTraineeList(Long uid, Integer start,
			Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from Trainee where userId=? and bind=0");
			query.setParameter(0, uid);
			
			if (start == null) {
				start = 0;
			}
			query.setFirstResult(start);
			if (limit == null) {
				limit = 15;
				query.setMaxResults(limit);
			} else if (limit == -1) {

			} else {
				query.setMaxResults(limit);
			}
			
			List<Trainee> li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long getUnBindTraineeCount(Long uid) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("select count(id) from Trainee where userId=? and bind=0");
			query.setParameter(0, uid);
			query.setMaxResults(1);
			long count = (long) query.uniqueResult();
			
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List getTraineeListByUserId(Long userId, Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from Trainee where userId=?");
			query.setParameter(0, userId);
			
			if (start == null) {
				start = 0;
			}
			query.setFirstResult(start);
			if (limit == null) {
				limit = 15;
				query.setMaxResults(limit);
			} else if (limit == -1) {

			} else {
				query.setMaxResults(limit);
			}
			
			List<Trainee> li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long getTraineeCount(Long userId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

//	@Override
//	public boolean getOrderTrainee(Long trainee_id) {
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction ts = session.beginTransaction();
//
//			Query query = session
//					.createQuery("from OrderTrainee where traineeId=?");
//			query.setParameter(0, trainee_id);
//			query.setMaxResults(1);
//			OrderTrainee ot = (OrderTrainee) query.uniqueResult();
//			
//			if(ot==null)
//				return false;
//			else
//				return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}finally{
//			HibernateSessionFactory.closeSession();
//		}
//	}

}
