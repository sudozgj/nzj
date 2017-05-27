package org.controller;

import javax.servlet.http.HttpSession;

import org.Form.PactTrackingForm;
import org.model.Pact;
import org.model.PactTracking;
import org.service.PactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PactController {
	@Autowired
	private PactService pService;
	
	@RequestMapping("/addPact")
	@ResponseBody
	public Object addPact(HttpSession session, Pact e, String eTime)throws Exception{
		return pService.addPact(session, e, eTime);
	}
	
	@RequestMapping("/deletePact")
	@ResponseBody
	public Object deletePact(Long id)throws Exception{
		return pService.deletePact(id);
	}
	
	@RequestMapping("/updatePact")
	@ResponseBody
	public Object updatePact(Pact e, String eTime)throws Exception{
		return pService.updatePact(e, eTime);
	}
	
	@RequestMapping("/getPactList")
	@ResponseBody
	public Object getPactList(HttpSession sesion, Integer start, Integer limit)throws Exception{
		return pService.getPactList(sesion, start, limit);
	}
	
	@RequestMapping("/getPactListByStatus")
	@ResponseBody
	public Object getPactListByStatus (HttpSession session, Integer start, Integer limit,
			Long userId, Integer status) {
		return pService.getPactListByStatus(session, start, limit, userId, status);
	}
	
	//----------------------------------PactTracking 合同服务跟踪------------------------------------
	
	@RequestMapping("/addPactTracking")
	@ResponseBody
	public Object addPactTracking(Long pactId,PactTrackingForm pt)throws Exception{
		return pService.addPactTracking(pactId,pt);
	}
	
	@RequestMapping("/deletePactTracking")
	@ResponseBody
	public Object deletePactTracking(Long id)throws Exception{
		return pService.deletePactTracking(id);
	}
	
	@RequestMapping("/updatePactTracking")
	@ResponseBody
	public Object updatePactTracking(PactTracking pt,String ptTime)throws Exception{
		return pService.updatePactTracking(pt,ptTime);
	}
	
	@RequestMapping("/getPactTrackingList")
	@ResponseBody
	public Object getPactTrackingList(Long packId)throws Exception{
		return pService.getPactTrackingList(packId);
	}
}
