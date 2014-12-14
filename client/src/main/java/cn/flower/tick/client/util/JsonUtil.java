package cn.flower.tick.client.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	public static String getValue(String text, String key) {
		String value = JSON.parseObject(text).getString(key);
		return value;
	}
	
	public static JSONArray parse(String text) {
		return JSON.parseArray(text);
	}

	
	// new Object[]{"K10" , "北京" , "河南",233,"12.5","卧铺","2014-05-12",""}
	public static void showTrainInfo(String msg) {
		List<Object[]> list = new ArrayList<Object[]>();
		JSONArray array = JSON.parseArray(msg);
		for(int a = 0; a < array.size(); a++) {
			List<Object> obj = new ArrayList<Object>();
	
			JSONArray subArray = array.getJSONArray(a); //驱车信息
			obj.add(subArray.remove(0));
			String trainName = (String) subArray.remove(0);
			obj.add(trainName);
			obj.add(subArray.remove(0));
			//System.out.println();
			for (int i = 0; i < subArray.size(); i++ ){
				JSONArray sub = subArray.getJSONArray(i);
				for(int j = 0 ; j < sub.size(); j++)
					obj.add(sub.get(j));
			}
			list.add(obj.toArray());
			System.out.println();
			System.out.println("++++++++++++++++"+trainName+"++++++++++++++++");
		}
		int row = list.size();
		int column = list.get(0).length;
		Object[][] datas = new Object[row][column];
		for(int i=0;i<row;i++) {
			Object[] values = list.get(i);
			for (int j = 0; j < column; j++) {
				datas[i][j] = values[j];
			}
		}
		
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				System.out.println(datas[i][j]);
			}
		}
	}
	
	
	
	public static void main(String[] args) {		
		
		
		
		/*String msg = "{'JSESSIONID':'D6D1F1CE75657A0E635B2C8F84678A58','msg':'success'}";
		System.out.println(getValue(msg, "JSESSIONID"));
		//PropertiesUtil.storePropertiesFile(getValue(msg, "JSESSIONID"));
		String js = PropertiesUtil.getValue("JSESSIONID");
		System.out.println(js);*/
	}
	
	
}
