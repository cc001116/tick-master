package cn.flower.tick.client.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.flower.tick.client.util.HttpClientUtil;
import cn.flower.tick.client.util.JsonUtil;
import cn.flower.tick.client.util.PropertiesUtil;

public class UserTest {

	@Test
	public void register() {
		String uri = HttpClientUtil.HOST + "/user/register";
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "chen");
		map.put("password", "chen");
		String msg = HttpClientUtil.sendPostRequest(uri, map, null);
		System.out.println(msg);
	}

	@Test
	public void login() {
		String username = "chen";
		String uri = HttpClientUtil.HOST + "/user/login/" + username;
		Map<String, String> map = new HashMap<String, String>();
		map.put("password", "chen");
		String msg = HttpClientUtil.sendPostRequest(uri, map, null);
		System.out.println(msg);
		String lastUsername = PropertiesUtil.getValue("username");
		long currentTime = System.currentTimeMillis();
		String lastTime = PropertiesUtil.getValue("loginTime");
		long lastLoginTime = Long.parseLong(lastTime);

		/**
		 * 不是同一用户登录或超时重写session
		 */
		 
			String js = JsonUtil.getValue(msg, "JSESSIONID");
			PropertiesUtil.storePropertiesFile(js, String.valueOf(currentTime), username);
			System.out.println(js);
		

	

		String js1 = JsonUtil.getValue(msg, "JSESSIONID");
		PropertiesUtil.storePropertiesFile(js1, String.valueOf(currentTime),
				username);
		System.out.println(js1);

	}


	@Test
	public void modifyPassword() {
		String uri = HttpClientUtil.HOST + "/user/update/password/5";
		Map<String, String> map = new HashMap<String, String>();
		map.put("oldPassword", "chen");
		map.put("newPassword", "cheng");
		String msg = HttpClientUtil.sendPostRequest(uri, map,
				HttpClientUtil.getDefaultHeader());
		System.out.println(msg);
	}
}
