package cn.flower.tick.client.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class tick_operation {

	private static final long serialVersionUID = 1L;
	static final int WIDTH = 600;
	static final int HEIGHT = 400;
	JPopupMenu pop;
	JMenuItem item2;
	JFrame frame;
	JMenuItem item1;
	JPanel pane,pane1,pane2,pane3;
	tablepane tab1,tab2,tab3;

	// JToolBar bar;
	// JPanel p1,p2,p3;
	// tablepane tab1,tab2,tab3;
	// JButton closebutton1,closebutton2,closebutton3;
	// JButton addbutton1,addbutton2,addbutton3;
	// JButton delbutton1,delbutton2,delbutton3;
	// JButton updatebutton1,updatebutton2,updatebutton3;
	// JTabbedPane tabbedPane;

	public tick_operation() {

		frame = new JFrame("火车票售票系统");
		JMenuBar menuBar1 = new JMenuBar();
//		tp1 = new JTabbedPane();
		pane = new JPanel();
		//p1 = new JPanel();
		frame.setContentPane(pane);
		frame.setJMenuBar(menuBar1);
//		f.add(p);
//		p.add(tp);

		// tabbedPane = new JTabbedPane();

		// 创建系统菜单

		JMenu menu1 = new JMenu("购买车票");
		JMenu menu2 = new JMenu("订单管理");
		JMenu menu3 = new JMenu("订单支付");
		JMenu menu4 = new JMenu("用户信息");
		JMenu menu5 = new JMenu("系统信息");

		menu1.setMnemonic('Z');
		menu2.setMnemonic('C');
		menu3.setMnemonic('G');
		menu4.setMnemonic('F');
		menu5.setMnemonic('D');

		menuBar1.add(menu1);
		menuBar1.add(menu2);
		menuBar1.add(menu3);
		menuBar1.add(menu4);
		menuBar1.add(menu5);

		item1 = new JMenuItem("火车票购买");
		item2 = new JMenuItem("余票查询");
		JMenuItem item3 = new JMenuItem("已完成订单");
		JMenuItem item4 = new JMenuItem("未完成订单");
		JMenuItem item5 = new JMenuItem("订单支付");
		JMenuItem item6 = new JMenuItem("用户信息");
		JMenuItem item7 = new JMenuItem("退出登录");
		// JMenuItem item8 = new JMenuItem("同学查询");
		// JMenuItem item9 = new JMenuItem("同时查询");
		// JMenuItem item10 = new JMenuItem("朋友查询");
		JMenuItem item11 = new JMenuItem("版本信息");
		JMenuItem item12 = new JMenuItem("帮助信息");

		item1.setAccelerator(KeyStroke.getKeyStroke('M',
				java.awt.Event.CTRL_MASK, false));
		item2.setAccelerator(KeyStroke.getKeyStroke('F',
				java.awt.Event.CTRL_MASK, false));
		item3.setAccelerator(KeyStroke.getKeyStroke('R',
				java.awt.Event.CTRL_MASK, false));
		item4.setAccelerator(KeyStroke.getKeyStroke('C',
				java.awt.Event.CTRL_MASK, false));

		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		

		menu2.add(item3);
		menu2.addSeparator();
		menu2.add(item4);

		menu3.add(item5);
		// menu3.addSeparator();
		// menu3.add(item7);

		menu4.add(item6);
		menu4.addSeparator();
		menu4.add(item7);
		// menu4.addSeparator();
		// menu4.add(item10);

		menu5.add(item11);
		menu5.addSeparator();
		menu5.add(item12);

		// JButton button1 = new JButton("同学查询");
		// JButton button2 = new JButton("同事查询");
		// JButton button3 = new JButton("朋友查询");
		//
		// closebutton1 = new JButton("关闭");
		// closebutton2 = new JButton("关闭");
		// closebutton3 = new JButton("关闭");
		//
		// addbutton1 = new JButton("添加同学信息");
		// addbutton2 = new JButton("添加同事信息");
		// addbutton3 = new JButton("添加朋友信息");
		//
		// delbutton1 = new JButton("删除学生信息");
		// delbutton2 = new JButton("删除同事信息");
		// delbutton3 = new JButton("删除朋友信息");
		//
		// updatebutton1 = new JButton("更新学生信息");
		// updatebutton2 = new JButton("更新同事信息");
		// updatebutton3 = new JButton("更新朋友信息");

		// 将功能按钮组件添加到容器

		// p1 = new JPanel();
		// p2 = new JPanel();
		// p3 = new JPanel();

		// p1.setLayout(new FlowLayout());

		// p1.add(closebutton1);
		// p1.add(addbutton1);
		// p1.add(updatebutton1);
		//
		// p1.add(closebutton1);
		// p1.add(addbutton1);
		// p1.add(updatebutton1);
		//
		// p2.add(closebutton2);
		// p2.add(addbutton2);
		// p2.add(delbutton2);
		// p2.add(updatebutton2);
		//
		// p3.add(closebutton3);
		// p3.add(addbutton3);
		// p3.add(delbutton3);
		// p3.add(updatebutton3);
		//
		// bar = new JToolBar();
		// bar.add(button1);
		// bar.add(button2);
		// bar.add(button3);

//		p1 = new JPanel();
//		p1.setLayout(new FlowLayout());
		BorderLayout bord = new BorderLayout();

		// f.add(p);
		// p.add(tabbedPane);
		pane.setLayout(bord);
		// p.add("North", bar);

		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int with = screenSize.width;
		int height = screenSize.height;
		int x = (with - WIDTH) / 2;
		int y = (height - HEIGHT) / 2;
		frame.setLocation(x, y);
		// 购买火车票
		item1.addActionListener(new ActionListener() {// 购买火车票

			@Override
			public void actionPerformed(ActionEvent e) {

//				tick_list list = new tick_list();
//				tp.addTab("list", list);
//				tp.setTitleAt(0, "购买火车票");
//				tp.setEnabledAt(0, true);
//				tp.setPreferredSize(new Dimension(500, 200));
//				tp.setTabPlacement(JTabbedPane.TOP);
//				tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
				tab1 = new tablepane();
				pane.add("Center",tab1);
				tab1.pane1.add(new TicketList());
				tablepane.tp.setVisible(true);
				pane1.setVisible(true);
			}
		});

		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new tick_remain();
			}
		});

		// 订单管理

		item3.addActionListener(new ActionListener() {// 已完成订单

			@Override
			public void actionPerformed(ActionEvent e) {

				new QueryOrder();
			}
		});

		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new No_finsh_order();
			}
		});

		// 支付火车票

		item5.addActionListener(new ActionListener() {// 支付未完成的订单

			@Override
			public void actionPerformed(ActionEvent e) {

				new No_finsh_order();
			}
		});

		// 用户信息

		item6.addActionListener(new ActionListener() {// 用户信息

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		item7.addActionListener(new ActionListener() {// 退出

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = JOptionPane.showConfirmDialog(null, "是否真的需要退出系统",
						"确认退出对话框", JOptionPane.YES_NO_CANCEL_OPTION);
				if (i == 0)
					frame.dispose();
			}
		});

		// 系统信息
		item11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new tick_version();
//				tick_version version = new tick_version();
//				tablepane.addTab("version", version);
//				tp.setTitleAt(1, "系统版本信息");
//				tp.setEnabledAt(1, true);
//				tp1.setPreferredSize(new Dimension(500, 200));
//				tp1.setTabPlacement(JTabbedPane.TOP);
//				tp1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

			}
		});

		item12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new tick_help();
			}
		});
	}

	public static void main(String[] args) {

		new tick_operation();
	}
}
