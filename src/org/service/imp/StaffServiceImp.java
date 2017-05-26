package org.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.dao.StaffDao;
import org.model.Staff;
import org.model.User;
import org.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tool.JsonObject;
import org.tool.readProperties;

@Service
public class StaffServiceImp implements StaffService {
	@Autowired
	private StaffDao sDao;

	@Override
	public Object addStaff(HttpSession session, HttpServletRequest request,
			Staff o, @RequestParam("file") CommonsMultipartFile file, Long[] mid)
			throws IllegalStateException, IOException {

		User u = (User) session.getAttribute("user");
		if (u != null) {
			if (sDao.getStaff(o.getPhone()) != null) {
				return JsonObject.getResult(-1, "此电话已用，请勿重复添加", false);
			}

			String photoName = file.getOriginalFilename();
			if (photoName.equals("")) {
				return JsonObject.getResult(-2, "照片不能为空", false);
			}

			photoName = new Date().getTime() / 1000 + "_"
					+ new Random().nextInt(10)
					+ photoName.substring(photoName.indexOf("."));

			String rPath = request.getSession().getServletContext()
					.getRealPath("/"); // 项目根目录 ...\nzj\

			String upDir = "upload" + File.separator + "staff_photo";

			String path = rPath + upDir; // 图片保存的完整目录

			File dir = new File(path);
			if (!dir.exists() && !dir.isDirectory()) { // 路径不存在则创建
				dir.mkdirs();
			}
			String fPath = path + File.separator + photoName; // 文件最终路径
			String url = new readProperties().getP("server")
					+ "upload/staff_photo/" + photoName; // 保存的url
			// System.out.println("url:" + url);

			File f = new File(fPath);
			file.transferTo(f);
			// -----------------------文件传输完成------------------------

			if (o.getAddress() == null)
				o.setAddress("");

			o.setTime(new Date().getTime() / 1000);
			o.setPhotourl(url);
			o.setUserId(u.getId());

			if (sDao.addStaff(o,mid) != -1)
				return JsonObject.getResult(1, "添加员工成功", true);
			else
				return JsonObject.getResult(-3, "添加员工失败", false);
		} else {
			return JsonObject.getResult(0, "请先登录，才能添加员工", false);
		}
	}

	@Override
	public Object deleteStaff(Long id) {
		if (sDao.deleteStaff(id))
			return JsonObject.getResult(1, "删除员工成功", true);
		else
			return JsonObject.getResult(0, "删除员工失败", false);
	}

	@Override
	public Object getStaffList(HttpSession session, Integer start, Integer limit) {
		User u = (User) session.getAttribute("user");
		if (u != null) {
			List li = sDao.getStaffList(u.getId(), start, limit);
			long count = sDao.getStaffCount(u.getId());

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("count", count);
			map.put("result", li);

			return JsonObject.getResult(1, "获取员工列表", map);
		} else {
			return JsonObject.getResult(0, "请先登录，才能获取员工列表", false);
		}
	}

	@Override
	public Object sLogin(HttpSession session, Long phone, String password) {
		session.removeAttribute("user");		//清楚缓存，防止同时有user和员工登录
		Staff s = sDao.getStaff(phone,password);
		if(s!=null){
			session.setAttribute("staff", s);
			return JsonObject.getResult(1, "success", true);
		}else{
			return JsonObject.getResult(0, "电话或密码错误", false);
		}
	}

}
