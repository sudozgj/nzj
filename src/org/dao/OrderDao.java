package org.dao;

import java.util.List;

import org.model.Order;
import org.model.OrderCheck;
import org.view.VOrderId;

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
	/**
	 * 3.1修改订单的状态（-1：为提交，0：未审核，1：审核不过，2：审核通过）
	 * @param id
	 * @param status
	 * @param description
	 * @return
	 */
	public boolean updateOrderStatus(long id,Integer status,String description);
	// -----------------------------------查---------------------------------------
	/**
	 * 4.1获取当前用户的订单列表
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<VOrderId> getOrderList(Long userId,Integer start,Integer limit);
	/**
	 * 4.2获取当前用户的订单总数
	 * @param userId
	 * @return
	 */
	public long getOrderCount(Long userId);
	/**
	 * 4.3通过订单id获取订单的审核状态
	 * @param id
	 * @return
	 */
	public OrderCheck getOrderCheck(Long id);
	/**
	 * 4.4获取未审核通过的订单
	 * @return
	 */
	public List getUnAckOrderList(Integer start,Integer limit);
	/**
	 * 4.5获取未通过审核的订单的总数
	 * @return
	 */
	public long getUnAckOrderCount();
}
