package cn.flower.tick.client.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.JXDatePicker;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import cn.flower.tick.client.util.HttpClientUtil;

public class tick_remain extends Common_Interface {

	private JPanel jp;
	JScrollPane jscrollpane;
	Container contentPane;
	JCheckBox jcb;

	JLabel lablefrom, lableto, datelab;
	JButton checkbt;
	
	JXDatePicker date;
	Date nowdate = new Date();

	String city[] = { "北京", "驻马店", "南阳", "商丘" };

	JComboBox from = new JComboBox(city);
	JComboBox to = new JComboBox(city);
	String tick_from;
	String tick_to;

	tick_remain() {
		// Common_Interface ci=new Common_Interface();
		contentPane = this.getContentPane();
		jp = new JPanel();
		jp.setLayout(null);

		add_button();
		add_Label();
		

		contentPane.add(jp, BorderLayout.CENTER);
		//contentPane.add(jscrollpane, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	// 触发事件
	public void add_button() {

		JButton jb = new JButton("确定");
		jb.setFont(new Font("宋体", Font.BOLD, 24));
		jb.setBounds(700, 100, 100, 40);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (from.getSelectedItem().equals(to.getSelectedItem())) {

					JOptionPane.showMessageDialog(null, "始发站和站点站是同一站，无效！");
					// box1.removeAllItems();
					// box2.removeAllItems();
					return;
				} else {

					new tick_choice((String)from.getSelectedItem(), (String)to.getSelectedItem());
				}
			}
		});
		jp.add(jb);
	}

	public void add_Label() {
		JLabel j1 = new JLabel("余票查询");

		datelab = new JLabel("日期");
		lablefrom = new JLabel("始发站");
		lableto = new JLabel("终点站");

		j1.setFont(new Font("宋体", Font.BOLD, 24));

		j1.setBounds(20, 0, 400, 100);

		date = new JXDatePicker(nowdate);
		date.setFormats("yyyy-MM-d");
		date.setLocale(Locale.CHINA);

		lablefrom.setFont(new Font("宋体", Font.BOLD, 24));
		lableto.setFont(new Font("宋体", Font.BOLD, 24));
		datelab.setFont(new Font("宋体", Font.BOLD, 24));

		datelab.setBounds(170, 30, 80, 40);
		lablefrom.setBounds(320, 30, 80, 40);
		lableto.setBounds(440, 30, 80, 40);
		from.setBounds(320, 100, 80, 40);
		to.setBounds(440, 100, 80, 40);
		date.setBounds(140, 100, 140, 40);
		jp.add(j1);

		jp.add(lablefrom);
		jp.add(lableto);
		jp.add(datelab);
		jp.add(from);
		jp.add(to);
		jp.add(date);

	}

	
	public static void main(String args[]) {

		new tick_remain();

	}
}
