package org.controller;

import java.util.HashMap;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpSession;

import org.model.User;
import org.model.UserDetail;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.JsonObject;

@Controller
public class UserController {
	@Autowired
	private UserService uService;

	//-----------------------------------User-----------------------------------------
	@RequestMapping("/register")
	@ResponseBody
	public Object register(HttpSession session,User u,int code)throws Exception{
		System.out.println("	phone: "+u.getPhone());
		System.out.println("	password: "+u.getPassword());
		return uService.register(session,u,code);
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Object login(HttpSession session,Long phone,String password)throws Exception{
		System.out.println("	phone: "+phone);
		System.out.println("	password: "+password);
		return uService.login(session, phone, password);
	}
	
	@RequestMapping("/getSession")
	@ResponseBody
	public Object getSession(HttpSession session)throws Exception{
		return uService.getSession(session);
	}
	
	@RequestMapping("/getValidateCode")
	@ResponseBody
	public Object getValidateCode(HttpSession session,Long phone) throws Exception{
		return uService.getValidateCode(session, phone);
	}
	
	//-----------------------------------UserDetail-----------------------------------------
	@RequestMapping("/addUserDetail")
	@ResponseBody
	public Object addUserDetail(HttpSession session,UserDetail ud)throws Exception{
		return uService.addUserDetail(session, ud);
	}
	
	@RequestMapping("/updateUserDetail")
	@ResponseBody
	public Object updateUserDetail(UserDetail ud)throws Exception{
		return uService.updateUserDetail(ud);
	}
}
