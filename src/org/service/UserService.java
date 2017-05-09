package org.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.model.User;
import org.model.UserDetail;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface UserService {
	/**
	 * 1注册
	 * 
	 * @param u
	 * @return
	 */
	public Object register(HttpSession session, User u, Integer code);

	/**
	 * 2登录
	 * 
	 * @param u
	 * @return
	 */
	public Object login(HttpSession session, Long phone, String password);

	/**
	 * 3获取session
	 * 
	 * @param session
	 * @return
	 */
	public Object getSession(HttpSession session);

	/**
	 * 4获取短信验证码
	 * 
	 * @param session
	 * @param phone
	 * @return
	 */
	public Object getValidateCode(HttpSession session, Long phone);

	/**
	 * 5完善用户详细信息
	 * 
	 * @param ud
	 * @return
	 */
	public Object addUserDetail(HttpServletRequest request,UserDetail ud,
			@RequestParam("file1") CommonsMultipartFile file1,
			@RequestParam("file2") CommonsMultipartFile file2)
			throws IllegalStateException, IOException;

	/**
	 * 6修改用户详细信息
	 * 
	 * @param ud
	 * @return
	 */
	public Object updateUserDetail(UserDetail ud);

	/**
	 * 7获取当前用户信息
	 * 
	 * @param session
	 * @return
	 */
	public Object getUser(HttpSession session);

	/**
	 * 8修改用户密码
	 * 
	 * @return
	 */
	public Object updateUserPassword(HttpSession session, String oPwd,
			String nPwd);

	/**
	 * 9审核确认，修改ack 0为1，修改rank 0为rank，并将父节点的id传过来
	 * 
	 * @return
	 */
	public Object ackUser(Long id, Integer rank, Long pid);
	
	public Object getUnAckUserList(Integer start, Integer limit);
}
