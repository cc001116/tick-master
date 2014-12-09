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

import cn.flower.tick.client.util.HttpClientUtil;

public class Register extends JFrame{
	public JPanel pnluser;
	public JLabel lbluserLogIn;
	public JLabel lbluserName;
	public JLabel lbluserPWD,lbluserPWD2;
	public JTextField txtName;
	public JPasswordField pwdPwd,pwdPwd2;
	public JButton btnSub,btnback;
	
	

	public Register() {
		ImageIcon image = new ImageIcon("image/re.png");
		pnluser = new JPanel();
		lbluserLogIn = new JLabel(image);
		lbluserName = new JLabel();
		lbluserPWD = new JLabel();
		lbluserPWD2 = new JLabel();
		txtName = new JTextField();
		pwdPwd = new JPasswordField();
		pwdPwd2 = new JPasswordField();
		btnSub = new JButton();
		btnback = new JButton();
		
		userInit();
	}

	public void userInit() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭框架的同时结束程序
		this.setSize(500, 350);// 设置框架大小为长300,宽200
		this.setResizable(false);// 设置框架不可以改变大小
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		int height = this.getHeight();
		int width = this.getWidth();
		this.setLocation(screenWidth - width / 2, screenHeight - height / 2);
		this.setTitle("用户注册");// 设置框架标题
		this.pnluser.setLayout(null);// 设置面板布局管理
		//this.pnluser.setBackground(Color.GRAY);// 设置面板背景颜色
		
		
		
		this.lbluserName.setText("用户名:");
		this.lbluserPWD.setText("密    码:");
		this.lbluserPWD2.setText("确认密码:");
		this.btnSub.setText("注册");
		this.btnback.setText("返回");
		
		this.lbluserLogIn.setBounds(0, 0, 500, 100);// 设置标签x坐标120,y坐标15,长60,宽20
		this.lbluserName.setBounds(140, 115, 60, 20);
		this.lbluserPWD.setBounds(140, 145, 60, 20);
		this.lbluserPWD2.setBounds(140, 175, 60, 20);
		this.txtName.setBounds(200, 115, 120, 20);
		this.pwdPwd.setBounds(200, 145, 120, 20);
		this.pwdPwd2.setBounds(200, 175, 120, 20);
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
		this.pnluser.add(lbluserPWD);
		this.pnluser.add(lbluserPWD2);
		this.pnluser.add(txtName);
		this.pnluser.add(pwdPwd);
		this.pnluser.add(pwdPwd2);
		this.pnluser.add(btnSub);
		this.pnluser.add(btnback);
		
		this.add(pnluser);// 加载面板到框架
		this.setVisible(true);// 设置框架可显
	}

	public void btnsub_ActionEvent(ActionEvent e) {
		
		
		String name = txtName.getText().trim();
		String pwd = String.valueOf(pwdPwd.getPassword()).trim();
		String pwd2 = String.valueOf(pwdPwd2.getPassword()).trim();
		
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "账号不能为空", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		 if (pwd.equals(pwd2)) {
			 
			JOptionPane.showMessageDialog(null, "註冊成功", "註冊成功",
					JOptionPane.INFORMATION_MESSAGE);
			String uri = HttpClientUtil.HOST + "/user/register";
			Map<String, String> map = new HashMap<String, String>();
			map.put("username", name);
			map.put("password", pwd);
			String msg = HttpClientUtil.sendPostRequest(uri, map, null);
			
		} else {
			JOptionPane.showMessageDialog(null, "兩次密碼輸入不一樣", "错误",
					JOptionPane.ERROR_MESSAGE);
			//txtName.setText("");
			pwdPwd.setText("");
			pwdPwd2.setText("");
			return;
		}
		
		
	}
	
	public void btnback_ActionEvent(ActionEvent e1){
		
		UserLogIn login = new UserLogIn();
		login.setVisible(true);
		this.setVisible(false);
	}

}
