package cn.flower.tick.client.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.flower.tick.client.util.HttpClientUtil;

public class tick_choice extends Common_Interface{

	
	tick_choice(String from, String to) {
		JFrame frame = new JFrame();
		Object[][] datas;
//		String from = "北京";
//		String to = "驻马店";
		String uri = HttpClientUtil.HOST + "/ticket/view/unsold/" + from
				+ "/" + to + "/2014-12-7";
		String msg = HttpClientUtil.sendGetRequest(uri,
				HttpClientUtil.getDefaultHeader());

		List<Object[]> list = new ArrayList<Object[]>();
		JSONArray array = JSON.parseArray(msg);
		for (int a = 0; a < array.size(); a++) {
			List<Object> obj = new ArrayList<Object>();

			JSONArray subArray = array.getJSONArray(a); // 驱车信息
			obj.add(subArray.remove(0));
			String trainName = (String) subArray.remove(0);
			obj.add(trainName);
			obj.add(subArray.remove(0));
			// System.out.println();
			for (int i = 0; i < subArray.size(); i++) {
				JSONArray sub = subArray.getJSONArray(i);
				for (int j = 0; j < sub.size(); j++)
					obj.add(sub.get(j));
			}
			list.add(obj.toArray());
			System.out.println();
			System.out.println("++++++++++++++++" + trainName
					+ "++++++++++++++++");
		}
		int row = list.size();
		int column = list.get(0).length;
		datas = new Object[row][column];
		for (int i = 0; i < row; i++) {
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

		Object[] columnTitle = { "type1", "列车号", "开车时间", "type2", "座位", "票价",
				"余票", "type3", "座位", "票价", "余票", "type4", "座位", "票价", "余票",
				"购票"};
		//Object [][] test= {{"test","test","test","test","test","test","test","test","test","test","test","test","test","test","test"}};
		JTable table = new JTable(datas, columnTitle);
		TableColumnModel columnModel = table.getColumnModel();        
		TableColumn column1 = columnModel.getColumn(0);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		
		TableColumn column3 = columnModel.getColumn(3);
		column3.setMinWidth(0);
		column3.setMaxWidth(0);
		
		TableColumn column7 = columnModel.getColumn(7);
		column7.setMinWidth(0);
		column7.setMaxWidth(0);
		
		TableColumn column111 = columnModel.getColumn(11);
		column111.setMinWidth(0);
		column111.setMaxWidth(0);
		
		table.setPreferredScrollableViewportSize(new Dimension(550,30));
		frame.getContentPane().add(table,BorderLayout.CENTER);
		frame.getContentPane().add(table.getTableHeader(),BorderLayout.NORTH);
		frame.setTitle("火车票余票查询");
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}


	public static void main(String args[]) {

		//new tick_choice();
	}
}
