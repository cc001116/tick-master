package cn.flower.tick.client.ui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;





public class QueryOrder extends JFrame{

	/*public QueryOrder(){
		
	
	
//	public QueryOrder(String tick_id,String tick_from,String tick_to,String tick_no,String tick_type,
//			String tick_room,String tick_seat,String tick_price,String tick_date){
		
		//定义表头
		Vector<String> tableName = new Vector<String>();
		tableName.add("订单号");
		tableName.add("始发地");
		tableName.add("终点站");
		tableName.add("车次");
		tableName.add("类型");
		tableName.add("车厢");
		tableName.add("座号");
		tableName.add("价格");
		tableName.add("日期");
		tableName.add("选着");
		Vector<Vector<String>> tabledata =  new Vector<Vector<String>>();
		Vector<String> tableelemt = new Vector<>();
//		tableelemt.add(tick_id);
//		tableelemt.add(tick_from);
//		tableelemt.add(tick_to);
//		tableelemt.add(tick_no);
//		tableelemt.add(tick_type);
//		tableelemt.add(tick_room);
//		tableelemt.add(tick_seat);
//		tableelemt.add(tick_price);
//		tableelemt.add(tick_date);
//		tabledata.add(tableelemt);
		for(int i = 0; i < 5 ;i++){
		tableelemt.add("1"+i);
		tableelemt.add("1"+i);
		tableelemt.add("1"+i);
		tableelemt.add("1"+i);
		tableelemt.add("1"+i);
		tableelemt.add("1"+i);
		tableelemt.add("1"+i);
		tableelemt.add("1"+i);
		tableelemt.add("1"+i);
		tabledata.add(tableelemt);
		}
		
		
		//创建表格模型
		
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.setDataVector(tabledata, tableName);
		
		
		//创建表格
		
		JTable table = new JTable(tableModel);
		table.setRowHeight(20);//设置行高
		table.setGridColor(Color.RED);
		table.setSelectionBackground(Color.green);
		JScrollPane pane = new JScrollPane(table);
		this.add(pane);
		
		//主窗体
		this.setTitle("订单查询");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenWitgh = screenSize.width/2;
		int screenHeigh = screenSize.height/2;
		int height = this.getHeight();
		int widgh = this.getWidth();
		this.setLocation(screenWitgh - widgh/2, screenHeigh - height/2);
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new QueryOrder();
	}*/
	private JPanel jp;
	JScrollPane jscrollpane;
	Container contentPane;
	JCheckBox jcb;
	JTable jt=null;
	JRadioButton jrb1=null;
	JRadioButton jrb2=null;
	JRadioButton jrb3=null;
	Object[][] tableData =   
	    {  
	        new Object[]{"123","K10" , "北京" , "河南",233,34,"12.5","卧铺","2014-05-12",""},  
	        new Object[]{"123","D7888", "河南", "陕西",543,54,"12.5","卧铺","2014-05-12",""},  
	        new Object[]{"123","G123", "陕西", "甘肃",45,65,"12.5","卧铺","2014-05-12",""},  
	        new Object[]{"65","12345", "甘肃" , "吉林",1,6,"12.5","卧铺","2014-05-12",""},  
	        new Object[]{"123","K754" , "吉林", "北京",90,7,"12.5","卧铺","2014-05-12",""}  ,
	        new Object[]{"123","K10" , "北京" , "河南",233,34,"12.5","卧铺","2014-05-12",""},  
	        new Object[]{"123","D7888", "河南", "陕西",543,54,"12.5","卧铺","2014-05-12",""},  
	        new Object[]{"123","G123", "陕西", "甘肃",45,65,"12.5","硬座","2014-05-5",""},  
	        new Object[]{"85","12345", "甘肃" , "吉林",5,6,"12.5","卧铺","2014-05-8",""},  
	        new Object[]{"25","K754" , "吉林", "北京",90,7,"12.5","卧铺","2014-6-12",""} , 
	        new Object[]{"123","K10" , "北京" , "河南",233,34,"12.5","卧铺","2014-05-12",""},  
	        new Object[]{"123","D7888", "河南", "陕西",543,54,"12.5","卧铺","2014-05-12",""},  
	        new Object[]{"123","G123", "陕西", "甘肃",45,65,"12.5","卧铺","2014-11-12",""},  
	        new Object[]{"123","12345", "甘肃" , "吉林",2,6,"12.5","卧铺","2014-05-12",""},  
	        
	    };  
	QueryOrder(){
		//Common_Interface ci=new Common_Interface();
		contentPane=this.getContentPane();
		jp=new JPanel();
		jp.setLayout(null);
		add_button();
		add_Label();
		add_JRadioButton();
		add_table();
		contentPane.add(jp, BorderLayout.CENTER);
		contentPane.add(jscrollpane, BorderLayout.SOUTH);
		this.setTitle("订单管理");
		this.setSize(1000, 700);// 设置框架大小为长300,宽200
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		int height = this.getHeight();
		int width = this.getWidth();
		this.setLocation(screenWidth - width / 2, screenHeight - height / 2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置关闭框架的同时结束程序
		
		this.setResizable(false);// 设置框架不可以改变大小
		
		
		this.setVisible(true);
	}
	public void add_button(){
		
		JButton jb=new JButton("确定");
		jb.setFont(new Font("宋体",Font.BOLD, 24));
		jb.setBounds(700, 100, 100, 50);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int flag=-1;
				if(jcb.isSelected()){
					//订票信息传入数据库？？？？？？？？？？？？？？？？？
					if(jrb1.isSelected()){
						//Book_Ticket_Interface.this.dispose();
						flag=JOptionPane.showConfirmDialog(null, "删除订单："+String.valueOf(tableData[jt.getSelectedRow()][0]));
						//new Order_admin_Interface();
						if(flag==0) {
							//Book_Ticket_Interface.this.dispose();
							//new Order_admin_Interface();
							System.out.println("删除订单");
							//???????????????修改数据库相关属性
						}
					}
					else if(jrb2.isSelected()){
						
						//Book_Ticket_Interface.this.dispose();
						flag=JOptionPane.showConfirmDialog(null, "退票："+String.valueOf(tableData[jt.getSelectedRow()][0]));
						//new Order_admin_Interface();
						if(flag==0) {
							//Book_Ticket_Interface.this.dispose();
							//new Order_admin_Interface();
							System.out.println("退票");
							//???????????????修改数据库相关属性
						}
					}
					else if(jrb3.isSelected()){
						
						//Book_Ticket_Interface.this.dispose();
						flag=JOptionPane.showConfirmDialog(null, "改签："+String.valueOf(tableData[jt.getSelectedRow()][0]));
						//new Order_admin_Interface();
						if(flag==0) {
							//Book_Ticket_Interface.this.dispose();
							//new Order_admin_Interface();
							System.out.println("改签");
							//???????????????修改数据库相关属性
						}
					}

					QueryOrder.this.dispose();
					new QueryOrder();
					
				}
				else if(!jcb.isSelected()||flag==-1){
					QueryOrder.this.dispose();
					//new Order_admin_Interface();
				}
			}
		});
		jp.add(jb);
	}
	public void add_Label(){
		JLabel j1=new JLabel("我的订单");
		JLabel j2=new JLabel("已完成订单:");
		j1.setFont(new Font("宋体",Font.BOLD, 24));
		j2.setFont(new Font("宋体",Font.BOLD, 24));
		j1.setBounds(20, 10, 400, 100);
		j2.setBounds(20, 100, 200, 100);
		jp.add(j1);
		jp.add(j2);
		
	}
	public void add_JRadioButton(){
		jrb1=new JRadioButton("删除");
		jrb2=new JRadioButton("退票");
		jrb3=new JRadioButton("改签");
		jrb1.setFont(new Font("宋体",Font.BOLD, 20));
		jrb2.setFont(new Font("宋体",Font.BOLD, 20));
		jrb3.setFont(new Font("宋体",Font.BOLD, 20));
		jrb1.setBounds(400, 100, 80, 50);
		jrb2.setBounds(500, 100, 80, 50);
		jrb3.setBounds(600, 100, 80, 50);
		ButtonGroup bg=new ButtonGroup();
		
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		jp.add(jrb1);
		jp.add(jrb2);
		jp.add(jrb3);
	}
	public void add_table(){
		
		
		//调用服务器传出站点信息，接收车票信息 Object[][]接收？？？？？？？？？？？？？？？？？？
		//定义二维数组作为表格数据  
	    
	    //定义一维数据作为列标题 
	    Object[] columnTitle = {"订单号","列车号" , "出发站" , "终点站","车厢号","座位号","票价","类型","日期","选择"};
	    jt=new JTable(tableData,columnTitle);
	    jt.getColumnModel().getColumn(9).setCellRenderer(new TableCellRenderer(){
	    	public Component getTableCellRendererComponent(JTable table,
	    			Object value, boolean isSelected, boolean hasFocus,
	    			int row, int column) {
	    	            // 创建用于返回的渲染组件
	    				jcb = new JCheckBox("删除");
	    	            // 使具有焦点的行对应的复选框选中
	    				jcb.setSelected(isSelected);
	    	            // 设置单选box.setSelected(hasFocus);
	    	            // 使复选框在单元格内居中显示
	    	            jcb.setHorizontalAlignment((int) 0.5f);
	    	            return jcb;
	    	       }
	    	});
	    //jt.setEnabled(false);
	    jscrollpane=new JScrollPane(jt);
	}

	public static void main(String args[]){
		
		new QueryOrder();
	}
}
