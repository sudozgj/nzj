package org.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.AuntContactForm;
import org.Form.AuntWorkForm;
import org.model.Aunt;
import org.model.AuntContact;
import org.model.AuntWork;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface AuntService {
	/**
	 * 1添加阿姨
	 * 
	 * @param session
	 * @param a
	 * @return
	 */
	public Object addAunt(HttpSession session, HttpServletRequest request,
			Aunt a, Long[] languageId, Long[] cookingId, Long[] skillId,
			Long[] applianceId, Long[] certificateId, Long[] jobId,
			AuntContactForm c, AuntWorkForm w,
			@RequestParam("file") CommonsMultipartFile file)
			throws IllegalStateException, IOException;
	
	/**
	 * 2删除阿姨
	 * @param id
	 * @return
	 */
	public Object deleteAunt(long id);
	
	/**
	 * 3获取阿姨列表
	 * @param session
	 * @param start
	 * @param limit
	 * @return
	 */
	public Object getAuntList(HttpSession session,Integer start,Integer limit);
}
