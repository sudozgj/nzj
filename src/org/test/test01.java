package org.test;

import org.dao.UserDao;
import org.dao.imp.UserDaoImp;

public class test01 {
	public static void main(String[] args) {
		UserDao uDao = new UserDaoImp();
		uDao.addUser(123L, "1234", 0);
	}
}
