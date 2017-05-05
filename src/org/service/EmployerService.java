package org.service;

import javax.servlet.http.HttpSession;

import org.model.Employer;

public interface EmployerService {
	/**
	 * 1.添加客户
	 * @param e
	 * @return
	 */
	public Object addEmployer (HttpSession session, Employer e, String eTime);
	/**
	 * 2.删除客户
	 * @param id
	 * @return
	 */
	public Object deleteEmployer (String id);
	/**
	 * 3.修改客户信息
	 * @param e
	 * @return
	 */
	public Object updateEmployer (Employer e, String eTime);
	/**
	 * 4.分页形式遍历客户信息
	 * @param page
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getEmployerList (HttpSession sesion, Integer start, Integer limit);
}
