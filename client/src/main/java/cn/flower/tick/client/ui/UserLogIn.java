package cn.flower.tick.client.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
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
import cn.flower.tick.client.util.JsonUtil;
import cn.flower.tick.client.util.PropertiesUtil;

public class UserLogIn extends JFrame {
	public JPanel pnluser;
	public JLabel lbluserLogIn;
	public JLabel lbluserName;
	public JLabel lbluserPWD;
	public JTextField txtName;
	public JPasswordField pwdPwd;
	public JButton btnSub;
	public JButton btnReset;

	public UserLogIn() {
		ImageIcon image = new ImageIcon("image/login.png");
		pnluser = new JPanel();
		lbluserLogIn = new JLabel(image);
		lbluserName = new JLabel();
		lbluserPWD = new JLabel();
		txtName = new JTextField();
		pwdPwd = new JPasswordField();
		btnSub = new JButton();
		btnReset = new JButton();
		userInit();
	}

	public void userInit() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭框架的同时结束程序
		this.setSize(600, 400);// 设置框架大小为长300,宽200
		this.setResizable(false);// 设置框架不可以改变大小
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		int height = this.getHeight();
		int width = this.getWidth();
		this.setLocation(screenWidth - width / 2, screenHeight - height / 2);
		this.setTitle("用户登录");// 设置框架标题
		this.pnluser.setLayout(null);// 设置面板布局管理
		// this.pnluser.setBackground(Color.cyan);// 设置面板背景颜色

		this.lbluserLogIn.setText("用户登录");// 设置标签标题
		this.lbluserLogIn.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 14));// 设置标签字体
		this.lbluserLogIn.setForeground(Color.RED);// 设置标签字体颜色
		this.lbluserName.setText("用户名:");
		this.lbluserPWD.setText("密    码:");
		this.btnSub.setText("登录");
		this.btnReset.setText("注册");
		this.lbluserLogIn.setBounds(0, 0, 980, 100);// 设置标签x坐标120,y坐标15,长60,宽20
		this.lbluserName.setBounds(170, 145, 60, 20);
		this.lbluserPWD.setBounds(170, 175, 60, 25);
		this.txtName.setBounds(250, 145, 120, 20);
		this.pwdPwd.setBounds(250, 175, 120, 20);
		this.btnSub.setBounds(245, 210, 60, 20);
		this.btnSub.addActionListener(new ActionListener()// 匿名类实现ActionListener接口
				{
					public void actionPerformed(ActionEvent e) {
						btnsub_ActionEvent(e);
					}
				});
		this.btnReset.setBounds(315, 210, 60, 20);
		this.btnReset.addActionListener(new ActionListener()// 匿名类实现ActionListener接口
				{
					public void actionPerformed(ActionEvent e) {
						btnreset_ActionEvent(e);
					}
				});
		this.pnluser.add(lbluserLogIn);// 加载标签到面板
		this.pnluser.add(lbluserName);
		this.pnluser.add(lbluserPWD);
		this.pnluser.add(txtName);
		this.pnluser.add(pwdPwd);
		this.pnluser.add(btnSub);
		this.pnluser.add(btnReset);
		this.add(pnluser);// 加载面板到框架
		this.setVisible(true);// 设置框架可显
	}

	public void btnsub_ActionEvent(ActionEvent e) {

		final String name = txtName.getText().trim();
		final String pwd = String.valueOf(pwdPwd.getPassword()).trim();

		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "账号不能为空", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				String uri = HttpClientUtil.HOST + "/user/login/" + name;
				Map<String, String> map = new HashMap<String, String>();
				map.put("password", pwd);
				String msg = HttpClientUtil.sendPostRequest(uri, map, null);

				long currentTime = System.currentTimeMillis();

				String js = JsonUtil.getValue(msg, "JSESSIONID");
				PropertiesUtil.storePropertiesFile(js,
						String.valueOf(currentTime), name);
				if (msg.contains("success")) {
					UserLogIn.this.dispose();
					new tick_operation();
				} else {
					JOptionPane.showMessageDialog(null, "账号或密码错误", "错误",
							JOptionPane.ERROR_MESSAGE);

					pwdPwd.setText("");
					return;
				}
			}
		}).start();

	}

	public void btnreset_ActionEvent(ActionEvent e) {
		new Register();
		dispose();
	}

	public static void main(String[] args) {

		new UserLogIn();
	}

}