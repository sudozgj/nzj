package org.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.dao.EmployerDao;
import org.model.Employer;
import org.model.User;
import org.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.ChangeTime;
import org.tool.JsonObject;

@Service
public class EmployerServiceImp implements EmployerService {
	@Autowired
	private EmployerDao eDao;

	@Override
	public Object addEmployer(HttpSession session, Employer e, String eTime) {
		User u = (User)session.getAttribute("user");
		if (u == null) {
			System.out.println("	addEmployer--未登录");
			return JsonObject.getResult(-999, "请先登录", false);
		}
		if (eDao.getEmployer(u.getId(), e.getName(), e.getPhone()) != null) {
			return JsonObject.getResult(-2, "请勿重复录入", false);
		} else {
			//获取当前用户的userid
			e.setUserId(u.getId());
			//将时间戳转换为Integer类型存入数据库
			e.setTime(Long.parseLong(ChangeTime.date2TimeStamp(eTime, "yyyy-MM-dd")));
			e.setStatus(0);		//初始化客户的状态为新单状态
			if (eDao.addEmployer(e) != -1) {
				return JsonObject.getResult(1, "添加成功", true);
			} else {
				return JsonObject.getResult(0, "添加失败", false);
			}
		}
	}

	@Override
	public Object deleteEmployer(Long id) {
		if (eDao.deleteEmployer(id)) {
			return JsonObject.getResult(1, "删除成功", true);
		} else {
			return JsonObject.getResult(0, "删除失败", false);
		}
	}

	@Override
	public Object updateEmployer(Employer e, String eTime) {
		e.setTime(Long.parseLong(ChangeTime.date2TimeStamp(eTime, "yyyy-MM-dd")));
		if (eDao.updateEmployer(e)) {
			return JsonObject.getResult(1, "修改成功", true);
		} else {
			return JsonObject.getResult(0, "修改失败", false);
		}
	}

	@Override
	public Object getEmployerList(HttpSession session, Integer start, Integer limit) {
		Map<String, Object> map = new HashMap<>();
		User u = (User)session.getAttribute("user");
		if (u == null) {
			System.out.println("	getEmployerList--未登录");
			return JsonObject.getResult(-999, "请先登录", "getEmployerList");
		}
		long count = eDao.getEmployerCountById(u.getId());
		List li = eDao.getEmployerList(start, limit,u.getId());
		map.put("count", count);
		map.put("result", li);
		return JsonObject.getResult(1, "获取列表", map);
	}
}
