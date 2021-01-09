package javadesign.util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javadesign.fram.addbook;
import javadesign.fram.custui;
import javadesign.fram.deletebook;
import javadesign.fram.rebook;
import javadesign.fram.searchbook;

import javax.swing.JButton;
public class managechoice{
	public managechoice() {
		JFrame frame=new JFrame("管理员进行操作");
	  JButton but=new JButton("增加图书");
	  //进行
	  but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but) {
					//进行相关的操作
					new addbook();
				}
					
			}});
	  JButton but1=new JButton("修改图书");
	  but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but1) {
					//进行相关的操作
					new rebook();
				}
					
			}});
	  
	  JButton but2=new JButton("删除图书");
	  but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but2) {
					//进行相关的操作
					new deletebook();
				}
					
			}});
	  JButton but3=new JButton("查询图书");
	  but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but3) {
					//进行相关的操作
					new searchbook();
				}
					
			}});
	   
	   JButton cu = new JButton("用户的管理");
	   cu.addActionListener(new ActionListener() {
	   	public void actionPerformed(ActionEvent arg0) {
	   		if(arg0.getSource()==cu) {
	   			new custui().act();
	   		}
	   	}
	   });
	   frame.getContentPane().setLayout(new BorderLayout(0, 0));
	   frame.getContentPane().add(but);
	   frame.getContentPane().add(but1, BorderLayout.SOUTH);
	   frame.getContentPane().add(but2, BorderLayout.WEST);
	   frame.getContentPane().add(but3, BorderLayout.EAST);
	   frame.getContentPane().add(cu, BorderLayout.NORTH);
	   frame.setSize(501,248);
		frame.setVisible(true);
	}
}
