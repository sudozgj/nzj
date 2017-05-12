package org.service.imp;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dao.ShareEmployerDao;
import org.model.ShareEmployer;
import org.model.User;
import org.service.ShareEmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.JsonObject;

@Service
public class ShareEmployerServiceImp implements ShareEmployerService{
	@Autowired
	private ShareEmployerDao seDao;
	
	@Override
	public Object addShareEmployer(HttpSession session, ShareEmployer se) {
		User u = (User) session.getAttribute("user");
		if(u!=null){
			se.setUserId(u.getId());
			se.setShare(1);
			se.setTime(new Date().getTime()/1000);
			if(seDao.addShareEmployer(se)!=-1)
				return JsonObject.getResult(1, "添加共享信息成功", true);
			else
				return JsonObject.getResult(0, "添加共享信息失败", false);
		}else{
			return JsonObject.getResult(-999, "请先登录，才能发布共享信息", false);
		}
	}

	@Override
	public Object deleteShareEmployer(long id) {
		if(seDao.deleteShareEmployer(id))
			return JsonObject.getResult(1, "删除共享信息成功", true);
		else
			return JsonObject.getResult(0, "删除共享信息失败", false);
	}

	@Override
	public Object updateShareEmployer(ShareEmployer se) {
		if(se.getRemark()==null)
			se.setRemark("");
		se.setTime(new Date().getTime()/1000);
		if(seDao.updateShareEmployer(se))
			return JsonObject.getResult(1, "修改共享信息成功", true);
		else
			return JsonObject.getResult(0, "修改共享信息失败", false);
	}

	@Override
	public Object getShareEmployerList(HttpSession session, Integer start,
			Integer limit) {
		User u=(User) session.getAttribute("user");
		if(u!=null){
			List li = seDao.getShareEmployerList(1, start, limit, u.getId());
			return JsonObject.getResult(1, "获取共享客户列表", li);
		}else{
			return JsonObject.getResult(-999, "请先登录，获取共享客户列表", false);
		}
	}

	@Override
	public Object getUnShareEmployerList(HttpSession session, Integer start,
			Integer limit) {
		User u  =(User) session.getAttribute("user");
		if(u!=null){
			List li = seDao.getShareEmployerList(0, start, limit, u.getId());
			return JsonObject.getResult(1, "获取未共享客户列表", li);
		}else{
			return JsonObject.getResult(-999, "请先登录，才能获取未共享列表", false);
		}
	}

	@Override
	public Object setShareEmployer(long id) {
		if(seDao.setShareEmployer(id, 1))
			return JsonObject.getResult(1, "共享成功", true);
		else
			return JsonObject.getResult(0, "共享失败", false);
	}

	@Override
	public Object setUnShareEmployer(long id) {
		if(seDao.setShareEmployer(id, 0))
			return JsonObject.getResult(1, "取消共享成功", true);
		else
			return JsonObject.getResult(0, "取消共享失败", false);
	}

}
