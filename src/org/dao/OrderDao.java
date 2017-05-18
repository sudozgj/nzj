package org.dao;

import java.util.List;

import org.model.Order;

public interface OrderDao {
	// -----------------------------------增---------------------------------------
//	public boolean addOrder(Order o,final OrderTraineeForm ot);
	/**
	 * 1.1添加一个订单
	 * @param o
	 * @return
	 */
	public long addOrder(Order o);
	// -----------------------------------删---------------------------------------
	/**
	 * 2.1删除订单,以及订单下所有学员信息
	 * @param id
	 * @return
	 */
	public boolean deleteOrder(long id);
	// -----------------------------------改---------------------------------------
	// -----------------------------------查---------------------------------------
	/**
	 * 4.1获取当前用户的订单列表
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Order> getOrderList(Long userId,Integer start,Integer limit);
	/**
	 * 4.2获取当前用户的订单总数
	 * @param userId
	 * @return
	 */
	public long getOrderCount(Long userId);
}
