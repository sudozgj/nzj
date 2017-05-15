package org.dao;

import java.util.List;

import org.model.ShareEmployer;

public interface ShareEmployerDao {
	// -----------------------------------增---------------------------------------
	/**
	 * 1.1添加共享客户信息
	 * 
	 * @param se
	 * @return
	 */
	public long addShareEmployer(ShareEmployer se);

	// -----------------------------------删---------------------------------------
	/**
	 * 2.1删除共享客户信息
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteShareEmployer(long id);

	// -----------------------------------改---------------------------------------
	/**
	 * 3.1修改共享客户信息
	 * 
	 * @param se
	 * @return
	 */
	public boolean updateShareEmployer(ShareEmployer se);

	/**
	 * 3.2修改共享状态，share为0表示取消共享，为1表示共享
	 * 
	 * @param id
	 * @param share
	 * @return
	 */
	public boolean setShareEmployer(long id, Integer share);

	// -----------------------------------查---------------------------------------
	/**
	 * 4.1根据共享字段查询客户信息，share为0表示取消共享的，share为1表示正在共享的
	 * 
	 * @param share
	 * @param start
	 * @param limit
	 * @param userId
	 * @return
	 */
	public List getShareEmployerList(Integer share, Integer start,
			Integer limit, Long userId);
	/**
	 * 4.2获取全部的已共享的客户列表
	 * @param share
	 * @param start
	 * @param limit
	 * @return
	 */
	public List getAllShareEmployerList(Integer share, Integer start,
			Integer limit);
}
