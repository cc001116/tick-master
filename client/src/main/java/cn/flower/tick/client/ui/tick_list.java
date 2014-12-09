package cn.flower.tick.client.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXDatePicker;

public class tick_list extends JPanel {

	private static final Date Component = null;
	private JLabel label1, label2, label3;
	private JComboBox box1, box2;
	private JPanel jPanel;
	private JButton button1, button2;
	private String city[] = { "北京", "上海", "河南", "广州", "河北", "武汉" };
	JXDatePicker date;
	Date nowdate = new Date();

	public void add(Component c, GridBagConstraints constraints, int x, int y,
			int w, int h) {

		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		add(c, constraints);
	}

	public tick_list() {

		jPanel = new JPanel();
		GridBagLayout lay = new GridBagLayout();
		setLayout(lay);
		label1 = new JLabel("选择起始地");
		label2 = new JLabel("选择目的地");
		label3 = new JLabel("选择日期");
		button1 = new JButton("确定");
		button2 = new JButton("关闭");
		box1 = new JComboBox(city);
		box2 = new JComboBox(city);
		date = new JXDatePicker(nowdate);
		date.setFormats("yyyy年-MM月-dd日");
		date.setLocale(Locale.CHINA);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 12;
		constraints.weighty = 12;

		// 添加控件

		add(date, constraints, 0, 4, 4, 1);
		add(label3, constraints, 0, 1, 1, 1);
		add(label1, constraints, 0, 2, 1, 1);
		add(label2, constraints, 0, 3, 1, 1);
		add(button1, constraints, 0, 4, 1, 1);

		add(date, constraints, 1, 1, 1, 1);
		add(box1, constraints, 1, 2, 1, 1);
		add(box2, constraints, 1, 3, 1, 1);
		add(button2, constraints, 1, 4, 1, 1);

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button1_act();

			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button2_act();
			}
		});
	}

	public void button1_act() {

		if (box1.getSelectedItem().equals(box2.getSelectedItem())) {
			JOptionPane.showMessageDialog(null, "始发站和站点站是同一站，无效！");
			// box1.removeAllItems();
			// box2.removeAllItems();
			return;
		} else {

			String tick_id = null;
			String tick_from = (String) box1.getSelectedItem();
			String tick_to = (String) box2.getSelectedItem();
			String tick_no = null;
			String tick_type = null;
			String tick_room = null;
			String tick_seat = null;
			String tick_price = null;
			String tick_date = null;

			// new QueryOrder(tick_id, tick_from, tick_to, tick_no, tick_type,
			// tick_room, tick_seat, tick_price, tick_date);
			new TickOrder();
		}

	}

	public void button2_act() {

		jPanel.setVisible(false);
	}

	public static void main(String[] args) {

		new TicketList();

	}
}
