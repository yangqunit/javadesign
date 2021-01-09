package javadesign.fram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javadesign.dao.custmanage;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;

public class custui extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField password;
	private JLabel look;

	/**
	 * Launch the application.
	 */
	public static void act() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custui frame = new custui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public custui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\u8D26\u6237\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 28));
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 28));
		contentPane.add(lblNewLabel_1);
		
		password = new JTextField();
		contentPane.add(password);
		password.setColumns(10);
		
		JButton addB = new JButton("\u589E\u52A0\u7528\u6237");
		addB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tname=name.getText();
				String tpass=password.getText();
				try {
					new custmanage().addIm(tname,tpass);
					look.setText("增加成功");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(addB);
		
		JLabel lblNewLabel_2 = new JLabel("\u589E\u52A0\u7528\u6237\u8BF7\u8F93\u5165\u7528\u6237\u540D\u548C\u5BC6\u7801");
		contentPane.add(lblNewLabel_2);
		
		JButton deleteB = new JButton("\u5220\u9664\u7528\u6237");
		deleteB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tname=name.getText();
				String tpass=name.getText();
				 try {
					new custmanage().deleteIm(tname);
					look.setText("删除成功");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(deleteB);
		
		JLabel lblNewLabel_3 = new JLabel("\u5220\u9664\u7528\u6237\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		contentPane.add(lblNewLabel_3);
		
		JButton reB = new JButton("\u4FEE\u6539\u7528\u6237");
		reB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tname=name.getText();
				String tpass=password.getText();
				try {
					new custmanage().modifyIm(tname, tpass);
					look.setText("修改成功");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(reB);
		
		JLabel lblNewLabel_4 = new JLabel("\u4FEE\u6539\u7528\u6237\u8BF7\u8F93\u5165\u7528\u6237\u540D\u53CA\u4FEE\u6539\u540E\u7684\u5BC6\u7801");
		contentPane.add(lblNewLabel_4);
		
		JButton searchB = new JButton("\u67E5\u627E\u7528\u6237");
		searchB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tname=name.getText();
				String tpass=name.getText();
				String laString;
				try {
					laString = new custmanage().searchIm(tname);
					if(laString.equals("s,1")) {
					look.setText("无此用户，请确定账户或密码是否输入正确");
				}else {
					look.setText(laString);
				}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(searchB);
		JLabel lblNewLabel_5 = new JLabel("\u67E5\u627E\u7528\u6237\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		contentPane.add(lblNewLabel_5);
		look = new JLabel();
		contentPane.add(look);
		
	}

}
