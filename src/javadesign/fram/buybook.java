package javadesign.fram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javadesign.dao.bookmanage;
import javadesign.util.图书的购买;
import javadesign.util.图书管理;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class buybook {//订单信息存储在文本文件中
	 
	private JFrame frame=new JFrame("购买图书");
	private JButton re=new JButton("确定");
	private JLabel nameLab=new JLabel("请输入您要购买的图书名称");
	//输入名称后点击购买，直接在后台进行加入文件
	private JTextField nameText=new JTextField();
	private final JTextField notic = new JTextField();
	public buybook() {
		re.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==re) {
					//再次操作数据清零
					notic.setText("");
					//点击确定后进行的一些操作
					//先写入后点击，点击的时候，其实就已经有文字的输入了
					String name=nameText.getText();//得到书的名称
				   try {
					   
					String en=new bookmanage().searchbook(name);//得到书的信息
					
					System.out.println(en);
					if(en.equals("a")) {
						notic.setText("您所购买的图书不存在，请确定是否输入正确");
					}
					else {
						//写入文件
						
						 FileOutputStream file=new FileOutputStream(new File("C:\\Users\\杨群\\Desktop\\客户的订单.txt"),true);
					    OutputStreamWriter osw=new OutputStreamWriter(file, "UTF-8");
					    BufferedWriter  bw=new BufferedWriter(osw);
					        bw.write(en+"\t\n");
					    //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
					    bw.close();
					    osw.close();
					  file.close();
					  notic.setText("购买成功");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		}});
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.getContentPane().add(nameLab);
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(re);
		notic.setColumns(10);
		frame.getContentPane().add(notic);
		this.frame.setSize(416,272);
		this.frame.setVisible(true);


   
}
  
}

