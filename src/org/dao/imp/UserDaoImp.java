package org.dao.imp;

import java.util.Date;

import org.dao.UserDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

import org.model.User;

@Service
public class UserDaoImp implements UserDao{

	@Override
	public long addUser(Long phone, String password,Integer rank) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			User user = new User(phone,password,new Date().getTime()/1000,rank,0);
			long id = (Long) session.save(user);
			ts.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
