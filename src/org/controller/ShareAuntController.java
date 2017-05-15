package org.controller;

import javax.servlet.http.HttpSession;

import org.model.ShareAunt;
import org.service.ShareAuntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShareAuntController {
	@Autowired
	private ShareAuntService saService;

	@RequestMapping("/addShareAunt")
	@ResponseBody
	public Object addShareAunt(HttpSession session, ShareAunt sa)
			throws Exception {
		return saService.addShareAunt(session, sa);
	}

	@RequestMapping("/deleteShareAunt")
	@ResponseBody
	public Object deleteShareAunt(long id) throws Exception {
		return saService.deleteShareAunt(id);
	}

	@RequestMapping("/updateShareAunt")
	@ResponseBody
	public Object updateShareAunt(ShareAunt sa) throws Exception {
		return saService.updateShareAunt(sa);
	}

	@RequestMapping("/getShareAuntList")
	@ResponseBody
	public Object getShareAuntList(HttpSession session, Integer start,
			Integer limit) throws Exception {
		return saService.getShareAuntList(session, start, limit);
	}

	@RequestMapping("/getUnShareAuntList")
	@ResponseBody
	public Object getUnShareAuntList(HttpSession session, Integer start,
			Integer limit) throws Exception {
		return saService.getUnShareAuntList(session, start, limit);
	}

	@RequestMapping("/setShareAunt")
	@ResponseBody
	public Object setShareAunt(long id) throws Exception {
		return saService.setShareAunt(id);
	}

	@RequestMapping("/setUnShareAunt")
	@ResponseBody
	public Object setUnShareAunt(long id) throws Exception {
		return saService.setUnShareAunt(id);
	}

	@RequestMapping("/getAllShareAuntList")
	@ResponseBody
	public Object getAllShareAuntList(Integer start, Integer limit)
			throws Exception {
		return saService.getAllShareAuntList(start, limit);
	}
}
