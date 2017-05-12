package org.dao.imp;

import java.util.List;

import org.dao.BoardDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Board;
import org.springframework.stereotype.Service;
import org.util.HibernateSessionFactory;

@Service
public class BoardDaoImp implements BoardDao{

	@Override
	public long addBoard(Board b) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			long id= (Long) session.save(b);
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
	public boolean deleteBoard(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBoard(Board b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

}
