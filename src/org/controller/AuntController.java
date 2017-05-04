package org.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.AuntContactForm;
import org.Form.AuntWorkForm;
import org.model.Aunt;
import org.service.AuntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
			AuntContactForm c,AuntWorkForm w,
			@RequestParam("file") CommonsMultipartFile file) throws Exception {

		for(String aa:c.getCname())
			System.out.println(aa);
		
		return aService.addAunt(session, request, a, languageId, cookingId,
				skillId, applianceId, certificateId, jobId, c, w, file);
	}
	
	@RequestMapping("/deleteAunt")
	@ResponseBody
	public Object deleteAunt(long id)throws Exception{
		return aService.deleteAunt(id);
	}
}
