package org.dao;

import org.model.UserDetail;

public interface UserDetailDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加用户详细信息，userId（用户id）,...，charterurl（可选），idcardurl（可选）
	 * @param ud
	 * @return
	 */
	public long addUserDetail(UserDetail ud);
	//-----------------------------------删-----------------------------------------
	
	//-----------------------------------改-----------------------------------------
	/**
	 * 3.1修改用户详细信息，不允许修改username
	 * @param ud
	 * @return
	 */
	public boolean updateUserDetail(UserDetail ud);
	//-----------------------------------查-----------------------------------------
	/**
	 * 4.1验证用户名是否已用，null为可用，通过username获取 UserDetail
	 * @param username
	 * @return
	 */
	public UserDetail getUserDetail(String username);
	/**
	 * 4.2查看该用户（通过用户id）是否完善过用户信息,true表示完善过用户信息
	 * @param userId
	 * @return
	 */
	public boolean getUserDetail(Long userId);
	/**
	 * 4.3通过用户id查询用户详细信息
	 * @param userId
	 * @return
	 */
	public UserDetail getUserDetailById(Long userId);
}
