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
		JFrame frame=new JFrame("����Ա���в���");
	  JButton but=new JButton("����ͼ��");
	  //����
	  but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but) {
					//������صĲ���
					new addbook();
				}
					
			}});
	  JButton but1=new JButton("�޸�ͼ��");
	  but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but1) {
					//������صĲ���
					new rebook();
				}
					
			}});
	  
	  JButton but2=new JButton("ɾ��ͼ��");
	  but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but2) {
					//������صĲ���
					new deletebook();
				}
					
			}});
	  JButton but3=new JButton("��ѯͼ��");
	  but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==but3) {
					//������صĲ���
					new searchbook();
				}
					
			}});
	   
	   JButton cu = new JButton("�û��Ĺ���");
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
