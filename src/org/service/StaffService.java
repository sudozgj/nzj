package org.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.model.Staff;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface StaffService {

	/**
	 * 1添加员工，需要登录
	 * 
	 * @param session
	 * @param o
	 * @return
	 */
	public Object addStaff(HttpSession session, HttpServletRequest request,
			Staff o, @RequestParam("file") CommonsMultipartFile file, Long[] mid)
			throws IllegalStateException, IOException;

	/**
	 * 2删除员工，传id号
	 * 
	 * @param id
	 * @return
	 */
	public Object deleteStaff(Long id);

	/**
	 * 3获取员当前用户工列表
	 * 
	 * @param session
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getStaffList(HttpSession session, Integer start, Integer limit);
	
	/**
	 * 4员工登录
	 * @param session
	 * @param phone
	 * @param password
	 * @return
	 */
	public Object sLogin(HttpSession session,Long phone,String password);
}
