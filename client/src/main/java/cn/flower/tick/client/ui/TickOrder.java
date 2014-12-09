package cn.flower.tick.client.ui;



import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.jdbc.odbc.OdbcDef;

public class TickOrder extends JFrame{

	private JPanel panel;
	private JLabel jLabel;
	private JButton finsh_bt,order_bt,nofinsh_bt;
	
	public TickOrder() {
	
		panel = new JPanel();
		jLabel = new JLabel("订单管理");
		finsh_bt = new JButton("已完成订单");
		nofinsh_bt = new JButton("未完成订单");
		order_bt = new JButton("继续购票");
		TickOrderInit();
	}
	
	public void TickOrderInit(){
		
		this.setTitle("订单管理");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int screenWitgh = screenSize.width/2;
		int screenHeigh = screenSize.height/2;
		int height = this.getHeight();
		int widgh = this.getWidth();
		this.setLocation(screenWitgh - widgh/2, screenHeigh - height/2);
		this.panel.setLayout(null);
		this.jLabel.setBounds(200, 0, 100, 30);
		jLabel.setFont(new Font("宋体", Font.BOLD, 24));
		this.finsh_bt.setBounds(180, 100, 150, 30);
		finsh_bt.setFont(new Font("宋体", Font.BOLD, 20));
		finsh_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				finish_order();
			}
		});
		
		this.nofinsh_bt.setBounds(180, 160, 150, 30);
		nofinsh_bt.setFont(new Font("宋体", Font.BOLD, 20));
		
		nofinsh_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				no_finsh();
			}
		});
		
		this.order_bt.setBounds(180, 220, 150, 30);
		order_bt.setFont(new Font("宋体", Font.BOLD, 20));
		order_bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {//继续购票
				
				order_act();
			}
		});
		
		
		panel.add(jLabel);
		panel.add(finsh_bt);
		panel.add(nofinsh_bt);
		panel.add(order_bt);
		this.add(panel);
		this.setVisible(true);
	}
	
	public void finish_order(){
		
		dispose();
		new QueryOrder();
	}
	
	public void no_finsh(){
		dispose();
		new No_finsh_order();
	}
	
	public void order_act(){
		
		dispose();
		new TicketList();
	}
	
	public static void main(String []args){
		
		new TickOrder();
		System.out.print("test");
	}

}
