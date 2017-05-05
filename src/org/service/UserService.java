package org.service;

import javax.servlet.http.HttpSession;

import org.model.User;
import org.model.UserDetail;


public interface UserService {
	/**
	 * 1注册
	 * @param u
	 * @return
	 */
	public Object register(HttpSession session,User u,Integer code);
	/**
	 * 2登录
	 * @param u
	 * @return
	 */
	public Object login(HttpSession session,Long phone,String password);
	/**
	 * 3获取session
	 * @param session
	 * @return
	 */
	public Object getSession(HttpSession session);
	/**
	 * 4获取短信验证码
	 * @param session
	 * @param phone
	 * @return
	 */
	public Object getValidateCode(HttpSession session,Long phone);
	/**
	 * 5完善用户详细信息
	 * @param ud
	 * @return
	 */
	public Object addUserDetail(HttpSession session,UserDetail ud);
	/**
	 * 6修改用户详细信息
	 * @param ud
	 * @return
	 */
	public Object updateUserDetail(UserDetail ud);
	/**
	 * 7获取当前用户信息
	 * @param session
	 * @return
	 */
	public Object getUser(HttpSession session);
}
