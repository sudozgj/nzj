package org.dao.imp;

import java.util.List;

import org.dao.ApplianceDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Appliance;
import org.model.Language;
import org.util.HibernateSessionFactory;

public class ApplianceDaoImp implements ApplianceDao{

	@Override
	public long addAppliance(Appliance l) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			long id = (Long) session.save(l);
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
	public boolean deleteAppliance(long id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts=  session.beginTransaction();
			Appliance l = (Appliance) session.load(Appliance.class, id);
			session.delete(l);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

	@Override
	public boolean updateAppliance(Appliance l) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			session.update(l);
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
	public List getApplianceList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Query query = session.createQuery("from Appliance order by id");
			List l = (List) query.list();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			return null;			//注意，这里应该返回对象，因为phone能用，返回的是null
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
