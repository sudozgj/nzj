package org.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.OrderTraineeForm;
import org.dao.OrderAccountDao;
import org.dao.OrderDao;
import org.dao.OrderTraineeDao;
import org.model.Order;
import org.model.OrderAccount;
import org.model.OrderCheck;
import org.model.OrderTrainee;
import org.model.User;
import org.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tool.JsonObject;
import org.tool.readProperties;

@Service
public class OrderServiceImp implements OrderService {
	@Autowired
	private OrderDao oDao;
	@Autowired
	private OrderTraineeDao otDao;
	@Autowired
	private OrderAccountDao oaDao;

	@Override
	public Object addOrder(HttpSession session, Order o) {

		User u = (User) session.getAttribute("user");
		if (u != null) {
			long id = u.getId();
			o.setUserId(id);
			o.setTime(new Date().getTime()/1000);
			long oid = oDao.addOrder(o);
			if (oid != -1) {
				return JsonObject.getResult(1, "添加订单成功", oid);
			} else {
				return JsonObject.getResult(0, "添加订单失败", false);
			}
		} else {
			return JsonObject.getResult(-999, "请先登录，才能添加订单", false);
		}
	}

	@Override
	public Object addOrderTrainee(HttpServletRequest request,
			OrderTrainee ot, @RequestParam("file1") CommonsMultipartFile file1,
			@RequestParam("file2") CommonsMultipartFile file2,
			@RequestParam("file3") CommonsMultipartFile file3,
			@RequestParam("file4") CommonsMultipartFile file4)
			throws IllegalStateException, IOException {

		String f1Name = file1.getOriginalFilename();
		String f2Name = file2.getOriginalFilename();
		String f3Name = file3.getOriginalFilename();
		String f4Name = file4.getOriginalFilename();

		if (f1Name.equals("") || f2Name.equals("") || f3Name.equals("")
				|| f4Name.equals("")) {
			return JsonObject.getResult(0, "上传的不能有空", false);
		}

		f1Name = new Date().getTime() / 1000 + "_" + new Random().nextInt(10)
				+ f1Name.substring(f1Name.indexOf("."));

		f2Name = new Date().getTime() / 1000 + "_" + new Random().nextInt(10)
				+ f2Name.substring(f2Name.indexOf("."));

		f3Name = new Date().getTime() / 1000 + "_" + new Random().nextInt(10)
				+ f3Name.substring(f3Name.indexOf("."));

		f4Name = new Date().getTime() / 1000 + "_" + new Random().nextInt(10)
				+ f4Name.substring(f4Name.indexOf("."));

		String rPath = request.getSession().getServletContext()
				.getRealPath("/"); // 项目根目录 ...\nzj\
		String upDir = "upload" + File.separator + "order_trainee"; // 文件夹名
		String path = rPath + upDir; // 图片保存的完整目录

		File dir = new File(path);
		if (!dir.exists() && !dir.isDirectory()) {
			dir.mkdirs();
		}

		String fPath1 = path + File.separator + f1Name; // 文件最终路径
		String fPath2 = path + File.separator + f2Name; // 文件最终路径
		String fPath3 = path + File.separator + f3Name; // 文件最终路径
		String fPath4 = path + File.separator + f4Name; // 文件最终路径
		
		
		String url1 = new readProperties().getP("server")
				+ "upload/order_trainee/" + f1Name; // 保存url
		String url2 = new readProperties().getP("server")
				+ "upload/order_trainee/" + f2Name; // 保存url
		String url3 = new readProperties().getP("server")
				+ "upload/order_trainee/" + f3Name; // 保存url
		String url4 = new readProperties().getP("server")
				+ "upload/order_trainee/" + f4Name; // 保存url

		File f1 = new File(fPath1);
		file1.transferTo(f1);

		File f2 = new File(fPath2);
		file2.transferTo(f2);
		
		File f3 = new File(fPath3);
		file3.transferTo(f3);
		
		File f4= new File(fPath4);
		file4.transferTo(f4);
		
		ot.setIdcardurl1(url1);
		ot.setIdcardurl2(url2);
		ot.setPhotourl(url3);
		ot.setInfourl(url4);
		
		if(otDao.addOrderTrainee(ot)!=-1)
			return JsonObject.getResult(1, "添加学员成功", true);
		else
			return JsonObject.getResult(0, "添加学员失败", false);
	}

	@Override
	public Object getOrderList(HttpSession session, Integer start, Integer limit) {
		User u =(User) session.getAttribute("user");
		if(u!=null){
			long count = oDao.getOrderCount(u.getId());
			List li = oDao.getOrderList(u.getId(), start, limit);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("count", count);
			map.put("result", li);
			
			return JsonObject.getResult(1, "获取订单列表", map);
		}else{
			return JsonObject.getResult(-999, "请先登录，才能查询订单列表", false);
		}
	}

	@Override
	public Object deleteOrder(Long id) {
		if(oDao.deleteOrder(id))
			return JsonObject.getResult(1, "删除订单成功", true);
		else
			return JsonObject.getResult(0, "删除订单失败", false);
	}

	@Override
	public Object getOrderTraineeList(Long orderId, Integer start, Integer limit) {
		long count = otDao.getOrderTraineeCount(orderId);
		List li = otDao.getOrderTraineeList(orderId, start, limit);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("result", li);
		
		return JsonObject.getResult(1, "获取订单列表", map);
	}

	@Override
	public Object getOrderStatus(Long id) {
		OrderCheck oc = oDao.getOrderCheck(id);
		return JsonObject.getResult(1, "获取订单状态", oc);
	}

	@Override
	public Object commitOrder(Long id, Integer status) {
		if(oDao.updateOrderStatus(id, status,"--"))
			return JsonObject.getResult(1, "提交订单成功", true);
		else
			return JsonObject.getResult(0, "提交订单失败", false);
	}

	@Override
	public Object getUnAckOrderList(Integer start, Integer limit) {
		List li = oDao.getUnAckOrderList(start, limit);
		long count = oDao.getUnAckOrderCount();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", li);
		map.put("count", count);
		
		return JsonObject.getResult(1, "获取未通过审核的订单列表", map);
	}

	@Override
	public Object checkOrder(Long orderId, Integer status, String description) {
		if(oDao.updateOrderStatus(orderId, status, description))
			return JsonObject.getResult(1, "审核订单通过成功", true);
		else
			return JsonObject.getResult(0, "审核订单通过失败", false);
	}

	@Override
	public Object unCheckOrder(Long orderId, Integer status, String description) {
		if(oDao.updateOrderStatus(orderId, status, description))
			return JsonObject.getResult(1, "审核订单不通过成功", true);
		else
			return JsonObject.getResult(0, "审核订单不通过失败", false);
	}

	@Override
	public Object addOrderAccount(OrderAccount oa) {
		if(oaDao.addOrderAccount(oa)!=-1)
			return JsonObject.getResult(1, "添加订单账目信息表成功", true);
		else
			return JsonObject.getResult(0, "添加订单账目信息表失败", false);
	}

	@Override
	public Object getOrderTraineeCount(Long orderId) {
		long count = otDao.getOrderTraineeCount(orderId);
		if(count!=-1){
			return JsonObject.getResult(1, "获取订单学员总数", count);
		}else{
			return JsonObject.getResult(0, "获取订单学员总数错误", false);
		}
	}
	
}
