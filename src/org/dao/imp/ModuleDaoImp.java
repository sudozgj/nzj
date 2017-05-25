package org.dao.imp;

import java.util.List;

import org.dao.ModuleDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateSessionFactory;

public class ModuleDaoImp implements ModuleDao{

	@Override
	public List getModuleList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from Module order by id");
			List li = query.list();
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
