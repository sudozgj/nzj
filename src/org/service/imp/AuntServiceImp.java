package org.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.Form.AuntContactForm;
import org.Form.AuntWorkForm;
import org.dao.ApplianceDao;
import org.dao.AuntContactDao;
import org.dao.AuntDao;
import org.dao.AuntPhotoDao;
import org.dao.AuntWorkDao;
import org.dao.CertificateDao;
import org.dao.CookingDao;
import org.dao.JobDao;
import org.dao.LanguageDao;
import org.dao.SkillDao;
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
import org.view.VAuntId;

@Service
public class AuntServiceImp implements AuntService {
	@Autowired
	private AuntDao aDao;
	
	@Autowired
	private LanguageDao lDao;
	@Autowired
	private ApplianceDao apDao;
	@Autowired
	private CookingDao cDao;
	@Autowired
	private SkillDao sDao;
	@Autowired
	private CertificateDao ceDao;
	@Autowired
	private JobDao jDao;
	@Autowired
	private AuntContactDao acDao;
	@Autowired
	private AuntWorkDao awDao;
	
	@Override
	public Object addAunt(HttpSession session, HttpServletRequest request,
			Aunt a, Long[] languageId, Long[] cookingId, Long[] skillId,
			Long[] applianceId, Long[] certificateId, Long[] jobId,
			AuntContactForm c, AuntWorkForm w,
			@RequestParam("file") CommonsMultipartFile file)
			throws IllegalStateException, IOException {

		User u = (User) session.getAttribute("user");
		if (u != null) {
			if (aDao.getAunt(a.getIdnumber()) != null) { // 验证是否重复插入阿姨，根据身份证号判断
				return JsonObject.getResult(-2, "此身份证已用，请核实", false);
			}

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
			// System.out.println("url:" + url);

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

	@Override
	public Object deleteAunt(long id) {
		if (aDao.deleteAunt(id))
			return JsonObject.getResult(1, "删除阿姨成功", true);
		else
			return JsonObject.getResult(0, "删除阿姨失败", false);
	}

	@Override
	public Object getAuntList(HttpSession session, Integer start, Integer limit) {
		User u = (User) session.getAttribute("user");
		if (u != null) {
			List<VAuntId> li = aDao.getAuntList(start, limit, u.getId());
			Long count = aDao.getAuntCount(u.getId());
			List list = new ArrayList();
			for(VAuntId va:li){
				Map<String, Object> aMap = new HashMap();
				Long auntId = va.getId();	//阿姨id
				aMap.put("id", va.getId());
				aMap.put("name", va.getName());
				aMap.put("age", va.getAge());
				aMap.put("sign", va.getSign());
				aMap.put("native", va.getNative_());
				aMap.put("sex", va.getSex());
				aMap.put("education", va.getEducation());
				aMap.put("marriage", va.getMarriage());
				aMap.put("nation", va.getNation());
				aMap.put("height", va.getHeight());
				aMap.put("weight", va.getWeight());
				aMap.put("sight", va.getSigh());
				aMap.put("idnumber", va.getIdnumber());
				aMap.put("phone", va.getPhone());
				aMap.put("address", va.getAddress());
				aMap.put("url", va.getUrl());		//照片通过视图组合进来了，不需要像下面一下添加
				aMap.put("userId", va.getUserId());
				
				aMap.put("language", lDao.getLanguageByAuntId(auntId));
				aMap.put("cooking", cDao.getCookingByAuntId(auntId));
				aMap.put("skill", sDao.getSkillByAuntId(auntId));
				aMap.put("appliance", apDao.getApplianceByAuntId(auntId));
				aMap.put("certificate", ceDao.getCertificateByAuntId(auntId));
				aMap.put("job", jDao.getJobByAuntId(auntId));
				
				aMap.put("contact", acDao.getContactByAuntId(auntId));
				aMap.put("work", awDao.getWorkByAuntId(auntId));
				
				list.add(aMap);
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", list);
			map.put("count", count);
			return JsonObject.getResult(1, "阿姨列表", map);
		} else {
			return JsonObject.getResult(0, "请先登录，才能获取阿姨列表", false);
		}
	}

}
