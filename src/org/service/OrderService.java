package org.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.OrderTraineeForm;
import org.model.Order;
import org.model.OrderAccount;
import org.model.OrderTrainee;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface OrderService {
	/**
	 * 1添加订单
	 * 
	 * @param o
	 * @param ot
	 * @return
	 */
	public Object addOrder(HttpSession session, Order o);

	/**
	 * 2为某订单添加学员
	 * 
	 * @param oid
	 * @param ot
	 * @return
	 */
	public Object addOrderTrainee(HttpServletRequest request,
			OrderTrainee ot, @RequestParam("file1") CommonsMultipartFile file1,
			@RequestParam("file2") CommonsMultipartFile file2,
			@RequestParam("file3") CommonsMultipartFile file3,
			@RequestParam("file4") CommonsMultipartFile file4)
			throws IllegalStateException, IOException;
	
	/**
	 * 3获取当前用户的订单
	 * @param session
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getOrderList(HttpSession session,Integer start,Integer limit);
	
	/**
	 * 4删除订单
	 * @param id
	 * @return
	 */
	public Object deleteOrder(Long id);
	
	/**
	 * 5根据订单号获取订单学员
	 * @param orderId
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getOrderTraineeList(Long orderId,Integer start, Integer limit);
	
	/**
	 * 6获取订单状态
	 * @param id
	 * @return
	 */
	public Object getOrderStatus(Long id);
	
	/**
	 * 7提交订单状态
	 * @return
	 */
	public Object commitOrder(Long id,Integer status);
	
	/**
	 * 8获取未通过审核的订单列表
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getUnAckOrderList(Integer start,Integer limit);
	
	/**
	 * 9订单审核通过
	 * @param orderId
	 * @param status
	 * @param description
	 * @return
	 */
	public Object checkOrder(Long orderId,Integer status,String description);
	
	/**
	 * 10订单审核不通过
	 * @param orderId
	 * @param status
	 * @param description
	 * @return
	 */
	public Object unCheckOrder(Long orderId,Integer status,String description);
	
	/**
	 * 11添加订单账目信息
	 * @param prepare
	 * @param quantity
	 * @return
	 */
	public Object addOrderAccount(OrderAccount oa);
	
	/**
	 * 12获取订单的学员数
	 * @param orderId
	 * @return
	 */
	public Object getOrderTraineeCount(Long orderId);
}
