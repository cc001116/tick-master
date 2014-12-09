package cn.flower.tick.client.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class info extends JPanel {

	public void add(Component c, GridBagConstraints constraints,int x ,int y, int w, int h){
		
		constraints.gridx = x;
		constraints.gridy  =y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c, constraints);
	}

	info(){
		
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		JLabel name = new JLabel("姓名");
		JLabel code = new JLabel("姓名");
		JLabel sexy = new JLabel("姓名");
		JLabel age = new JLabel("姓名");
		JLabel birthday = new JLabel("姓名");
		JLabel adress = new JLabel("姓名");
		JLabel cj = new JLabel("姓名");
		JLabel zw = new JLabel("姓名");
		
		final JTextField codeinput = new JTextField(10);
		final JTextField nameinput = new JTextField(10);
		final JTextField sexinput = new JTextField(10);
		final JTextField ageinput = new JTextField(10);
		final JTextField birthdayinput = new JTextField(10);
		final JTextField addressinput = new JTextField(10);
		final JTextField gradeinput = new JTextField(10);
		final JTextField majorinput = new JTextField(10);
		
		JLabel title = new JLabel("基本信息");
		JButton addition = new JButton("添加");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 4;
		constraints.weighty = 6;
		
		add(title,constraints,0,0,4,1);
		add(name,constraints,0,1,1,1);
		add(code,constraints,0,2,1,1);
		
		
		
	}
}
