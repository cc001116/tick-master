package cn.flower.tick.client.ui;



import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Common_Interface extends JFrame{

	private Toolkit kit;
	private Dimension screenSize;
	Common_Interface(){
		 kit=Toolkit.getDefaultToolkit();
		 screenSize=kit.getScreenSize();
		 this.setSize(853, 637);//基础大小
		 this.setLocation(screenSize.width/2-getWidth()/2, screenSize.height/2-getHeight()/2);//居中显示
		 this.setResizable(false);
		 //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
