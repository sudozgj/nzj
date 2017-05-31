package org.controller;

import javax.servlet.http.HttpSession;

import org.model.Orders;
import org.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
	@Autowired
	private OrderService oService;

	@RequestMapping("/addOrder")
	@ResponseBody
	public Object addOrder(HttpSession session, Orders o) throws Exception {
		return oService.addOrder(session, o);
	}

	@RequestMapping("/deleteOrder")
	@ResponseBody
	public Object deleteOrder(Long id) throws Exception {
		return oService.deleteOrdder(id);
	}

	@RequestMapping("/commitOrder")		// 提交订单，供管理员审核，修改订单状态为0
	@ResponseBody
	public Object commitOrder(Long id, Integer status) throws Exception {
		return oService.commitOrder(id, 0);
	}

	@RequestMapping("/getOrderList")	//获取当前用户的订单列表
	@ResponseBody
	public Object getOrderList(HttpSession session, Integer start, Integer limit)
			throws Exception {
		return oService.getOrderList(session, start, limit);
	}

}
