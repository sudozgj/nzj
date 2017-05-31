package org.dao;

import java.util.List;

import org.model.Orders;

public interface OrderDao {
	//-----------------------------------增---------------------------------------
	/**
	 * 1.1添加一份订单，同时初始化订单状态为未提交
	 * @param o
	 * @return
	 */
	public long addOrder(Orders o);
	//-----------------------------------删---------------------------------------
	/**
	 * 2.1删除订单
	 * @param id
	 * @return
	 */
	public boolean deleteOrder(long id);
	//-----------------------------------改---------------------------------------
	/**
	 * 3.1修改订单状态和描述
	 * @param id
	 * @param status
	 * @param description
	 * @return
	 */
	public boolean updateOrderStatus(long id,Integer status,String description);
	//-----------------------------------查---------------------------------------	
	/**
	 * 4.1获取当前用户的订单列表
	 * @param id
	 * @param start
	 * @param limit
	 * @return
	 */
	public List getOrderList(long id,Integer start,Integer limit);
	
	/**
	 * 4.2获取当前用户的订单总数
	 * @param id
	 * @return
	 */
	public long getOrderCount(long id);
	
	/**
	 * 4.3根据订单状态来获取列表
	 * @param status
	 * @param start
	 * @param limit
	 * @return
	 */
	public List getOrderListByStatus(long id,Integer status,Integer start,Integer limit);
	
	/**
	 * 4.4根据订单状态来获取总数
	 * @param status
	 * @return
	 */
	public long getOrderCountByStatus(Integer status);
}
