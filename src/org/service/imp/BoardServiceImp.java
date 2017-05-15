package org.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.dao.BoardDao;
import org.model.Board;
import org.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tool.JsonObject;
import org.tool.readProperties;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	private BoardDao bDao;

	@Override
	public Object addBoard(HttpServletRequest request, Board b,
			@RequestParam("file") CommonsMultipartFile file)
			throws IllegalStateException, IOException {

		String fName = file.getOriginalFilename();
		String oName = fName;
		if (fName.equals("")) {
			return JsonObject.getResult(0, "文件不能为空", false);
		}

		fName = new Date().getTime() / 1000 + "_" + new Random().nextInt(20)
				+ fName.substring(fName.indexOf("."));

		String rPath = request.getSession().getServletContext()
				.getRealPath("/"); // 项目根目录 .. \nzj\

		String upDir = "upload" + File.separator + "board_file";

		String path = rPath + upDir; // 上传公告文件保存的完整目录

		File dir = new File(path);
		if (!dir.exists() && !dir.isDirectory()) {
			dir.mkdirs();
		}
		String fPath = path + File.separator + fName;
		String url = new readProperties().getP("server") + "upload/board_file/"
				+ fName;

		File f = new File(fPath);
		file.transferTo(f);
		// -----------------------文件传输完成------------------------

		b.setTime(new Date().getTime() / 1000);
		b.setUrl(url);
		b.setName(oName);
		System.out.println("	上传文件名：" + oName);
		System.out.println("	文件url：" + url);

		if (bDao.addBoard(b) != -1)
			return JsonObject.getResult(1, "上传公告成功", url);
		else
			return JsonObject.getResult(-1, "上传公告失败", false);
	}

	@Override
	public Object deleteBoard(HttpServletRequest request,Long id) throws Exception {
		String url = bDao.getUrlById(id);
		if (bDao.deleteBoard(id)) {
			String rPath = request.getSession().getServletContext()
					.getRealPath("/"); // 项目根目录 .. \nzj\
			String upDir = "upload" + File.separator + "board_file";
			String path = rPath + upDir; // 上传公告文件保存的完整目录
			
			String[] s=url.split("/");
			String dirName = s[s.length-1];
			System.out.println(dirName);
			File folder = new File(path);
			File[] files = folder.listFiles();
			for(File file:files){
				if(file.getName().equals(dirName)){
					file.delete();	//清除数据库记录时，同时删除文件
				}
			}
			return JsonObject.getResult(1, "删除公告成功", true);
		} else
			return JsonObject.getResult(0, "删除公告失败", false);
	}

	@Override
	public Object updateBoard(Long id, String title, String description)
			throws Exception {
		if(description==null){
			description="";
		}
		if (bDao.updateBoard(id, title, description))
			return JsonObject.getResult(1, "修改成功", true);
		else
			return JsonObject.getResult(0, "修改失败", false);
	}

	@Override
	public Object getBoardList(Integer start, Integer limit) throws Exception {
		List li = bDao.getBoardList(start, limit);
		return JsonObject.getResult(1, "获取公告列表", li);
	}
}
