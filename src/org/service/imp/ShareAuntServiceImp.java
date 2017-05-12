package org.service.imp;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dao.ShareAuntDao;
import org.model.ShareAunt;
import org.model.User;
import org.service.ShareAuntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.JsonObject;

@Service
public class ShareAuntServiceImp implements ShareAuntService{
	@Autowired
	private ShareAuntDao saDao;
	
	@Override
	public Object addShareAunt(HttpSession session,ShareAunt sa) {
		User u= (User) session.getAttribute("user");
		if(u!=null){
			sa.setUserId(u.getId());
			sa.setShare(1);		//添加的默认状态为已共享
			sa.setTime(new Date().getTime()/1000);
			if(saDao.addShareAunt(sa)!=-1)
				return JsonObject.getResult(1, "添加一条共享信息成功", true);	
			else
				return JsonObject.getResult(0, "添加一条共享信息失败", false);
		}else{
			return JsonObject.getResult(-999, "请先登录，才能发布共享信息", false);			
		}
		
	}

	@Override
	public Object deleteShareAunt(long id) {
		if(saDao.deleteShareAunt(id))
			return JsonObject.getResult(1, "删除共享信息成功", true);
		else
			return JsonObject.getResult(0, "删除共享信息失败", false);
	}

	@Override
	public Object updateShareAunt(ShareAunt sa) {
		if(sa.getRemark()==null)
			sa.setRemark("");
		sa.setTime(new Date().getTime()/1000);
		if(saDao.updateShareAunt(sa))
			return JsonObject.getResult(1, "修改共享信息成功", true);
		else
			return JsonObject.getResult(0, "修改共享信息失败", false);
	}

	@Override
	public Object getShareAuntList(HttpSession session, Integer start,
			Integer limit) {
		
		User u  =(User) session.getAttribute("user");
		if(u!=null){
			List li = saDao.getShareAuntList(1, start, limit, u.getId());
			return JsonObject.getResult(1, "获取共享阿姨列表", li);
		}else{
			return JsonObject.getResult(-999, "请先登录，才能获取共享列表", false);
		}
	}

	@Override
	public Object getUnShareAuntList(HttpSession session, Integer start,
			Integer limit) {
		User u  =(User) session.getAttribute("user");
		if(u!=null){
			List li = saDao.getShareAuntList(0, start, limit, u.getId());
			return JsonObject.getResult(1, "获取未共享阿姨列表", li);
		}else{
			return JsonObject.getResult(-999, "请先登录，才能获取未共享列表", false);
		}
	}

	@Override
	public Object setShareAunt(long id) {
		if(saDao.setShareAunt(id, 1))
			return JsonObject.getResult(1, "共享成功", true);
		else
			return JsonObject.getResult(0, "共享失败", false);
	}

	@Override
	public Object setUnShareAunt(long id) {
		if(saDao.setShareAunt(id, 0))
			return JsonObject.getResult(1, "取消共享成功", true);
		else
			return JsonObject.getResult(0, "取消共享失败", false);
	}

}
