package org.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.OrderTraineeForm;
import org.model.Order;
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
	
}
