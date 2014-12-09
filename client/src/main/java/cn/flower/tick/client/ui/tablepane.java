package cn.flower.tick.client.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class tablepane extends JPanel {

	private static final long serialVersionUID = 1L;
	JPanel pane1;
	static JPanel pane2,pane3,pane4,pane5;
	static JTabbedPane tp;
	
	public tablepane(){
		
		setLayout(new BorderLayout());
		tp = new JTabbedPane();
		pane1 = new JPanel();
		pane2 = new JPanel();
		pane3 = new JPanel();
		pane4 = new JPanel();
		pane5 = new JPanel();
		
		pane1.setLayout(new BorderLayout());
		tp.addTab("pane1",pane1);
		tp.setEnabledAt(0, true);
		tp.setTitleAt(0, "基本信息");
		
		tp.addTab("pane2",pane2);
		tp.setEnabledAt(1, true);
		tp.setTitleAt(1, "照片");
		
		tp.addTab("pane3",pane3);
		tp.setEnabledAt(2, true);
		tp.setTitleAt(2, "兴趣爱好");
		
		tp.addTab("pane4", pane4);
		tp.setEnabledAt(3, true);
		tp.setTitleAt(3, "日常习惯");
		
		tp.addTab("pane5", pane5);
		tp.setEnabledAt(4, true);
		tp.setTitleAt(4, "评价");
		
		tp.setPreferredSize(new Dimension(500,200));
		tp.setTabPlacement(JTabbedPane.TOP);
		tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		add("Center",tp);
		tp.setVisible(false);

	}
	
//	public static void main(String []args){
//		
//		new tablepane();
//		
//	}
}
