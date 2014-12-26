package cn.flower.tick.client.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

	JLabel imagelabe, lablefrom, lableto, datelab;
	JButton checkbt;

	JXDatePicker date;
	Date nowdate = new Date();

	String city[] = { "邵阳", "驻马店", "南阳", "周口" };
	String cityfrom[] = { "北京"};
	JComboBox from = new JComboBox(cityfrom);
	JComboBox to = new JComboBox(city);
	String tick_from;
	String tick_to;
	Date tick_date;

	tick_remain() {
		// Common_Interface ci=new Common_Interface();

		contentPane = this.getContentPane();
		jp = new JPanel();
		jp.setLayout(null);
		add_Label();
		add_button();

		contentPane.add(jp, BorderLayout.CENTER);
		// contentPane.add(jscrollpane, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	// 触发事件
	public void add_button() {

		JButton jb = new JButton("确定");
		jb.setFont(new Font("宋体", Font.BOLD, 24));
		jb.setBounds(700, 310, 130, 40);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (from.getSelectedItem().equals(to.getSelectedItem())) {

					JOptionPane.showMessageDialog(null, "始发站和站点站是同一站，无效！");
					
					return;
				} else {

					
					SimpleDateFormat fort = new SimpleDateFormat("yyyy-MM-dd");
					String getdate = fort.format(date.getDate());
					new tick_choice((String) from.getSelectedItem(),
							(String) to.getSelectedItem(), getdate);
					dispose();

				}
			}
		});
		jp.add(jb);
	}

	public void add_Label() {

		ImageIcon image = new ImageIcon("image/tick_choice.png");
		imagelabe = new JLabel(image);
		JLabel j1 = new JLabel("余票查询");

		datelab = new JLabel("日期");
		lablefrom = new JLabel("始发站");
		lableto = new JLabel("终点站");

		j1.setFont(new Font("宋体", Font.BOLD, 24));

		j1.setBounds(0, 210, 400, 100);

		date = new JXDatePicker(nowdate);
		date.setFormats("yyyy-MM-dd");
		date.setLocale(Locale.CHINA);

		lablefrom.setFont(new Font("宋体", Font.BOLD, 24));
		lableto.setFont(new Font("宋体", Font.BOLD, 24));
		datelab.setFont(new Font("宋体", Font.BOLD, 24));

		imagelabe.setBounds(0, 0, 1000, 100);
		datelab.setBounds(190, 240, 80, 40);
		lablefrom.setBounds(337, 240, 80, 40);
		lableto.setBounds(458, 240, 80, 40);
		from.setBounds(340, 310, 80, 40);
		to.setBounds(460, 310, 80, 40);
		date.setBounds(160, 310, 140, 40);

		jp.add(imagelabe);
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
