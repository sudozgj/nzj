package org.tool;

import javax.servlet.http.HttpSession;

import org.model.User;

public class CheckUserOrStaff {
	public static Object getResult(HttpSession session){
		User u = (User) session.getAttribute("user");
		if(u!=null)
			return "1-"+u.getPhone();
		else
			return "0"+"s";
	}
}
