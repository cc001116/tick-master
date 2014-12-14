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
 * @FileName OrderTest.java
 * @Author ChenCheng
 * @Version v1.0
 * @Date 2014年12月9日 下午9:24:00
 */
public class OrderTest {
	
	@Test
	public void delete() {
		String url = HttpClientUtil.HOST + "/order/delete/31";
		Map<String, String> params = new HashMap<String, String>();
		Header header = HttpClientUtil.getDefaultHeader();
		String msg = HttpClientUtil.sendPostRequest(url, params, header);
		System.out.println(msg);
	}
	
	@Test
	public void pay(){
		String url = HttpClientUtil.HOST + "/order/pay/12";
		Map<String, String> params = new HashMap<String, String>();
		Header header = HttpClientUtil.getDefaultHeader();
		String msg = HttpClientUtil.sendPostRequest(url, params, header);
		System.out.println(msg);
	}
	
	@Test
	public void queryUncompleteOrder(){
		String uri = HttpClientUtil.HOST + "/order/view/uncomplete";
		Header header = HttpClientUtil.getDefaultHeader();
		String msg = HttpClientUtil.sendGetRequest(uri, header);
		System.out.println(msg);
		JSONArray array = JSON.parseArray(msg);
		for(int i = 0; i < array.size(); i++) {
			System.out.println("********************");
			JSONObject obj = array.getJSONObject(i);
			System.out.print(obj.get("id").toString()+"  ");
			System.out.print(obj.get("serialCode").toString()+"  ");
			System.out.print(obj.get("createDate").toString()+"  ");
			JSONObject tick = obj.getJSONObject("ticket");
			System.out.print(tick.get("typeName").toString()+"  ");
			System.out.print(tick.get("arrivalStation").toString()+"  ");
			System.out.print(tick.get("startStation").toString()+"  ");
			System.out.print(tick.get("passenger").toString()+"  ");
			System.out.print(tick.get("seatNo").toString()+"  ");
			System.out.println("********************");


			System.out.println();
		}
	}		
	
	
	@Test
	public void querycompletedOrder(){
		String uri = HttpClientUtil.HOST + "/order/view/completed";
		Header header = HttpClientUtil.getDefaultHeader();
		String msg = HttpClientUtil.sendGetRequest(uri, header);
		System.out.println(msg);
		JSONArray array = JSON.parseArray(msg);
		for(int i = 0; i < array.size(); i++) {
			JSONObject obj = array.getJSONObject(i);
			System.out.print(obj.get("id").toString()+"  ");
			System.out.print(obj.get("serialCode").toString()+"  ");
			System.out.print(obj.get("createDate").toString()+"  ");
			JSONObject tick = obj.getJSONObject("ticket");
			System.out.print(tick.get("typeName").toString()+"  ");
			System.out.print(tick.get("arrivalStation").toString()+"  ");
			System.out.print(tick.get("startStation").toString()+"  ");
			System.out.print(tick.get("passenger").toString()+"  ");
			System.out.print(tick.get("seatNo").toString()+"  ");


			System.out.println();
		}
	}		
}
