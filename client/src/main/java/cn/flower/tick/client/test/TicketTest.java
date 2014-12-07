package cn.flower.tick.client.test;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

import cn.flower.tick.client.util.HttpClientUtil;

public class TicketTest {
	@Test
	public void queryUnsoldTicket() {
		String from = "北京";
		String to = "南阳";
		String uri = HttpClientUtil.HOST + "/ticket/view/unsold/"+from+"/"+to+"/2014-12-7";
		
		String msg = HttpClientUtil.sendGetRequest(uri, HttpClientUtil.getDefaultHeader());
		System.out.println(msg);
		//[车次， 座类型ID， 座类型名称, 价格, 开车时间 , 余票]
		//[4,1,"硬座",109,"18:34",583]
	}
 }
