package org.dao;

import org.model.User;

public interface UserDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1注册，添加用户--Long phone,String password,Integer rank
	 * @param u
	 * @return
	 */
	public long addUser(User u);
	//-----------------------------------删-----------------------------------------
	/**
	 * 2.1删除用户，管理员才能
	 * @param id
	 * @return
	 */
	public boolean deleteUser(Long id);
	//-----------------------------------改-----------------------------------------
	/**
	 * 3.1修改用户信息
	 * @param u
	 * @return
	 */
	public boolean updateUser(User u);
	//-----------------------------------查-----------------------------------------
	/**
	 * 4.1验证电话是否已用，null表示可用，非空表示已用
	 * @param phone
	 * @return
	 */
	public User getUser(Long phone);
	/**
	 * 4.2登录
	 * @param phone
	 * @param password
	 * @return
	 */
	public User getUser(Long phone,String password);
	/**
	 * 4.3通过id获取用户
	 * @param id
	 * @return
	 */
	public User getUserById(Long id);
}
