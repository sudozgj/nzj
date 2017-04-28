package org.dao;

import org.model.User;

public interface UserDao {
	public long addUser(Long phone,String password,Integer rank);
}
 