package org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.AuntContactForm;
import org.Form.AuntWorlForm;
import org.model.Aunt;
import org.model.AuntContact;
import org.model.AuntWork;
import org.service.AuntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class AuntController {
	@Autowired
	private AuntService aService;

	@RequestMapping("/addAunt")
	@ResponseBody
	public Object addAunt(HttpSession session, HttpServletRequest request,
			Aunt a, Long[] languageId, Long[] cookingId, Long[] skillId,
			Long[] applianceId, Long[] certificateId, Long[] jobId,
			@RequestBody List<AuntContact> c,@RequestBody List<AuntWork> w,
			@RequestParam("file") CommonsMultipartFile file) throws Exception {

		return aService.addAunt(session, request, a, languageId, cookingId,
				skillId, applianceId, certificateId, jobId, c, w, file);

//		System.out.println(c.size());
//		System.out.println(w.size());
//		System.out.println(c.getLi().size());
//		System.out.println(w.getLi().size());
//		return null;
	}
}
