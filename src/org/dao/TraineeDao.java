package org.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.model.Trainee;

public interface TraineeDao {
	// -----------------------------------增---------------------------------------
	/**
	 * 1.1添加学员
	 * 
	 * @param o
	 * @return
	 */
	public long addTrainee(Trainee o);

	// -----------------------------------删---------------------------------------
	public boolean deleteTrainee(long id);

	// -----------------------------------改---------------------------------------
	// -----------------------------------查---------------------------------------
	/**
	 * 4.1根据订单id获取学员列表
	 * @param orderId
	 * @param start
	 * @param limit
	 * @return
	 */
	public List getTraineeListByOrderId(Long orderId, Integer start,
			Integer limit);
	/**
	 * 4.2查询某订单的学员总数
	 * @param orderId
	 * @return
	 */
	public long getTraineeCountByOrderId(Long orderId);

	/**
	 * 4.3获取用户的未绑定订单的学员列表,用于绑定
	 * @param session
	 * @return
	 */
	public List getUnBindTraineeList(Long uid, Integer start,
			Integer limit);
	/**
	 * 4.4获取某用户的未绑定订单的学员总数
	 * @param uid
	 * @return
	 */
	public long getUnBindTraineeCount(Long uid);
	
	/**
	 * 4.5获取某用户的学员列表
	 * @param userId
	 * @param start
	 * @param limit
	 * @return
	 */
	public List getTraineeListByUserId(Long userId,Integer start,Integer limit);
	
	/**
	 * 4.6获取某用户的学员总数
	 * @param userId
	 * @return
	 */
	public long getTraineeCount(Long userId);
}
