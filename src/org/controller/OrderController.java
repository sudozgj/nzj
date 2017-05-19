package org.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.model.Order;
import org.model.OrderAccount;
import org.model.OrderTrainee;
import org.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class OrderController {
	@Autowired
	private OrderService oService;

	@RequestMapping("/addOrder")
	@ResponseBody
	public Object addOrder(HttpSession session, Order o) throws Exception {
		return oService.addOrder(session, o);
	}

	@RequestMapping("/addOrderTrainee")
	@ResponseBody
	public Object addOrderTrainee(HttpServletRequest request, OrderTrainee ot,
			@RequestParam("file1") CommonsMultipartFile file1, // 身份证正
			@RequestParam("file2") CommonsMultipartFile file2, // 身份证反
			@RequestParam("file3") CommonsMultipartFile file3, // 照片
			@RequestParam("file4") CommonsMultipartFile file4) // 学员信息
			throws IllegalStateException, IOException {
		return oService
				.addOrderTrainee(request, ot, file1, file2, file3, file4);
	}

	@RequestMapping("/getOrderList")
	@ResponseBody
	public Object getOrderList(HttpSession session, Integer start, Integer limit)
			throws Exception {
		return oService.getOrderList(session, start, limit);
	}

	@RequestMapping("/deleteOrder")
	@ResponseBody
	public Object deleteOrder(Long id) throws Exception {
		return oService.deleteOrder(id);
	}

	@RequestMapping("/getOrderTraineeList")
	@ResponseBody
	public Object getOrderTraineeList(Long orderId, Integer start, Integer limit)
			throws Exception {
		return oService.getOrderTraineeList(orderId, start, limit);
	}

	@RequestMapping("/getOrderStatus")
	@ResponseBody
	public Object getOrderStatus(Long id) throws Exception {
		return oService.getOrderStatus(id);
	}

	@RequestMapping("/commitOrder")
	// 提交订单，供管理员审核，修改订单状态为0
	@ResponseBody
	Object updateOrderStatus(Long id) throws Exception {
		return oService.commitOrder(id, 0);
	}

	@RequestMapping("/getUnAckOrderList")
	@ResponseBody
	public Object getUnAckOrderList(Integer start, Integer limit)
			throws Exception {
		return oService.getUnAckOrderList(start, limit);
	}

	@RequestMapping("/checkOrder")		//审核通过
	@ResponseBody
	public Object checkOrder(Long orderId, Integer status,
			String description) throws Exception {
		return oService.checkOrder(orderId, 2, "审核通过");
	}
	
	@RequestMapping("/unCheckOrder")	//审核不通过
	@ResponseBody
	public Object unCheckOrder(Long orderId, Integer status,
			String description) throws Exception {
		return oService.unCheckOrder(orderId, 1, description);
	}
	
	@RequestMapping("/getOrderTraineeCount")	//获取订单学员总数
	@ResponseBody
	public Object getOrderTraineeCount(Long orderId)throws Exception{
		return oService.getOrderTraineeCount(orderId);
	}
	
	@RequestMapping("/addOrderAccount")
	@ResponseBody
	public Object addOrderAccount(OrderAccount oa,Double price)throws Exception{
		System.out.println(oa.getId());
		System.out.println(oa.getPrepare());
		System.out.println(oa.getQuantity());
		System.out.println(price);
		return null;
	}
	
}
