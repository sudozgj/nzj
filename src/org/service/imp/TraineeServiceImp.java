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

import org.dao.TraineeDao;
import org.model.Trainee;
import org.model.User;
import org.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tool.JsonObject;
import org.tool.readProperties;

@Service
public class TraineeServiceImp implements TraineeService {
	@Autowired
	private TraineeDao tDao;

	@Override
	public Object addTrainee(HttpSession session, HttpServletRequest request,
			Trainee t, CommonsMultipartFile file1, CommonsMultipartFile file2,
			CommonsMultipartFile file3, CommonsMultipartFile file4)
			throws IllegalStateException, IOException {

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return JsonObject.getResult(-999, "请先登录，才能添加学员", false);
		}

		String f1Name = file1.getOriginalFilename();
		String f2Name = file2.getOriginalFilename();
		String f3Name = file3.getOriginalFilename();
		String f4Name = file4.getOriginalFilename();

		if (f1Name.equals("") || f2Name.equals("") || f3Name.equals("")
				|| f4Name.equals("")) {
			return JsonObject.getResult(0, "上传的内容不能有空", false);
		}

		f1Name = new Date().getTime() / 1000 + "_" + new Random().nextInt(10)
				+ f1Name.substring(f1Name.indexOf("."));

		f2Name = new Date().getTime() / 1000 + "_" + new Random().nextInt(10)
				+ f2Name.substring(f2Name.indexOf("."));

		f3Name = new Date().getTime() / 1000 + "_" + new Random().nextInt(10)
				+ f3Name.substring(f3Name.indexOf("."));

		f4Name = new Date().getTime() / 1000 + "_" + new Random().nextInt(10)
				+ f4Name.substring(f4Name.indexOf("."));

		String rPath = request.getSession().getServletContext()
				.getRealPath("/"); // 项目根目录 ...\nzj\
		String upDir = "upload" + File.separator + "order_trainee"; // 文件夹名
		String path = rPath + upDir; // 图片保存的完整目录

		File dir = new File(path);
		if (!dir.exists() && !dir.isDirectory()) {
			dir.mkdirs();
		}

		String fPath1 = path + File.separator + f1Name; // 文件最终路径
		String fPath2 = path + File.separator + f2Name; // 文件最终路径
		String fPath3 = path + File.separator + f3Name; // 文件最终路径
		String fPath4 = path + File.separator + f4Name; // 文件最终路径

		String url1 = new readProperties().getP("server")
				+ "upload/order_trainee/" + f1Name; // 保存url
		String url2 = new readProperties().getP("server")
				+ "upload/order_trainee/" + f2Name; // 保存url
		String url3 = new readProperties().getP("server")
				+ "upload/order_trainee/" + f3Name; // 保存url
		String url4 = new readProperties().getP("server")
				+ "upload/order_trainee/" + f4Name; // 保存url

		File f1 = new File(fPath1);
		file1.transferTo(f1);

		File f2 = new File(fPath2);
		file2.transferTo(f2);

		File f3 = new File(fPath3);
		file3.transferTo(f3);

		File f4 = new File(fPath4);
		file4.transferTo(f4);

		t.setIdcardurl1(url1);
		t.setIdcardurl2(url2);
		t.setPhotourl(url3);
		t.setInfourl(url4);

		t.setBind(0); // 初始化绑定标志为0，表示未绑定订单
		t.setUserId(user.getId()); // 绑定学员所属的用户
		if (tDao.addTrainee(t) != -1)
			return JsonObject.getResult(1, "添加学员成功", true);
		else
			return JsonObject.getResult(-1, "添加学员失败", false);
	}

	@Override
	public Object deleteTrainee(Long id) {
		if (tDao.deleteTrainee(id))
			return JsonObject.getResult(1, "删除学员成功", true);
		else
			return JsonObject.getResult(0, "删除学员失败", false);
	}

	@Override
	public Object getTraineeListByOrderId(Long orderId, Integer start,
			Integer limit) {
		List li = tDao.getTraineeListByOrderId(orderId, start, limit);

		if (li.size() == 0)
			return JsonObject.getResult(0, "该订单暂无学员，请为其添加学员", false);

		long count = tDao.getTraineeCountByOrderId(orderId);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("result", li);

		return JsonObject.getResult(1, "获取学员列表", map);
	}

	@Override
	public Object getUnBindTraineeList(HttpSession session, Integer start,
			Integer limit) {
		User u = (User) session.getAttribute("user");
		if (u == null)
			return JsonObject.getResult(0, "请先登录，才能获取为绑定订单的学员列表", false);

		List li = tDao.getUnBindTraineeList(u.getId(), start, limit);
		long count = tDao.getUnBindTraineeCount(u.getId());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("result", li);

		return JsonObject.getResult(1, "获取未绑定订单的学员列表", map);
	}

	@Override
	public Object getTraineeListByUserId(HttpSession session, Integer start,
			Integer limit) {
		User u = (User) session.getAttribute("user");
		if(u==null)
			return JsonObject.getResult(0, "请先登录，才能获取学员学员列表", false);
		
		List li = tDao.getTraineeListByUserId(u.getId(), start, limit);
		long count = tDao.getTraineeCountByUserId(u.getId());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("result", li);

		return JsonObject.getResult(1, "获取当前用户的学员列表", map);
	}

}
