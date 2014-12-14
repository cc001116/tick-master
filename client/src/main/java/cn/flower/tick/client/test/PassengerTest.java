package cn.flower.tick.client.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
		JSONArray array = JSON.parseArray(msg);
		
		for(int i = 0; i < array.size(); i++){
			
			JSONObject obj = array.getJSONObject(i);
			System.out.print(obj.get("id").toString()+"  ");
			System.out.print(obj.get("name").toString()+"  ");
			System.out.print(obj.get("status").toString()+"  ");
		}
		
		//System.out.println(msg);
	}
}
