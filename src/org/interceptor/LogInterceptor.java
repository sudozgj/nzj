package org.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {

	/**
	 * Handler 执行前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
//		System.out.println("\n——preHandle——");

		String action = request.getServletPath().substring(1);		//请求的接口名
		System.out.println("\n"+request.getContextPath()+"——"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"——"+action);

		return true;
	}

	/**
	 * Handler 执行后，return 前调用
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
//		System.out.println("——postHandle——");.
	}

	/**
	 * Handler 执行后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
//		System.out.println("——afterCompletion——");
	}

}
