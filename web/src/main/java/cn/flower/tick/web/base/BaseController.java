package cn.flower.tick.web.base;

import javax.servlet.http.HttpSession;

import cn.flower.tick.model.system.User;

public abstract class BaseController {
	//protected HttpServletRequest request;
	//protected HttpServletResponse response;
	/**
	 * value = "success"
	 */
	protected final static String SUCCESS = "success";
	
	public User getUser(HttpSession session) {
		return (User) session.getAttribute("user");
	}
	
	
}
