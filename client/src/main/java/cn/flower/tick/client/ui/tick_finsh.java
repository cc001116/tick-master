package cn.flower.tick.client.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.http.Header;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.flower.tick.client.util.HttpClientUtil;



public class tick_finsh implements ActionListener {

	JTable table = null;
	DefaultTableModel defaultModel = null;

	public tick_finsh() {

		JFrame frame = new JFrame();
		String uri = HttpClientUtil.HOST + "/order/view/completed";
		Header header = HttpClientUtil.getDefaultHeader();
		String msg = HttpClientUtil.sendGetRequest(uri, header);
		
		if(msg.length() == 2){
			
			JOptionPane.showMessageDialog(null, "不存在已完成订单！");
			return;
		}

		System.out.println("*****"+msg+"*****"+"changdu:  "+msg.length());
		JSONArray array = JSON.parseArray(msg);
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < array.size(); i++) {

			List<Object> order = new ArrayList<Object>();
			JSONObject obj = array.getJSONObject(i);
			System.out.print(obj.get("id").toString() + "  ");
			System.out.print(obj.get("serialCode").toString() + "  ");
			System.out.print(obj.get("createDate").toString() + "  ");
			JSONObject tick = obj.getJSONObject("ticket");
			System.out.print(tick.get("typeName").toString() + "  ");
			System.out.print(tick.get("arrivalStation").toString() + "  ");
			System.out.print(tick.get("startStation").toString() + "  ");
			System.out.print(tick.get("passenger").toString() + "  ");
			System.out.print(tick.get("seatNo").toString() + "  ");

			order.add(obj.get("id").toString()); // id

			order.add(obj.get("serialCode").toString());// 订单号
			order.add(tick.get("startStation").toString());// 始发站
			order.add(tick.get("arrivalStation").toString());// 终点站
			order.add(obj.get("createDate").toString());// 订单日期
			order.add(tick.get("typeName").toString());// 座位类型

			order.add(tick.get("seatNo").toString());// 座位号
			order.add(tick.get("passenger").toString());// 乘客
			order.add(tick.get("tickPrice").toString());// 票价
			System.out.println();
			list.add(order.toArray());
		}
		System.out.println();

		int row = list.size();
		int colum = list.get(0).length;
		Object[][] datas = new Object[row][colum];

		for (int i = 0; i < row; i++) {

			Object[] values = list.get(i);
			for (int j = 0; j < colum; j++) {

				datas[i][j] = values[j];
			}
		}

		System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {

				System.out.println(datas[i][j]);
			}
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
		}

		Object[] columnTitle = { "type1", "订单号", "始发站", "终点站", "订单日期", "座位",
				"座号", "乘客", "票价" };
		
		defaultModel = new DefaultTableModel(datas, columnTitle);

		ImageIcon image = new ImageIcon("image/tick_choice.png");
		JLabel img = new JLabel(image);

		img.setBounds(0, 0, 1000, 100);

		table = new JTable(defaultModel);
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column1 = columnModel.getColumn(0);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);

		table.setPreferredScrollableViewportSize(new Dimension(853, 637));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		JPanel panel = new JPanel();

		JButton okbt = new JButton("退订车票");
	
		//panel.add(img);
		panel.add(okbt);
		panel.add(okbt);
		

		okbt.addActionListener(this);

		Container container = frame.getContentPane();
		container.add(panel, BorderLayout.CENTER);
		container.add(scrollPane, BorderLayout.SOUTH);
		frame.setTitle("已完成订单管理");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screensize = toolkit.getScreenSize();
		frame.setSize(853, 637);// 基础大小
		int height = frame.getHeight();
		int width = frame.getWidth();
		frame.setLocation(screensize.width / 2 - width / 2, screensize.height
				/ 2 - height / 2);// 居中显示
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {

			public void window(WindowEvent e) {

				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("退订车票")) {

			int selectrow = table.getSelectedRow();
			int row = defaultModel.getRowCount() - 1;

			if (row >= 0) {

				Object tickid =table.getValueAt(table.getSelectedRow(), 0);
				
				String id = tickid.toString();
				System.out.println("选择退票的车票id为："+id);
				JOptionPane.showConfirmDialog(null, "确定退订这一张火车票!");
				
				String url = HttpClientUtil.HOST + "/order/delete/"+id;
				Map<String, String> params = new HashMap<String, String>();
				Header header = HttpClientUtil.getDefaultHeader();
				String msg = HttpClientUtil.sendPostRequest(url, params, header);
				System.out.println(msg);
				
				if(msg.contains("success")){
					
					defaultModel.removeRow(selectrow);
					JOptionPane.showMessageDialog(null, "退订车票成功");
				}
				
				defaultModel.setRowCount(row);
				
				
			}
		}

		table.revalidate();
	}

	public static void main(String[] args) {

		new tick_finsh();
	}

}
