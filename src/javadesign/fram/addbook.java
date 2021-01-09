package javadesign.fram;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javadesign.dao.bookmanage;

class bookinfo{
	private String num;
	private String name;
	private float price;
	private String kind;
	public bookinfo(String num,String kind,String name,float price) {
		this.num=num;
		this.kind=kind;
		this.name=name;
		this.price=price;
	}
	public void add() throws Exception {
		new bookmanage().addbook(num,kind,name,price);//通过图形界面的选择，借用图书信息管理实行增加操作
	}
}

public class addbook{
	private JFrame frame=new JFrame("增加图书");
	private JButton ad=new JButton("增加");
	private JLabel numLab=new JLabel("图书编号");
	private JLabel nameLab=new JLabel("图书名称");
	private JLabel priceLab=new JLabel("图书价格");
	private JLabel kindLab=new JLabel("图书种类");
	private JTextField numText=new JTextField();
	private JTextField nameText=new JTextField();
	private JTextField priceText=new JTextField();
	private JTextField kindText=new JTextField();
	private final JTextField show = new JTextField();
	public addbook() {
		show.setColumns(10);
		ad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==ad) {
					show.setText("");
					String num=numText.getText();
					String name=nameText.getText();
					String kind=kindText.getText();
				    float price=Float.parseFloat(priceText.getText());
					bookinfo one=new bookinfo(num,kind,name,price);//把得到的信息写入
					try {
						one.add();
						show.setText("增加成功");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}});
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent args0) {
				System.exit(1);
			}
		});
		frame.getContentPane().setLayout(new GridLayout(6,2));
		frame.getContentPane().add(numLab);
		frame.getContentPane().add(numText);
		frame.getContentPane().add(kindLab);
		frame.getContentPane().add(kindText);
		frame.getContentPane().add(nameLab);
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(priceLab);
		frame.getContentPane().add(priceText);
		frame.getContentPane().add(ad);
		
		frame.getContentPane().add(show);
		this.frame.setSize(800,800);
		this.frame.setVisible(true);
		
	}
}

