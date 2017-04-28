package org.service.imp;

import org.dao.UserDao;
import org.model.User;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tool.JsonObject;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserDao uDao;
	
	public Object register(User u){
		long id = uDao.addUser(u.getPhone(), u.getPassword(), u.getRank());
		if(id!=-1){
			return JsonObject.getResult(1, "注册成功", true);
		}else
			return JsonObject.getResult(0, "注册失败", false);
	}
}
