package org.dao.imp;

import java.util.List;

import org.dao.EmployerDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Employer;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class EmployerDaoImp implements EmployerDao {

	@Override
	// 正常就返回id号，否则返回-1
	public long addEmployer(Employer e) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			long id = (Long) session.save(e);
			ts.commit();
			return id;
		} catch (Exception e1) {
			e1.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean deleteEmployer(Long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session
					.createQuery("DELETE FROM Employer e WHERE id = ?");
			query.setParameter(0, id);
			Integer i = query.executeUpdate();
			ts.commit();
//			System.out.println("删除了" + i + "行");
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateEmployer(Employer e) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session
					.createQuery("UPDATE Employer e SET e.time = ?, e.name = ?, e.phone = ?, e.adress = ?, e.content = ? WHERE id = ?");
			query.setParameter(0, e.getTime());
			query.setParameter(1, e.getName());
			query.setParameter(2, e.getPhone());
			query.setParameter(3, e.getAdress());
			query.setParameter(4, e.getContent());
			query.setParameter(5, e.getId());
			Integer i = query.executeUpdate();
//			System.out.println(i);
			ts.commit();
			return true;
		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Employer getEmployer(Long userId, String name, String phone) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session
					.createQuery("FROM Employer e WHERE e.userId = ? AND e.name = ? AND e.phone = ?");
			query.setParameter(0, userId);
			query.setParameter(1, name);
			query.setParameter(2, phone);
			query.setMaxResults(1); // 一开始就避免了重复所以即使有返回也只有一条。
			Employer e = (Employer) query.uniqueResult();
			return e; // 当数据库无此项记录时，返回的是null
		} catch (Exception e1) {
			e1.printStackTrace();
			return new Employer(); // 如果这里也写返回null，当网络异常等问题出现时也会返回null，业务逻辑中返回null才是可继续操作的标准，
									// 这种情况时，会使本来不可继续操作的情况，变成可以操作。
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public Employer getEmployerById(Long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("FROM Employer WHERE id = ?");
			query.setParameter(0, id);
			query.setMaxResults(1);
			Employer e = (Employer) query.uniqueResult();
			return e;
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public long getEmployerCountById(Long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("SELECT COUNT(*) FROM Employer WHERE userId = ?");
			query.setParameter(0, id);
			query.setMaxResults(1);
			long pageCount = (long) query.uniqueResult();
			return pageCount;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public List<Employer> getEmployerList(Integer start, Integer limit,Long userId) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from Employer where userId=? order by id desc");
			query.setParameter(0, userId);
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
			
			List<Employer> li = query.list();

			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
}
