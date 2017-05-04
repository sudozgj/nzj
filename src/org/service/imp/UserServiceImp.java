package org.service.imp;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.dao.UserDao;
import org.dao.UserDetailDao;
import org.model.User;
import org.model.UserDetail;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.JsonObject;
import org.tool.SendPost;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao uDao;
	@Autowired
	private UserDetailDao udDao;

	public Object register(HttpSession session, User u, Integer code) {
		System.out.println("	code: " + code);
		int s_code = (int) session.getAttribute("code");
		if (s_code != code) {
			return JsonObject.getResult(0, "验证码错误", false);
		} else {
			if (uDao.getUser(u.getPhone()) != null) {
				return JsonObject.getResult(0, "该手机已注册", false);
			} else {
				u.setAck(0);
				u.setClock(new Date().getTime() / 1000);
				u.setRank(-1);
				long id = uDao.addUser(u);
				u.setId(id);
				u.setPassword("******");
				session.setAttribute("user", u);
				if (id != -1) {
					return JsonObject.getResult(1, "注册成功", true);
				} else
					return JsonObject.getResult(0, "注册失败", false);
			}
		}
	}

	@Override
	public Object login(HttpSession session, Long phone, String password) {
		User u = uDao.getUser(phone, password);
		if (u != null) {
			u.setPassword("******");
			session.setAttribute("user", u);
			return JsonObject.getResult(1, "success", true);
		} else
			return JsonObject.getResult(0, "用户名或密码错误", false);
	}

	@Override
	public Object getSession(HttpSession session) {
		User u = (User) session.getAttribute("user");
		return JsonObject.getResult(1, "session", session.getAttribute("user"));
	}

	@Override
	public Object getValidateCode(HttpSession session, Long phone) {
		try {
			System.out.println("	phone: " + phone);

			String templateId = "2de5152421cd4a4cb628370e74b27e3b"; // 短信模板
			int code = (int) ((Math.random() * 9 + 1) * 100000); // 6位短信验证码
			System.out.println("	code: " + code);

			session.setAttribute("code", code); // 保存到session中用于验证

			String url = "http://v1.avatardata.cn/Sms/Send?key=2d7bce4f548d4a75864ee4ffa86d443e"; // 短信服务url

			String param = "&mobile=" + phone + "&" + "templateId="
					+ templateId + "&param=" + code;

			String result = new SendPost().sendPost(url, param);
			System.out.println("	result: " + result);

			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(result);

			if (node.get("error_code").toString().equals("0"))
				return JsonObject.getResult(1, "发送成功，等待接收", true);
			else
				return JsonObject.getResult(0, "参数有误，请检查", false);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return JsonObject.getResult(0, "JsonProcessingException异常，请检查",
					false);
		} catch (IOException e) {
			e.printStackTrace();
			return JsonObject.getResult(0, "IOException异常，请检查", false);
		}
	}

	@Override
	public Object addUserDetail(HttpSession session, UserDetail ud) {
		//需要先登录，不需要设置id，userid从session中获取
		if (udDao.getUserDetail(ud.getUsername()) == null) {
			User u = (User) session.getAttribute("user");
			if(u==null){
				System.out.println("	addUserDetail--未登录");
				return JsonObject.getResult(-999, "请先登录", "addUserDetail");
			}
			ud.setUserid(u.getId());
			if (udDao.addUserDetail(ud) != -1) {
				return JsonObject.getResult(1, "添加详细信息成功", true);
			} else {
				return JsonObject.getResult(0, "添加详细信息失败", false);
			}
		} else {
			return JsonObject.getResult(0, "用户名已使用", false);
		}
	}

	@Override
	public Object updateUserDetail(UserDetail ud) {
		if (udDao.updateUserDetail(ud))
			return JsonObject.getResult(1, "修改详细信息成功", true);
		else
			return JsonObject.getResult(0, "修改详细信息失败", false);
	}
}
