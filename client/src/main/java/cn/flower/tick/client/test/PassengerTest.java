package cn.flower.tick.client.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.junit.Test;

import cn.flower.tick.client.util.HttpClientUtil;

public class PassengerTest {
	
	@Test
	public void savePassenger() {
		String url = HttpClientUtil.HOST + "/passenger/save";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "test");
		params.put("idCard", "1");
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
