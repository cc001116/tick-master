package cn.flower.tick.client.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.http.Header;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.flower.tick.client.util.HttpClientUtil;

public class tick_choice extends Common_Interface{

	JScrollPane jscrollpane;
	Container contentPane;
	JCheckBox jcb;
	JComboBox combox;
	JTable table;
	JPanel panel = new JPanel();
	JLabel imagelab,titlelab;
	JButton okbt;
	
	tick_choice(String from, String to,  final String date) {
		
		String seat[] = {"座位类型","硬座","软座","硬卧","软卧"};
		combox = new JComboBox(seat);
		contentPane=this.getContentPane();
		ImageIcon image = new ImageIcon("image/tick_choice.png");
		okbt = new JButton("确定");
		imagelab = new JLabel(image);
		titlelab = new JLabel(date+"日   "+from+" 到达 "+to+" 余票查询");
		imagelab.setBounds(0, 0, 1000, 100);
		titlelab.setBounds(120, 0, 180, 50);
		okbt.setBounds(800, 0, 60, 30);
		combox.setBounds(800, 0, 80, 30);
		titlelab.setFont(new Font("宋体",Font.BOLD, 30));
		panel.add(imagelab);
		panel.add(titlelab);
		panel.add(combox);
		panel.add(okbt);
		
		Object[][] datas;

		String uri = HttpClientUtil.HOST + "/ticket/view/unsold/" + from
				+ "/" + to + "/"+date;
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
				"余票", "type3", "座位", "票价", "余票", "type4", "座位", "票价", "余票","选择"};
		
		
		
		table = new JTable(datas, columnTitle);
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
		
		TableColumn column115 = columnModel.getColumn(15);
		column111.setMinWidth(0);
		column111.setMaxWidth(0);
		//创建表格
		table.getColumnModel().getColumn(15).setCellRenderer(new TableCellRenderer(){
	    	public Component getTableCellRendererComponent(JTable table,
	    			Object value, boolean isSelected, boolean hasFocus,
	    			int row, int column) {
	    	            // 创建用于返回的渲染组件
	    				jcb = new JCheckBox("购票");
	    	            // 使具有焦点的行对应的复选框选中
	    				jcb.setSelected(isSelected);
	    	            // 设置单选box.setSelected(hasFocus);
	    	            // 使复选框在单元格内居中显示
	    	            jcb.setHorizontalAlignment((int) 0.5f);
	    	            return jcb;
	    	       }
	    	});
		
		//设置选择
		okbt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jcb.isSelected()){
					int seatType = 0;
					
					Object trainid =table.getValueAt(table.getSelectedRow(), 0);
					Object test =table.getValueAt(table.getSelectedRow(), 15);
					Object test1 =table.getValueAt(table.getSelectedRow(), 1);
					if(combox.getSelectedItem().equals("硬座")) seatType = 3;
					if(combox.getSelectedItem().equals("软座")) seatType = 7;
					if(combox.getSelectedItem().equals("硬卧")) seatType = 11;
					if(combox.getSelectedItem().equals("软卧")) seatType = 15;
					String data = date;
					System.out.println("***********");
					System.out.print(test1.toString()+" "+trainid+" "+seatType+" "+test.toString());
					
					String url = HttpClientUtil.HOST + "/ticket/save";
					Map<String, String> params = new HashMap<String, String>();
					params.put("trainId", trainid.toString());
					params.put("seatTypeId", table.getValueAt(table.getSelectedRow(), seatType).toString());
					params.put("passengerId", "1");
					params.put("date", data);
					Header header = HttpClientUtil.getDefaultHeader();
					String msg = HttpClientUtil.sendPostRequest(url, params, header);
					System.out.println(msg);
					JOptionPane.showMessageDialog(null, "订单生成，请支付！");
				}else{
					
					JOptionPane.showMessageDialog(null, "选择错误，请重新选择！");
				}
			}
			
		});
		
		jscrollpane=new JScrollPane(table);
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(jscrollpane, BorderLayout.SOUTH);
		this.setVisible(true);
	}


	public static void main(String args[]) {

		new tick_choice("北京","周口","2014-12-11");
	}
}
