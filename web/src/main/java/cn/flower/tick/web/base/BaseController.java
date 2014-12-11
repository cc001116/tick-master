package cn.flower.tick.web.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.flower.tick.model.system.User;

public abstract class BaseController {
	//protected HttpServletRequest request;
	//protected HttpServletResponse response;
	/**
	 * value = "success"
	 */
	protected final static String USER_KEY = "user";
	protected final static String SUCCESS = "success";
	
	protected User getSessionUser(HttpServletRequest request) {
		return getSessionUser(request.getSession());
	}
	
	protected User getSessionUser(HttpSession session) {
		return (User) session.getAttribute(USER_KEY);
	}
	
	protected void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(USER_KEY, user);
	}
	
}
