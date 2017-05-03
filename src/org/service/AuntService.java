package org.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.AuntContactForm;
import org.Form.AuntWorlForm;
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
			@RequestBody List<AuntContact> c, @RequestBody List<AuntWork> w,
			@RequestParam("file") CommonsMultipartFile file)
			throws IllegalStateException, IOException;
}
