package cn.flower.tick.web.system;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.flower.tick.model.system.User;
import cn.flower.tick.service.IUserService;
import cn.flower.tick.web.base.BaseController;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public String Register(@ModelAttribute("user") User user) {
		userService.register(user);
		return "user/register";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login/{username}")
	@ResponseBody
	public Map<String, String> login(HttpServletRequest request, @PathVariable String username, @RequestParam("password") String password ) {
		System.out.println(username);
		System.out.println(password);
		User user = userService.query(username);
		String msg = null;
		if(user == null) {
			msg = "用户不存在";
		} else if(!user.getPassword().equals(password.trim())) 
			msg = "密码错误";
		else
			msg = SUCCESS;
		
		setSessionUser(request, user);
		Map<String, String> responseContext = new HashMap<String, String>();
		responseContext.put("JSESSIONID", request.getSession().getId());
		responseContext.put("msg", msg);
		return responseContext;
	}
	
	@RequestMapping("/info/{id}")
	@ResponseBody
	public User showInfo(@PathVariable Long id) {
		return userService.query(id);
	}
}
