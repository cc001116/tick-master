package cn.flower.tick.client.ui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.http.Header;

import cn.flower.tick.client.util.HttpClientUtil;

public class add_passenger{
	public JPanel pnluser;
	public JLabel lbluserLogIn;
	public JLabel lbluserName;
	public JLabel lbluserid,lbluserphone;
	public JTextField txtName,textid,textphone;
	
	public JButton btnSub,btnback;
	JFrame frame = new JFrame();
	
	

	public add_passenger() {
		ImageIcon image = new ImageIcon("image/re.png");
		pnluser = new JPanel();
		lbluserLogIn = new JLabel(image);
		lbluserName = new JLabel();
		lbluserid = new JLabel();
		lbluserphone = new JLabel();
		txtName = new JTextField();
		textid = new JTextField();
		textphone = new JTextField();
		btnSub = new JButton();
		btnback = new JButton();
		
		userInit();
	}

	public void userInit() {
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭框架的同时结束程序
		frame.setSize(500, 350);// 设置框架大小为长300,宽200
		frame.setResizable(false);// 设置框架不可以改变大小
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		int height = frame.getHeight();
		int width = frame.getWidth();
		frame.setLocation(screenWidth - width / 2, screenHeight - height / 2);
		frame.setTitle("添加乘客信息");// 设置框架标题
		this.pnluser.setLayout(null);// 设置面板布局管理
		//this.pnluser.setBackground(Color.GRAY);// 设置面板背景颜色
		
		
		
		this.lbluserName.setText("乘 客:");
		this.lbluserid.setText("编 号:");
		this.lbluserphone.setText("电 话:");
		this.btnSub.setText("添加");
		this.btnback.setText("取消");
		
		this.lbluserLogIn.setBounds(0, 0, 500, 100);// 设置标签x坐标120,y坐标15,长60,宽20
		this.lbluserName.setBounds(140, 115, 60, 20);
		this.lbluserid.setBounds(140, 145, 60, 20);
		this.lbluserphone.setBounds(140, 175, 60, 20);
		this.txtName.setBounds(200, 115, 120, 20);
		this.textid.setBounds(200, 145, 120, 20);
		this.textphone.setBounds(200, 175, 120, 20);
		this.btnSub.setBounds(195, 210, 60, 20);
		this.btnSub.addActionListener(new ActionListener()// 匿名类实现ActionListener接口
				{
					public void actionPerformed(ActionEvent e) {
						btnsub_ActionEvent(e);
					}
				});
		this.btnback.setBounds(265, 210, 60, 20);
		this.btnback.addActionListener(new ActionListener()// 匿名类实现ActionListener接口
		{
			public void actionPerformed(ActionEvent e) {
				btnback_ActionEvent(e);
			}
		});
		
		this.pnluser.add(lbluserLogIn);// 加载标签到面板
		this.pnluser.add(lbluserName);
		this.pnluser.add(lbluserid);
		this.pnluser.add(lbluserphone);
		this.pnluser.add(txtName);
		this.pnluser.add(textid);
		this.pnluser.add(textphone);
		this.pnluser.add(btnSub);
		this.pnluser.add(btnback);
		
		frame.add(pnluser);// 加载面板到框架
		frame.setVisible(true);// 设置框架可显
	}

	public void btnsub_ActionEvent(ActionEvent e) {
		
		
		String name = txtName.getText().trim();
		String id = textid.getText().trim();
		String phone = textphone.getText().trim();
		
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "姓名不能为空", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "编号不能为空", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}else if (phone.length() < 11 || phone.length() > 11) {
			 
			JOptionPane.showMessageDialog(null, "电话输入不正确", "电话输入不正确",
					JOptionPane.INFORMATION_MESSAGE);
			textphone.setText("");
			
		} else {
			JOptionPane.showMessageDialog(null, "添加乘客成功", "添加乘客成功",
					JOptionPane.INFORMATION_MESSAGE);
			String url = HttpClientUtil.HOST + "/passenger/save";
			Map<String, String> params = new HashMap<String, String>();
			params.put("name", name);
			params.put("idCard", id);
			params.put("phone", phone);
			
			Header header = HttpClientUtil.getDefaultHeader();
			String msg = HttpClientUtil.sendPostRequest(url, params, header);
			System.out.println(msg);
			txtName.setText("");
			textid.setText("");
			textphone.setText("");
		}
		
		
	}
	
	public void btnback_ActionEvent(ActionEvent e1){
		
		frame.setVisible(false);
	}
	
	public static void main(String []args){
		
		new add_passenger();
	}

}
