package cn.flower.tick.client.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class tick_help {

	static final int WIDTH = 800;
	static final int HEIGTH = 600;
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode node1;
	DefaultMutableTreeNode node2;
	DefaultMutableTreeNode node3;
	DefaultMutableTreeNode node4;
	static JTextArea text;
	
	public tick_help(){
		
		JFrame frame = new JFrame();
		frame.setTitle("火车票购票系统帮助文档");
		frame.setSize(WIDTH, HEIGTH);
		root = new DefaultMutableTreeNode("火车票购票系统帮助文档");
		node1 = new DefaultMutableTreeNode("如何注册用户");
		node2 = new DefaultMutableTreeNode("如何购买火车票");
		node3 = new DefaultMutableTreeNode("如何操作车票订单");
		node4 = new DefaultMutableTreeNode("如何支付火车牌");
		
		root.add(node1);
		root.add(node2);
		root.add(node3);
		root.add(node4);
		
		DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("如何购买火车票");
		node2.add(leafnode);
		
		DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("如何支付订单");
		node3.add(node31);
		DefaultMutableTreeNode node32 = new DefaultMutableTreeNode("如何删除订单");
		node3.add(node32);
		
		tree = new JTree(root);
		JScrollPane scrollPane = new JScrollPane(tree);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		splitPane.setPreferredSize(new Dimension(100,200));
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(panel1);
		splitPane.setRightComponent(panel2);
		splitPane.setDividerSize(3);
		splitPane.setDividerLocation(200);
		frame.setContentPane(splitPane);
		panel1.add(scrollPane);
		frame.setVisible(true);
		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
		int screenWidth = screenSize.width / 2; // 获取屏幕的宽
		int screenHeight = screenSize.height / 2; // 获取屏幕的高
		int height = frame.getHeight();
		int width = frame.getWidth();
		frame.setLocation(screenWidth - width / 2, screenHeight - height / 2);
		
		tree.addMouseListener(new MouseHandele());
		text = new JTextArea();
		panel2.add(text);
	}
	
	class MouseHandele extends MouseAdapter{
		
		public void mousePressed(MouseEvent e) {
			
			String nodename;
			try {
				
				JTree tree = (JTree)e.getSource();
				int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
				TreePath treePath = tree.getPathForRow(rowLocation);
				TreeNode treeNode = (TreeNode) treePath.getLastPathComponent();
				nodename = treeNode.toString();
				tick_help.text.setText("要想查询如何使用"+nodename+"模块相关知识，请查阅光盘");
				 
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}
}
