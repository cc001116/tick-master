package cn.flower.tick.client.ui;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;



public class No_finsh_order extends Common_Interface{

	private JPanel jp;
	JScrollPane jscrollpane;
	Container contentPane;
	JCheckBox jcb;
	JTable jt=null;
	JRadioButton jrb1=null;
	JRadioButton jrb2=null;
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
	No_finsh_order(){
		//Common_Interface ci=new Common_Interface();
		contentPane=this.getContentPane();
		jp=new JPanel(){
			 protected void paintComponent(Graphics g)
			 {
				 
				g.drawImage(new ImageIcon("E:\\image\\3.jpg").getImage(),  0, 0, this);
				//super.paintComponents(g);
			 } 
		};
		jp.setLayout(null);
		add_button();
		add_Label();
		add_JRadioButton();
		add_table();
		contentPane.add(jp, BorderLayout.CENTER);
		contentPane.add(jscrollpane, BorderLayout.SOUTH);
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
						flag=JOptionPane.showConfirmDialog(null, "支付："+String.valueOf(tableData[jt.getSelectedRow()][0]));
						//new Order_admin_Interface();
						if(flag==0) {
							//Book_Ticket_Interface.this.dispose();
							//new Order_admin_Interface();
							System.out.println("支付");
							//???????????????修改数据库相关属性
						}
					}
					
					No_finsh_order.this.dispose();
					new No_finsh_order();
				}
				else if(!jcb.isSelected()||flag==-1){
					No_finsh_order.this.dispose();
					//new Order_admin_Interface();
				}
			}
		});
		jp.add(jb);
	}
	public void add_Label(){
		JLabel j1=new JLabel("我的订单");
		JLabel j2=new JLabel("未完成订单:");
		j1.setFont(new Font("宋体",Font.BOLD, 24));
		j2.setFont(new Font("宋体",Font.BOLD, 24));
		j1.setBounds(20, 10, 400, 100);
		j2.setBounds(20, 100, 200, 100);
		jp.add(j1);
		jp.add(j2);
		
	}
	public void add_JRadioButton(){
		jrb1=new JRadioButton("删除");
		jrb2=new JRadioButton("支付");
		jrb1.setFont(new Font("宋体",Font.BOLD, 20));
		jrb2.setFont(new Font("宋体",Font.BOLD, 20));
		jrb1.setBounds(400, 100, 80, 50);
		jrb2.setBounds(500, 100, 80, 50);
		ButtonGroup bg=new ButtonGroup();
		
		bg.add(jrb1);
		bg.add(jrb2);
		jp.add(jrb1);
		jp.add(jrb2);
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
	    				jcb = new JCheckBox("选择");
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
		new No_finsh_order();
	}
}
