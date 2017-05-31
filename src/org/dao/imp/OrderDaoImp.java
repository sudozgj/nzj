package org.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dao.OrderDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.OrderCheck;
import org.model.Orders;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;
import org.view.VOrderCheck;
import org.view.VOrderCheckId;

@Service
public class OrderDaoImp implements OrderDao {

	@Override
	public long addOrder(Orders o) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			long id = (Long) session.save(o);

			OrderCheck oc = new OrderCheck(-1, "未提交", id);
			session.save(oc);

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
	public boolean deleteOrder(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Orders o = (Orders) session.load(Orders.class, id);
			session.delete(o);

			// 删除订单的同时，删除订单的状态表
			SQLQuery sqlQuery = session
					.createSQLQuery("delete from order_check where order_id=?");
			sqlQuery.setParameter(0, id);
			sqlQuery.executeUpdate();

			// 删除订单的同时，删除订单的学员绑定表
			SQLQuery sqlQuery2 = session
					.createSQLQuery("delete from order_trainee where order_id=?");
			sqlQuery2.setParameter(0, id);
			sqlQuery2.executeUpdate();

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
	public boolean updateOrderStatus(long id, Integer status, String description) {
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
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List getOrderList(long id, Integer start, Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("from VOrderCheck v where v.id.userId=?");
			query.setParameter(0, id);
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
			List<VOrderCheck> li = query.list();
			List<VOrderCheckId> list = new ArrayList<>();
			for (VOrderCheck v : li) {
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
	public long getOrderCount(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session
					.createQuery("select count(v.id.id) from VOrderCheck v where v.id.userId=?");
			query.setParameter(0, id);
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
	public List getOrderListByStatus(long id,Integer status, Integer start,
			Integer limit) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts= session.beginTransaction();
			
			Query query = session.createQuery("from VOrderCheck v where v.id.userId=? and v.id.status=?");
			query.setParameter(0, id);
			query.setParameter(1, status);
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
			List<VOrderCheck> li = query.list();
			List<VOrderCheckId> list = new ArrayList<>();
			for (VOrderCheck v : li) {
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
	public long getOrderCountByStatus(Integer status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
