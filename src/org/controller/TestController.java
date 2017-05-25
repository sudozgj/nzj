package org.controller;

import javax.servlet.http.HttpSession;

import org.dao.ModuleDao;
import org.dao.imp.ModuleDaoImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tool.CheckUserOrStaff;

@Controller
public class TestController {
	
	@RequestMapping("/getTest")
	@ResponseBody
	public Object getTest(HttpSession session)throws Exception{
		return CheckUserOrStaff.getResult(session);
	}
	
	@RequestMapping("/getModuleList")
	@ResponseBody
	public Object getModuleList()throws Exception{
		ModuleDao mDao = new ModuleDaoImp();
		return mDao.getModuleList();
	}
}
