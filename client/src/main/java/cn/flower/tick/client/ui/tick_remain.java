package cn.flower.tick.client.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.JXDatePicker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.flower.tick.client.util.HttpClientUtil;

public class tick_remain extends Common_Interface {

	private JPanel jp;
	JScrollPane jscrollpane;
	Container contentPane;
	JCheckBox jcb;
	JComboBox from,to;
	JLabel lablefrom,lableto,datelab;
	JButton checkbt;
	JTable jt=null;
	JXDatePicker date;
	Date nowdate = new Date();
	
	String city[] = { "北京", "上海", "河南", "广州", "河北", "武汉" };
//	Object[][] tableData =   
//	    {  
//	        new Object[]{"K10" , "北京" , "河南",233,"12.5","卧铺","2014-05-12",""},  
//	        new Object[]{"D7888", "河南", "陕西",543,"12.5","卧铺","2014-05-12",""},  
//	        new Object[]{"G123", "陕西", "甘肃",45,"12.5","卧铺","2014-05-12",""},  
//	        new Object[]{"12345", "甘肃" , "吉林",1,"12.5","卧铺","2014-05-12",""},  
//	        new Object[]{"K754" , "吉林", "北京",90,"12.5","卧铺","2014-05-12",""}  ,
//	        new Object[]{"K10" , "北京" , "河南",233,"12.5","卧铺","2014-05-12",""},  
//	        new Object[]{"D7888", "河南", "陕西",543,"12.5","卧铺","2014-05-12",""},  
//	        new Object[]{"G123", "陕西", "甘肃",45,"12.5","硬座","2014-05-5",""},  
//	        new Object[]{"12345", "甘肃" , "吉林",5,"12.5","卧铺","2014-05-8",""},  
//	        new Object[]{"K754" , "吉林", "北京",90,"12.5","卧铺","2014-6-12",""} , 
//	        new Object[]{"K10" , "北京" , "河南",233,"12.5","卧铺","2014-05-12",""},  
//	        new Object[]{"D7888", "河南", "陕西",543,"12.5","卧铺","2014-05-12",""},  
//	        new Object[]{"G123", "陕西", "甘肃",45,"12.5","卧铺","2014-11-12",""},  
//	        new Object[]{"12345", "甘肃" , "吉林",2,"12.5","卧铺","2014-05-12",""},  
//	        
//	    };  
	tick_remain(){
		//Common_Interface ci=new Common_Interface();
		contentPane=this.getContentPane();
		jp=new JPanel();
		jp.setLayout(null);
		add_button();
		add_Label();
		add_table();
		
		contentPane.add(jp, BorderLayout.CENTER);
		contentPane.add(jscrollpane, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	//触发事件
	public void add_button(){
		
		JButton jb=new JButton("确定");
		jb.setFont(new Font("宋体",Font.BOLD, 24));
		jb.setBounds(700, 100, 100, 40);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(from.getSelectedItem().equals(to.getSelectedItem())){
					
					JOptionPane.showMessageDialog(null, "始发站和站点站是同一站，无效！");
					// box1.removeAllItems();
					// box2.removeAllItems();
					return;
				}else{
					
					add_table();
				}
			}
		});
		jp.add(jb);
	}
	public void add_Label(){
		JLabel j1=new JLabel("余票查询");
		
		datelab = new JLabel("日期");
		lablefrom = new JLabel("始发站");
		lableto = new JLabel("终点站");
		from = new JComboBox(city);
		to = new JComboBox(city);
		j1.setFont(new Font("宋体",Font.BOLD, 24));
		
		j1.setBounds(20, 0, 400, 100);
		
		date = new JXDatePicker(nowdate);
		date.setFormats("yyyy年-MM月-dd日");
		date.setLocale(Locale.CHINA);
		
		lablefrom.setFont(new Font("宋体",Font.BOLD, 24));
		lableto.setFont(new Font("宋体",Font.BOLD, 24));
		datelab.setFont(new Font("宋体",Font.BOLD, 24));
		
		datelab.setBounds(170, 30, 80, 40);
		lablefrom.setBounds(320, 30, 80, 40);
		lableto.setBounds(440, 30, 80, 40);
		from.setBounds(320, 100, 80, 40);
		to.setBounds(440, 100, 80, 40);
		date.setBounds(140, 100, 140, 40);
		jp.add(j1);
		
		jp.add(lablefrom);
		jp.add(lableto);
		jp.add(datelab);
		jp.add(from);
		jp.add(to);
		jp.add(date);
		
	}

	public void add_table(){
		
		
		//调用服务器传出站点信息，接收车票信息 Object[][]接收
		//定义二维数组作为表格数据  
	    
	    //定义一维数据作为列标题 
	    Object[] columnTitle = {"列车号" , "出发站" , "终点站","票数","票价","类型","日期","选择"};
	    //jt=new JTable(tableData,columnTitle);
	    jt.getColumnModel().getColumn(7).setCellRenderer(new TableCellRenderer(){
	    	public Component getTableCellRendererComponent(JTable table,
	    			Object value, boolean isSelected, boolean hasFocus,
	    			int row, int column) {
	    	            // 创建用于返回的渲染组件
	    				jcb = new JCheckBox("选择");
	    	            // 使具有焦点的行对应的复选框选中
	    				jcb.setSelected(isSelected);
	    	            // 设置单选box.setSelected(hasFocus);
	    	            // 使复选框在单元格内居中显示
	    	            jcb.setHorizontalAlignment((int) 0.5f);
	    	            return jcb;
	    	       }
	    	});
	    
	    jscrollpane = new JScrollPane(jt);
	}
	
	public static void main(String args[]){
		//new tick_remain();
		
		String from = "北京";
		String to = "南阳";
		String uri = HttpClientUtil.HOST + "/ticket/view/unsold/"+from+"/"+to+"/2014-12-7";
		
		String msg = HttpClientUtil.sendGetRequest(uri, HttpClientUtil.getDefaultHeader());
		
		ArrayList list = new ArrayList();
			int k = 0;
		JSONArray array = JSON.parseArray(msg);
		for(int a = 0; a < array.size(); a++) {
			
			JSONArray subArray = array.getJSONArray(a); //驱车信息
			list.add(subArray.remove(0));
			//System.out.println(subArray.remove(0));	//第一个信息 并删除
			
			System.out.println("111111111111");
//			String trainName = (String) subArray.remove(0);
//			System.out.println(trainName);
			list.add(subArray.remove(0));
			list.add(subArray.remove(0));
//			System.out.println("2222222222222");
//			System.out.println(subArray.remove(0));
			System.out.println();
			for (int i = 0; i < subArray.size(); i++ ){
				JSONArray sub = subArray.getJSONArray(i);
				for(int j = 0 ; j < sub.size(); j++)
					
					
//					System.out.println(sub.get(j));
					list.add(sub.get(j));
			}
			System.out.println();
			//System.out.println("++++++++++++++++"+trainName+"++++++++++++++++"+a);
			
		}
		
		
			
			System.out.println(list);
			
	}
}
