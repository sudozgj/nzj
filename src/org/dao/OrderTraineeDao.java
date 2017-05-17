package org.dao;

import java.util.List;

import org.model.OrderTrainee;

public interface OrderTraineeDao {
	// -----------------------------------增---------------------------------------
	/**
	 *  1.1添加一个学员
	 * @param oid
	 * @param ot
	 * @return
	 */
	public long addOrderTrainee(OrderTrainee ot);
	// -----------------------------------删---------------------------------------
	// -----------------------------------改---------------------------------------
	// -----------------------------------查---------------------------------------
	/**
	 * 4.1根据订单id获取学员列表
	 * @param orderId
	 * @return
	 */
	public List<OrderTrainee> getOrderTraineeList(Long orderId,Integer start, Integer limit);
	/**
	 * 4.2查询该订单的学员总数
	 * @return
	 */
	public long getOrderTraineeCount(Long orderId);
}
