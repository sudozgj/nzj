package org.dao;

import java.util.List;

import org.model.Staff;

public interface StaffDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加员工
	 * @param o
	 * @return
	 */
	public long addStaff(Staff o,Long[] mid);
	//-----------------------------------删---------------------------------------
	/**
	 * 2.1删除员工
	 * @param id
	 * @return
	 */
	public boolean deleteStaff(long id);
	//-----------------------------------改---------------------------------------
	/**
	 * 3.1修改员工
	 * @param s
	 * @return
	 */
	public boolean updateStaff(Staff s);
	//-----------------------------------查---------------------------------------	
	/**
	 * 4.1查看登录电话是否可用
	 * @param phone
	 * @return
	 */
	public Staff getStaff(Long phone);
	/**
	 * 4.2获取该用户的员工列表
	 * @param id
	 * @param start
	 * @param limit
	 * @return
	 */
	public List getStaffList(Long id,Integer start,Integer limit);
	/**
	 * 4.3获取该用户的员工总数
	 * @param id
	 * @return
	 */
	public long getStaffCount(Long id);
	/**
	 * 4.4
	 * @param phone
	 * @param password
	 * @return
	 */
	public Staff getStaff(Long phone,String password);
}
