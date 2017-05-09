package org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.model.User;
import org.model.UserDetail;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UserController {
	@Autowired
	private UserService uService;

	// -----------------------------------User-----------------------------------------
	@RequestMapping("/register")
	@ResponseBody
	public Object register(HttpSession session, User u, int code)
			throws Exception {
		System.out.println("	phone: " + u.getPhone());
		System.out.println("	password: " + u.getPassword());
		return uService.register(session, u, code);
	}

	@RequestMapping("/login")
	@ResponseBody
	public Object login(HttpSession session, Long phone, String password)
			throws Exception {
		System.out.println("	phone: " + phone);
		System.out.println("	password: " + password);
		return uService.login(session, phone, password);
	}

	@RequestMapping("/getSession")
	@ResponseBody
	public Object getSession(HttpSession session) throws Exception {
		return uService.getSession(session);
	}

	@RequestMapping("/getValidateCode")
	@ResponseBody
	public Object getValidateCode(HttpSession session, Long phone)
			throws Exception {
		return uService.getValidateCode(session, phone);
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public Object getUser(HttpSession session) throws Exception {
		return uService.getUser(session);
	}

	@RequestMapping("/updateUserPassword")
	@ResponseBody
	public Object updateUserPassword(HttpSession session, String oPwd,
			String nPwd) throws Exception {
		return uService.updateUserPassword(session, oPwd, nPwd);
	}

	@RequestMapping("/ackUser")
	@ResponseBody
	public Object ackUser(Long id, Integer rank, Long pid) throws Exception {
		return uService.ackUser(id, rank, pid);
	}

	// -----------------------------------UserDetail-----------------------------------------
	@RequestMapping("/addUserDetail")
	@ResponseBody
	public Object addUserDetail(HttpServletRequest request,UserDetail ud,
			@RequestParam("file1") CommonsMultipartFile file1,
			@RequestParam("file2") CommonsMultipartFile file2)
			throws Exception {
		return uService.addUserDetail(request,ud,file1,file2);
	}

	@RequestMapping("/updateUserDetail")
	@ResponseBody
	public Object updateUserDetail(UserDetail ud) throws Exception {
		return uService.updateUserDetail(ud);
	}
	
	@RequestMapping("/getUnAckUserList")
	@ResponseBody
	public Object getUnAckUserList(Integer start, Integer limit)throws Exception{
		return uService.getUnAckUserList(start, limit);
	}
}
