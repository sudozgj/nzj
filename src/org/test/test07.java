package org.test;

import org.dao.UserDao;
import org.dao.imp.UserDaoImp;

public class test07 {
	public static void main(String[] args) {
		UserDao uDao = new UserDaoImp();
		
		uDao.updateUser(6L, 2, 1);
	}
}