package org.dao;

import java.util.List;

import org.model.Employer;

public interface EmployerDao {
	//-----------------------------------增--------------------------------------
	/**
	 * 1.1添加客户--Integer time,String name,String phone,String adress,String content
	 * @param e
	 * @return
	 */
	public long addEmployer (Employer e);
	//-----------------------------------删--------------------------------------
	/**
	 * 2.1删除客户
	 * @param id
	 * @return
	 */
	public boolean deleteEmployer (Long id);
	//-----------------------------------改--------------------------------------
	/**
	 * 3.1修改客户信息
	 * @param id
	 * @return
	 */
	public boolean updateEmployer (Employer e);
	//-----------------------------------查--------------------------------------
	/**
	 * 4.1通过name&phone查找用户--防止用户录入重复
	 * @param name
	 * @param phone
	 * @return
	 */
	public Employer getEmployer (Long userid, String name, String phone);
	/**
	 * 4.2通过id查找用户
	 * @param id
	 * @return
	 */
	public Employer getEmployerById (Long id);
	/**
	 * 4.3查询共有多少条记录
	 * @return
	 */
	public long getEmployerCountById (Long id);
	/**
	 * 4.4分页查询客户信息
	 * @param page
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Employer> getEmployerList (Integer start, Integer limit,Long userId);
}
