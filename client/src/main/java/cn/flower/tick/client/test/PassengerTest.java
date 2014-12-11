package cn.flower.tick.client.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.junit.Test;

import cn.flower.tick.client.util.HttpClientUtil;
/**
 * 
 * @FileName PassengerTest.java
 * @Author ChenCheng
 * @Version v1.0
 * @Date 2014年12月9日 下午9:24:07
 */
public class PassengerTest {
	
	@Test
	public void savePassenger() {
		String url = HttpClientUtil.HOST + "/passenger/save";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "chen");
		params.put("idCard", "0003x");
		params.put("phone", "1111111");
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
