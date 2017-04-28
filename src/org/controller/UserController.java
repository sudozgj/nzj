package org.controller;

import java.util.HashMap;
import java.util.Map;

import org.model.User;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
	private UserService uService;

	@RequestMapping("/test")
	@ResponseBody
	public Object test()throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "as");
		map.put("b", 3);
		return map;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public Object register(User u)throws Exception{
		return uService.register(u);
	}
	
//	@RequestMapping("/register")
//	@ResponseBody
//	public Object register(User u) throws Exception {
//		UserDao uDao = new UserDaoImp();
//		User user = new User();
//		user.setUsername(u.getUsername());
//		user.setPassword(u.getPassword());
//		user.setAck(false);
//		long uid = uDao.addUser(user);
//		if (uid != -1) {
//			return JsonObject.getResult(1, "添加用户成功", true);
//		} else {
//			return JsonObject.getResult(0, "添加用户失败", false);
//		}
//	}
//
//	@RequestMapping("/login")
//	@ResponseBody
//	public Object login(User u, HttpSession session) throws Exception {
//		UserDao uDao = new UserDaoImp();
//		User user = uDao.getUser(u.getUsername(), u.getPassword());
//		if (user != null) {
//			session.setAttribute("user", user);
//			return JsonObject.getResult(1, "登录成功", true);
//		} else {
//			return JsonObject.getResult(0, "用户名或密码错误", false);
//		}
//	}
}
