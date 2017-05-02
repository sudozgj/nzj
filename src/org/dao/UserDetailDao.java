package org.dao;

import org.model.UserDetail;

public interface UserDetailDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加用户详细信息，userid（用户id）,...，charterurl（可选），idcardurl（可选）
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
}
