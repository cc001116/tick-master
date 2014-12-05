package cn.flower.tick.client.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {
	public static String getValue(String text, String key) {
		String value = JSON.parseObject(text).getString(key);
		return value;
	}
	
	public static void main(String[] args) {
		
		String msg = "{'JSESSIONID':'D6D1F1CE75657A0E635B2C8F84678A58','msg':'success'}";
		System.out.println(getValue(msg, "JSESSIONID"));
		//PropertiesUtil.storePropertiesFile(getValue(msg, "JSESSIONID"));
		String js = PropertiesUtil.getValue("JSESSIONID");
		System.out.println(js);
	}
}
