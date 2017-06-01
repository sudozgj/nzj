package org.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dao.OrderDao;
import org.model.Orders;
import org.model.User;
import org.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.JsonObject;

@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	private OrderDao oDao;
	
	@Override
	public Object addOrder(HttpSession session,Orders o) {
		User u = (User)session.getAttribute("user");
		if(u!=null){
			o.setTime(new Date().getTime()/1000);
			o.setUserId(u.getId());
			if(oDao.addOrder(o)!=-1)
				return JsonObject.getResult(1, "添加订单成功", true);
			else
				return JsonObject.getResult(-1, "添加订单失败", false);
		}else{
			return JsonObject.getResult(0, "请先登录，才能添加订单", false);
		}
	}

	@Override
	public Object deleteOrdder(Long id) {
		if(oDao.deleteOrder(id))
			return JsonObject.getResult(1, "删除订单成功", true);
		else
			return JsonObject.getResult(0, "删除订单失败", false);
	}
	
	@Override
	public Object commitOrder(Long id,Integer status) {
		if(oDao.updateOrderStatus(id, status,"等待审核"))
			return JsonObject.getResult(1, "提交订单成功", true);
		else
			return JsonObject.getResult(0, "提交订单失败", false);
	}
	
	@Override
	public Object getOrderList(HttpSession session, Integer start, Integer limit) {
		User u = (User) session.getAttribute("user");
		if(u==null)
			return JsonObject.getResult(0, "请先登录，才能获取订单列表", false);
		else{
			List li = oDao.getOrderList(u.getId(), start, limit);
			long count = oDao.getOrderCount(u.getId());

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("count", count);
			map.put("result", li);
			return JsonObject.getResult(1, "获取当前用户订单列表", map);
		}
	}

	@Override
	public Object getOrderListByStatus(HttpSession session, Integer status,
			Integer start, Integer limit) {
		User u = (User) session.getAttribute("user");
		if(u==null)
			return JsonObject.getResult(0, "请先登录，才能通过状态获取订单列表", false);
		else{
			List li = oDao.getOrderListByStatus(u.getId(), status, start, limit);
			long count = oDao.getOrderCountByStatus(u.getId(), status);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("count", count);
			map.put("result", li);
			return JsonObject.getResult(1, "获取当前用户订单列表", map);
		}
	}

}
