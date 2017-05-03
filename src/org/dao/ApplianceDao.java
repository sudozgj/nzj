package org.dao;

import java.util.List;

import org.model.Appliance;

public interface ApplianceDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加家用电器
	 * @param l
	 * @return
	 */
	public long addAppliance(Appliance l);
	//-----------------------------------删---------------------------------------
	/**
	 * 2.1删除家用电器
	 * @param id
	 * @return
	 */
	public boolean deleteAppliance(long id);
	//-----------------------------------改---------------------------------------
	/**
	 * 3.1修改家用电器
	 * @param l
	 * @return
	 */
	public boolean updateAppliance(Appliance l);
	//-----------------------------------查---------------------------------------
	/**
	 * 4.1查询家用电器
	 * @return
	 */
	public List getApplianceList();
}
