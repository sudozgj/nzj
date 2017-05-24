package org.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.dao.TraineeDao;
import org.model.Trainee;
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
	public Object addTrainee(HttpServletRequest request, Trainee t,
			CommonsMultipartFile file1, CommonsMultipartFile file2,
			CommonsMultipartFile file3, CommonsMultipartFile file4)
			throws IllegalStateException, IOException {
		
		String f1Name = file1.getOriginalFilename();
		String f2Name = file2.getOriginalFilename();
		String f3Name = file3.getOriginalFilename();
		String f4Name = file4.getOriginalFilename();

		if (f1Name.equals("") || f2Name.equals("") || f3Name.equals("")
				|| f4Name.equals("")) {
			return JsonObject.getResult(0, "上传的不能有空", false);
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

		t.setBind(0);
		if (tDao.addTrainee(t) != -1)
			return JsonObject.getResult(1, "添加学员成功", true);
		else
			return JsonObject.getResult(0, "添加学员失败", false);
	}

}
