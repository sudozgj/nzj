package org.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.model.Trainee;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface TraineeService {
	/**
	 * 1添加学员
	 * 
	 * @param o
	 * @return
	 */
	public Object addTrainee(HttpSession session, HttpServletRequest request,
			Trainee t, @RequestParam("file1") CommonsMultipartFile file1,
			@RequestParam("file2") CommonsMultipartFile file2,
			@RequestParam("file3") CommonsMultipartFile file3,
			@RequestParam("file4") CommonsMultipartFile file4)
			throws IllegalStateException, IOException;
	
	/**
	 * 2删除学员
	 * @param id
	 * @return
	 */
	public Object deleteTrainee(Long id);
	
	/**
	 * 3根据订单id获取学员列表
	 * @param orderId
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getTraineeListByOrderId(Long orderId,Integer start,Integer limit);
	
	/**
	 * 4获取当前用户未绑定订单的学员的列表
	 * @param session
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getUnBindTraineeList(HttpSession session,Integer start,Integer limit);
	
	/**
	 * 5获取当前用户的学员列表
	 * @param session
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getTraineeListByUserId(HttpSession session,Integer start,Integer limit);
}
