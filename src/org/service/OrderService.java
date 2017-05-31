package org.service;

import javax.servlet.http.HttpSession;

import org.model.Orders;

public interface OrderService {
	/**
	 * 1添加订单，需要登录
	 * 
	 * @param o
	 * @return
	 */
	public Object addOrder(HttpSession session, Orders o);

	/**
	 * 2删除订单
	 * 
	 * @param id
	 * @return
	 */
	public Object deleteOrdder(Long id);

	/**
	 * 3提交订单，供管理员审核，修改订单状态为0
	 * 
	 * @param id
	 * @return
	 */
	public Object commitOrder(Long id, Integer status);

	/**
	 * 4获取当前用户的订单列表
	 * 
	 * @param session
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getOrderList(HttpSession session, Integer start, Integer limit);

	/**
	 * 5根据当前用户的状态获取订单列表		主要用于前端标签页筛选
	 * @param session
	 * @param status
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getOrderListByStatus(HttpSession session, Integer status,
			Integer start, Integer limit);
}
