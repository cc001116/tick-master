package cn.flower.tick.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.junit.Test;

public class JTest {
	
	@Test
	public void login() {
		String uri = HttpClientUtil.HOST+ "/user/login/user";
		Map<String, String> map = new HashMap<String, String>();
		map.put("password", "1234");
		String msg = HttpClientUtil.sendPostRequest(uri, map, null);
		System.out.println(msg);
		PropertiesUtil.storePropertiesFile(JsonUtil.getValue(msg, "JSESSIONID"));
		System.out.println(PropertiesUtil.getValue("JSESSIONID"));
	}
	
	@Test
	public void savePassenger() {
		String url = HttpClientUtil.HOST + "/passenger/save";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "fanq");
		params.put("idCard", "0001x");
		params.put("phone", "1231233");
		Header header = HttpClientUtil.getDefaultHeader();
		String msg = HttpClientUtil.sendPostRequest(url, params, header);
		System.out.println(msg);
	}
	
	@Test
	public void showAllPassenger() {
		String url = HttpClientUtil.HOST +"/passenger/view/list";
		String msg = HttpClientUtil.sendGetRequest(url, HttpClientUtil.getDefaultHeader());
		
		System.out.println(msg);
	}
}
