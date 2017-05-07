package org.controller;

import javax.servlet.http.HttpSession;

import org.model.Employer;
import org.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployerController {
	@Autowired
	private EmployerService eService;
	
	@RequestMapping("/addEmployer")
	@ResponseBody
	public Object addEmployer (HttpSession session, Employer e, String eTime) {
		return eService.addEmployer(session, e, eTime);
	}
	
	@RequestMapping("/deleteEmployer")
	@ResponseBody
	public Object deleteEmployer (Long id) {
		return eService.deleteEmployer(id);
	}
	
	@RequestMapping("/updateEmployer")
	@ResponseBody
	public Object updateEmployer (Employer e, String eTime) {
		return eService.updateEmployer(e, eTime);
	}
	
	@RequestMapping("/getEmployerList")
	@ResponseBody
	public Object getEmployerList ( HttpSession session, Integer start, Integer limit) {
		return eService.getEmployerList(session, start,limit);
	}
}
