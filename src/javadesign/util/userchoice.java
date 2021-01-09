package javadesign.util;

import javax.swing.JFrame;
import javadesign.fram.buybook;
import javadesign.fram.mybook;
import javadesign.fram.searchbook;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
public class userchoice{
	
	public userchoice() {
		JFrame frame=new JFrame("顾客进行操作");
	  JButton but=new JButton("订单查询");
	  but.setHorizontalAlignment(SwingConstants.RIGHT);
	  but.setBackground(Color.RED);
	  but.setForeground(Color.BLACK);
	  //进行
	  but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but) {
					//进行相关的操作
					try {
						new mybook();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
			}});
	  JButton but1=new JButton("图书查询");
	  but1.setBackground(Color.ORANGE);
	  but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but1) {
					//进行相关的操作
					new searchbook();
				}
					
			}});
	   frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
	 
	   frame.getContentPane().add(but);
	   frame.getContentPane().add(but1);
	   JButton but2=new JButton("购买图书");
	   but2.setBackground(Color.CYAN);
	   but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but2) {
					//进行相关的操作
					new buybook();
				}
					
			}});
	   frame.getContentPane().add(but2);
	   
	   JLabel label = new JLabel("");
	   frame.getContentPane().add(label);
	   
	   JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u6240\u9700\u8981\u7684\u64CD\u4F5C");
	   frame.getContentPane().add(lblNewLabel);
	   
	   JLabel label_1 = new JLabel("");
	   frame.getContentPane().add(label_1);
	   frame.setSize(733,443);
		frame.setVisible(true);
	}
}
