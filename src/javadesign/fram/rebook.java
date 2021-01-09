package javadesign.fram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javadesign.dao.bookmanage;
import javadesign.util.reb;
import javadesign.util.reprice;
import javadesign.util.图书信息管理;
import javadesign.util.图书管理;

import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

//根据名称来修改价格
class reprice{
	private String name;
	private float price;
	public reprice(String name,float price) {
		this.name=name;
		this.price=price;
	}
	public void renew() throws Exception {
		new bookmanage().rebook(name,price);
	}
}
public class rebook{
	private JFrame frame=new JFrame("修改图书");
	private JButton re=new JButton("修改");
	private JLabel nameLab=new JLabel("图书名称");
	private JLabel priceLab=new JLabel("图书价格");
	private JTextField nameText=new JTextField();
	private JTextField priceText=new JTextField();
	private JLabel noticLab=new JLabel("请输入要修改的图书及修改后的价格");
	private final JLabel show = new JLabel();
	public rebook() {
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent args0) {
//				System.exit(1);
//			}
//		});
		frame.getContentPane().setLayout(new GridLayout(0, 2, 2, 0));
		frame.getContentPane().add(nameLab);
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(priceLab);
		frame.getContentPane().add(priceText);
		re.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==re) {
					show.setText("");
					String name=nameText.getText();
				    float  price=Float.parseFloat(priceText.getText());
				    reprice two=new  reprice(name,price);
					try {
						two.renew();
						show.setText("修改成功");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}});
		frame.getContentPane().add(re);
		
		frame.getContentPane().add(show);
		frame.getContentPane().add(noticLab);
		this.frame.setSize(651,315);
		this.frame.setVisible(true);
	}
}
//成功后后给反应
