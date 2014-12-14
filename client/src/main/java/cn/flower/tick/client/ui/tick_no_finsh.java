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
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.http.Header;

import cn.flower.tick.client.util.HttpClientUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class tick_no_finsh implements ActionListener {
	
	JTable table = null;
	DefaultTableModel defaultModel = null;
	
	public tick_no_finsh() {

		JFrame frame = new JFrame();
		String uri = HttpClientUtil.HOST + "/order/view/uncomplete";
		Header header = HttpClientUtil.getDefaultHeader();
		String msg = HttpClientUtil.sendGetRequest(uri, header);
		System.out.println(msg);
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
				"座号","乘客", "票价"};
		defaultModel = new DefaultTableModel(datas, columnTitle);
		
		ImageIcon image = new ImageIcon("image/tick_choice.png");
		JLabel img = new JLabel(image);
		
		img.setBounds(0, 0, 800, 100);
		
		table = new JTable(defaultModel);
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn column1 = columnModel.getColumn(0);
		column1.setMinWidth(0);
		column1.setMaxWidth(0);
		
		TableColumn column2 = columnModel.getColumn(0);
		
		//column1.setMaxWidth(0);
		table.setPreferredScrollableViewportSize(new Dimension(853, 637));
		table.setFillsViewportHeight(true);  
		JScrollPane scrollPane = new JScrollPane(table);
		JPanel panel = new JPanel();
		
		JButton okbt = new JButton("支付订单");
		okbt.setBounds(800, 1000, 80, 30);
		//panel.add(img);
		panel.add(okbt);
		panel.add(okbt);
		
		okbt.addActionListener(this);
		okbt = new JButton("删除订单");
		panel.add(okbt);
		panel.add(okbt);
		
		okbt.addActionListener(this);
		
		Container container = frame.getContentPane();
		container.add(panel,BorderLayout.NORTH);
		container.add(scrollPane,BorderLayout.CENTER);
		frame.setTitle("订单管理");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screensize = toolkit.getScreenSize();
		frame.setSize(853, 637);//基础大小
		int height = frame.getHeight();
		int width = frame.getWidth();
		frame.setLocation(screensize.width/2-width/2, screensize.height/2-height/2);//居中显示
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			
			public void window(WindowEvent e){
				
				System.exit(0);
			}
		});
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("支付订单")){
			JOptionPane.showConfirmDialog(null, "确定支付这一张火车票!");
			
			int selectrow = table.getSelectedRow();
			defaultModel.removeRow(selectrow);
			JOptionPane.showMessageDialog(null, "支付成功!");
		}
		if(e.getActionCommand().equals("删除订单")){
			
			int selectrow = table.getSelectedRow();
			int row = defaultModel.getRowCount() - 1;
			
			if(row >= 0){
				
				JOptionPane.showConfirmDialog(null, "确定删除这一张火车票!");		
				defaultModel.removeRow(selectrow);
				defaultModel.setRowCount(row);
						
			}
		}
		
		table.revalidate();
	}
	
	public static void main(String []args){
		
		new tick_no_finsh();
	}

}
