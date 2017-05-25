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
	 * @param session
	 * @param o
	 * @return
	 */
	public Object addStaff(HttpSession session, HttpServletRequest request,
			Staff o, @RequestParam("file") CommonsMultipartFile file)
			throws IllegalStateException, IOException;
}
