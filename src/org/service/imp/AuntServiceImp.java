package org.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.AuntContactForm;
import org.Form.AuntWorkForm;
import org.dao.AuntDao;
import org.model.Aunt;
import org.model.AuntContact;
import org.model.AuntWork;
import org.model.User;
import org.service.AuntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tool.JsonObject;
import org.tool.readProperties;

@Service
public class AuntServiceImp implements AuntService {
	@Autowired
	private AuntDao aDao;

	@Override
	public Object addAunt(HttpSession session, HttpServletRequest request,
			Aunt a, Long[] languageId, Long[] cookingId, Long[] skillId,
			Long[] applianceId, Long[] certificateId, Long[] jobId,
			AuntContactForm c, AuntWorkForm w,
			@RequestParam("file") CommonsMultipartFile file)
			throws IllegalStateException, IOException {

		User u = (User) session.getAttribute("user");
		if (u != null) {

			String photoName = file.getOriginalFilename();
			// String path = request.getRealPath("/"); // 项目路径

			photoName = new Date().getTime() / 1000 + "_"
					+ new Random().nextInt(10)
					+ photoName.substring(photoName.indexOf("."));

			String rPath = request.getSession().getServletContext()
					.getRealPath("/"); // 项目根目录 ...\nzj\

			String upDir = "upload" + File.separator + "aunt_photo";

			String path = rPath + upDir; // 图片保存的完整目录

			// System.out.println("保存目录目录：" + path);
			// System.out.println("保存文件夹：" + upDir);
			// System.out.println("上传文件名字：" + photoName);

			File dir = new File(path);
			if (!dir.exists() && !dir.isDirectory()) { // 路径不存在则创建
				dir.mkdirs();
			}
			String fPath = path + File.separator + photoName; // 文件最终路径
			String url = new readProperties().getP("server")
					+ "upload/aunt_photo/" + photoName; // 保存的url
			System.out.println("url:" + url);

			File f = new File(fPath);
			file.transferTo(f);
			// -----------------------文件传输完成------------------------

			a.setUserId(u.getId()); // 将阿姨所属的加盟商给添加进去

			boolean bb = aDao.addAunt(a, languageId, cookingId, skillId,
					applianceId, certificateId, jobId, c, w, url);
			if (bb) { // 添加阿姨
				return JsonObject.getResult(1, "添加阿姨成功", true);
			} else {
				return JsonObject.getResult(-1, "添加阿姨失败", false);
			}
		} else {
			return JsonObject.getResult(0, "请先登录，才能添加阿姨", false);
		}
	}

}
