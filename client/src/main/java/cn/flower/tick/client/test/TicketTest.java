package cn.flower.tick.client.test;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.junit.Test;

import cn.flower.tick.client.util.HttpClientUtil;
import cn.flower.tick.client.util.JsonUtil;
/**
 * 
 * @FileName TicketTest.java
 * @Author ChenCheng
 * @Version v1.0
 * @Date 2014年12月9日 下午9:24:13
 */
public class TicketTest {
	@Test
	public void queryUnsoldTicket() {
		String from = "北京";
		String to = "驻马店";
		String uri = HttpClientUtil.HOST + "/ticket/view/unsold/"+from+"/"+to+"/2014-12-7";
		
		String msg = HttpClientUtil.sendGetRequest(uri, HttpClientUtil.getDefaultHeader());
		System.out.println(msg);
		JsonUtil.showTrainInfo(msg);
		//[车次， 座类型ID， 座类型名称, 价格, 开车时间 , 余票]
		//[4,1,{"硬座",109,,583} {"软座",149,}]
		//[4,2,"软座",149,"18:34",583]
	}
	
	@Test
	public void tickSave() {
		String url = HttpClientUtil.HOST + "/ticket/save";
		Map<String, String> params = new HashMap<String, String>();
		params.put("trainId", "6");
		params.put("seatTypeId", "1");
		params.put("passengerId", "2");
		params.put("date", "2014-12-09");
		Header header = HttpClientUtil.getDefaultHeader();
		String msg = HttpClientUtil.sendPostRequest(url, params, header);
		System.out.println(msg);
	}
 }
