package org.dao.imp;

import java.util.List;

import org.dao.OrderDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Order;
import org.model.Pact;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class OrderDaoImp implements OrderDao {

	@Override
	public long addOrder(Order o) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts=  session.beginTransaction();
			
			long id = (Long)session.save(o);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public List<Order> getOrderList(Long userId,Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from Order where userId = ? order by id desc");
			query.setParameter(0, userId);
			if (start == null) {
				start = 0;
			}
			query.setParameter(0, userId);
			if (limit == null) {
				limit = 15;
				query.setMaxResults(limit);
			} else if (limit == -1) {

			} else {
				query.setMaxResults(limit);
			}
			List<Order> li = query.list();

			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long getOrderCount(Long userId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("select count(id) from Order where userId=?");
			query.setParameter(0, userId);
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

	@Override
	public boolean deleteOrder(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			
			Order o = (Order) session.load(Order.class, id);
			session.delete(o);
			
			ts.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Override
//	public boolean addOrder(Order o, final OrderTraineeForm ot) {
//		try {
//			Session session = HibernateSessionFactory.getSession();
//			Transaction ts = session.beginTransaction();
//
//			final long id = (Long) session.save(o);
//			session.doWork(new Work() {
//				@Override
//				public void execute(Connection conn) throws SQLException {
//					// TODO Auto-generated method stub
//					String sql = "insert into order_trainee" +
//							"(name,sex,birthday,address,idnumber,idcardurl1,idcardurl2,infourl,photourl,order_id) " +
//							"value(?,?,?,?,?,?,?,?,?,?)";
//					PreparedStatement stmt = conn.prepareStatement(sql);
//					conn.setAutoCommit(false);
//					for(int i=0;i<ot.getName().length;i++){
//						stmt.setString(1, ot.getName()[i]);
//						stmt.setInt(2, ot.getSex()[i]);
//						stmt.setLong(3, ot.getBirthday()[i]);
//						stmt.setString(4, ot.getAddress()[i]);
//						stmt.setString(5, ot.getIdnumber()[i]);
//						stmt.setString(6, ot.getIdcardurl1()[i]);
//						stmt.setString(7, ot.getIdcardurl2()[i]);
//						stmt.setString(8, ot.getInfourl()[i]);
//						stmt.setString(9, ot.getPhotourl()[i]);
//						stmt.setLong(10, id);
//						
//						stmt.addBatch();
//					}
//					stmt.executeBatch();
//				}
//			});
//			ts.commit();
//			session.flush();
//			session.clear();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		} finally {
//			HibernateSessionFactory.closeSession();
//		}
//	}
	
	
}
