package cn.flower.tick.client.ui;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jdesktop.swingx.JXDatePicker;



public class TicketList extends JFrame{
	
	private static final Date Component = null;
	private JLabel label1,label2,label3;
	private JComboBox box1,box2;
	private JPanel jPanel;
	private JButton button1,button2;
	private String city[] = {"北京","上海","河南","广州","河北","武汉"};
	JXDatePicker date;
	Date nowdate = new Date();
	
	public TicketList(){
	
		label1 = new JLabel("选择起始地");
		label2 = new JLabel("选择目的地");
		label3 = new JLabel("选择日期");
		button1 = new JButton("确定");
		button2 = new JButton("取消");
		box1 = new JComboBox(city);
		box2 = new JComboBox(city);
		jPanel = new JPanel();
		ListInit();
	}
	
	public void ListInit(){
		this.setTitle("车票预定");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置关闭框架的同时结束程序
		this.setSize(500, 400);// 设置框架大小为长300,宽200
		this.setResizable(false);// 设置框架不可以改变大小
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		int height = this.getHeight();
		int width = this.getWidth();
		this.setLocation(screenWidth - width / 2, screenHeight - height / 2);
		this.jPanel.setLayout(null);// 设置面板布局管理
		this.label1.setBounds(100, 105, 150, 30);
		this.label2.setBounds(100, 145, 150, 30);
		this.box1.setBounds(220, 105, 85, 30);
		this.box2.setBounds(220, 145, 85, 30);
		this.button1.setBounds(200, 195, 60, 20);
		date = new JXDatePicker(nowdate);
		date.setFormats("yyyy年-MM月-dd日");
		date.setLocale(Locale.CHINA);
		
		this.date.setBounds(5,40,150,30);
		
		
		this.label3.setBounds(0, 0, 100, 30);
		label3.setFont(new Font("宋体", Font.BOLD, 22));
		label1.setFont(new Font("宋体", Font.BOLD, 20));
		label2.setFont(new Font("宋体", Font.BOLD, 20));
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				button1_act();
				
			}
		});
		this.button2.setBounds(265, 195, 60, 20);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//button2_act();
			}
		});
		jPanel.add(label1);
		jPanel.add(label2);
		jPanel.add(label3);
		jPanel.add(box1);
		jPanel.add(box2);
		jPanel.add(button1);
		jPanel.add(button2);
		jPanel.add(date);
		this.add(jPanel);
		this.setVisible(true);
	}

	public void button1_act(){
		
		if(box1.getSelectedItem().equals(box2.getSelectedItem())){
			JOptionPane.showMessageDialog(null, "始发站和站点站是同一站，无效！");
//			box1.removeAllItems();
//			box2.removeAllItems();
			return;
		}else{
			
			dispose();
			String tick_id = null;
			String tick_from = (String) box1.getSelectedItem();
			String tick_to = (String) box2.getSelectedItem();
			String tick_no = null;
			String tick_type = null;
			String tick_room = null;
			String tick_seat = null;
			String tick_price = null;
			String tick_date = null;
			
//			new QueryOrder(tick_id, tick_from, tick_to, tick_no, tick_type, 
//					tick_room, tick_seat, tick_price, tick_date);
			new TickOrder();
		}
		
	}
	
	public static void main(String []args){
		
		new TicketList();
		
	}

	
}
