package org.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dao.OrderDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.model.Board;
import org.model.Order;
import org.model.OrderCheck;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;
import org.view.VOrder;
import org.view.VOrderId;


@Service
public class OrderDaoImp implements OrderDao {

	@Override
	public long addOrder(Order o) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			final long id = (Long) session.save(o);
			
			session.doWork(new Work() {
				@Override
				public void execute(Connection conn) throws SQLException {
					String sql = "insert into order_check(status,description,order_id) values(?,?,?)";
					PreparedStatement stmt = conn.prepareStatement(sql);
					conn.setAutoCommit(false);
					
					stmt.setInt(1, -1);
					stmt.setString(2, "未提交");
					stmt.setLong(3, id);
					stmt.addBatch();
					stmt.executeBatch();
				}
			});
			ts.commit();
			session.flush();
			session.clear();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<VOrderId> getOrderList(Long userId, Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("from VOrder v where v.id.userId = ? order by v.id.status");
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
			
			List<VOrder> li = query.list();
			List<VOrderId> list = new ArrayList<>();
			for(VOrder v:li){
				list.add(v.getId());
			}
			
			return list;
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
			Transaction ts = session.beginTransaction();

			Order o = (Order) session.load(Order.class, id);
			session.delete(o);

			SQLQuery sqlQuery = session
					.createSQLQuery("delete from order_trainee where order_id=?");
			sqlQuery.setParameter(0, id);
			sqlQuery.executeUpdate();
			
			ts.commit();
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateOrderStatus(long id, Integer status,String description) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			String sql = "update order_check o set o.status=?,o.description=? where order_id=?";
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setParameter(0, status);
			sqlQuery.setParameter(1, description);
			sqlQuery.setParameter(2, id);
			sqlQuery.executeUpdate();
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
	public OrderCheck getOrderCheck(Long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts=  session.beginTransaction();
			
			Query query = session.createQuery("from OrderCheck where orderId=?");
			query.setParameter(0, id);
			
			query.setMaxResults(1);
			OrderCheck q = (OrderCheck) query.uniqueResult();
			
			return q;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List getUnAckOrderList(Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("from VOrder v where (v.id.status = 1 or v.id.status =0) order by v.id.id desc");
			
			
			if (start == null) {
				start = 0;
			}
			query.setFirstResult(start);
			if (limit == null) {
				limit = 15;
				query.setMaxResults(limit);
			}else if(limit==-1){
				
			}else{
				query.setMaxResults(limit);
			}
			List<VOrder> li = query.list();
			
			List<VOrderId> list = new ArrayList<>();
			for(VOrder v:li){
				list.add(v.getId());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long getUnAckOrderCount() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("select count(v.id.id) from VOrder v where (v.id.status = 1 or v.id.status =0)");
			query.setMaxResults(1);
			long id= (Long) query.uniqueResult();
			
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	
}
