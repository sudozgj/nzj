package org.dao;

import java.util.List;

import org.model.Job;

public interface JobDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加岗位
	 * @param l
	 * @return
	 */
	public long addJob(Job l);
	//-----------------------------------删---------------------------------------
	/**
	 * 2.1删除岗位
	 * @param id
	 * @return
	 */
	public boolean deleteJob(long id);
	//-----------------------------------改---------------------------------------
	/**
	 * 3.1修改岗位
	 * @param l
	 * @return
	 */
	public boolean updateJob(Job l);
	//-----------------------------------查---------------------------------------
	/**
	 * 4.1查询岗位
	 * @return
	 */
	public List getJobList();
}
