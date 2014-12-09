package cn.flower.tick.client.test;
import org.junit.Test;

import cn.flower.tick.client.util.HttpClientUtil;
import cn.flower.tick.client.util.JsonUtil;

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
 }
