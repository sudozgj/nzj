package org.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.Form.PactTrackingForm;
import org.dao.PactDao;
import org.model.Pact;
import org.model.PactTracking;
import org.model.User;
import org.service.PactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.ChangeTime;
import org.tool.JsonObject;

@Service
public class PactServiceImp implements PactService {
	@Autowired
	private PactDao pDao;

	@Override
	public Object addPact(HttpSession session, Pact e, String eTime) {
		User u = (User) session.getAttribute("user");
		if (u == null) {
			System.out.println("	addPact--未登录");
			return JsonObject.getResult(-999, "请先登录，才能创建合同", false);
		}
		if (pDao.getPactByCode(e.getCode()) != null) {
			return JsonObject.getResult(0, "合同号已存在，请勿重复录入", false);
		} else {
			e.setUserId(u.getId());
			e.setPtime(Long.parseLong(ChangeTime.date2TimeStamp(eTime,
					"yyyy-MM-dd")));
			if(pDao.addPact(e)!=-1){
				return JsonObject.getResult(1, "添加合同成功", true);
			}else
				return JsonObject.getResult(-1, "添加合同失败", false);
		}
	}

	@Override
	public Object deletePact(Long id) {
		if(pDao.deletePact(id))
			return JsonObject.getResult(1, "删除合同成功", true);
		else
			return JsonObject.getResult(0, "删除合同失败", false);
	}

	@Override
	public Object updatePact(Pact e, String eTime) {
		e.setPtime(Long.parseLong(ChangeTime.date2TimeStamp(eTime, "yyyy-MM-dd")));
		if(pDao.updatePact(e))
			return JsonObject.getResult(1, "修改合同成功", true);
		else
			return JsonObject.getResult(0, "修改合同失败", false);
	}

	@Override
	public Object getPactList(HttpSession sesion, Integer start, Integer limit) {
		Map<String,Object> map = new HashMap<String, Object>();
		User u = (User) sesion.getAttribute("user");
		if(u==null){
			System.out.println("	getPactList--未登录");
			return JsonObject.getResult(-999, "请先登录，才能获取合同列表", false);
		}
		long count = pDao.getPactCountById(u.getId());
		List li = pDao.getPactList(u.getId(), start, limit);
		map.put("count", count);
		map.put("result", li);
		return JsonObject.getResult(1, "获取合同列表", map);
	}

	@Override
	public Object addPactTracking(Long pactId,PactTrackingForm pt) {
		if(pDao.addPactTracking(pactId,pt))
			return JsonObject.getResult(1, "添加合同服务跟踪情况成功", true);
		else
			return JsonObject.getResult(0, "添加合同服务跟踪情况失败", false);
	}

	@Override
	public Object deletePactTracking(Long id) {
		if(pDao.deletePactTracking(id))
			return JsonObject.getResult(1, "删除合同服务跟踪情况成功", true);
		else
			return JsonObject.getResult(0, "删除合同服务跟踪情况失败", false);
	}

	@Override
	public Object updatePactTracking(PactTracking pt,String ptTime) {
		pt.setTtime(Long.parseLong(ChangeTime.date2TimeStamp(ptTime, "yyyy-MM-dd")));
		if(pDao.updatePactTracking(pt))
			return JsonObject.getResult(1, "修改合同服务跟踪情况成功", true);
		else
			return JsonObject.getResult(0, "修改合同服务跟踪情况失败", false);
	}

	@Override
	public Object getPactTrackingList(Long packId) {
		List li = pDao.getPactTrackingList(packId);
		return JsonObject.getResult(1, "获取合同跟踪情况列表", li);
	}
}
