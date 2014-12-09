package cn.flower.tick.client.test;

import org.apache.http.Header;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.flower.tick.client.util.HttpClientUtil;

public class OrderTest {
	
	@Test
	public void queryUncompleteOrder(){
		String uri = HttpClientUtil.HOST + "/order/view/uncomplete";
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
