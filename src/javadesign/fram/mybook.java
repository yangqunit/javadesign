package javadesign.fram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.FlowLayout;

public class mybook{
	 public mybook() throws Exception {
		 FileInputStream fis=new FileInputStream("C:\\Users\\杨群\\Desktop\\客户的订单.txt");
	     InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	     BufferedReader br = new BufferedReader(isr);
	     String line="";
	     
	     JFrame frame=new  JFrame("订单的显示");
	     	JTextArea jita=new JTextArea();
	     	jita.setFont(new Font("DialogInput", Font.BOLD, 23));
	     	frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	     	JLabel lab=new JLabel("\u60A8\u6240\u8D2D\u4E70\u7684\u8BA2\u5355\u5982\u4E0B\u6240\u793A\uFF1A");
	     	lab.setFont(new Font("华文琥珀", Font.PLAIN, 32));
	     	frame.getContentPane().add(lab);
	     	frame.getContentPane().add(jita);
	     while ((line=br.readLine())!=null) {//用readline一行一行读取
	      System.out.println(line);
	         //读取后的内容
	         //把读取后的内容显示在图形界面上
	         jita.append(line+"\n");
	     }
	     frame.setSize(709,665);
	 		frame.setVisible(true);
	     br.close();
	     isr.close();
	     fis.close();
		 }
}
