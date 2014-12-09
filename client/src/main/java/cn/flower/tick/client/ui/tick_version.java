package cn.flower.tick.client.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tick_version extends JPanel {

	private static final long serialVersionUID = 1L;
	static final int WIDTH = 240;
	static final int HEIGHT = 140;
	//JPanel panel;
	JFrame versionframe;
	public void add(Component c, GridBagConstraints constraints,int x ,int y, int w, int h){
		
		constraints.gridx = x;
		constraints.gridy  =y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c, constraints);
	}
	
	public tick_version(){
		
		versionframe = new JFrame("售票系统版本信息");
		versionframe.setContentPane(this);
		versionframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		versionframe.setSize(WIDTH, HEIGHT);
		//panel = new JPanel();
//		GridBagLayout lay = new GridBagLayout();
//		setLayout(lay);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		int x = (width - WIDTH )/2;
		int y = (height - HEIGHT )/2;
		versionframe.setLocation(x, y);
		versionframe.setVisible(true);
		
		JLabel label1 = new JLabel("火车票售票系统");
		JLabel label2 = new JLabel("此版本信息：version 1.0");
		JLabel label3 = new JLabel("作者：陈诚，范青文，付兴华，宋烈金");
		JLabel title = new JLabel("系统版本信息");
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.EAST;
		constraints.weightx = 6;
		constraints.weighty = 4;
		
		add(title,constraints,0,0,4,1);
		add(label1,constraints,0,1,1,1);
		add(label2,constraints,0,2,1,1);
		add(label3,constraints,0,3,1,1);
	}
}
