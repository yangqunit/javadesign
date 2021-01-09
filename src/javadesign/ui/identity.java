package javadesign.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javadesign.dao.custmanage;
import javadesign.util.managechoice;
import javadesign.util.userchoice;

import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class identity extends JFrame {

	private JPanel contentPane;
	private JTextField nameText;
	private JPasswordField passText;
	private JTextField nam;
	private JPasswordField pas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					identity frame = new identity();
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
	
	public identity() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
						System.exit(1);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_2224140183850400");
		JLabel infoLab = new JLabel("\u7528\u6237\u64CD\u4F5C\u7CFB\u7EDF");
		JPanel userpan = new JPanel();
		tabbedPane.addTab("用户", null, userpan, null);
		userpan.setLayout(new GridLayout(8, 8, 0, 0));
		
		JLabel name = new JLabel("\u8D26\u53F7\uFF1A");
		userpan.add(name);
		
		nameText = new JTextField();
		userpan.add(nameText);
		nameText.setColumns(10);
		
		JLabel pass = new JLabel("\u5BC6\u7801");
		userpan.add(pass);
		
		passText = new JPasswordField();
		userpan.add(passText);
		passText.setColumns(10);
		
		JButton login = new JButton("\u767B\u5F55");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==login) {
				String tname=nameText.getText();
				String tpass=new String(passText.getPassword());
				
				custmanage caCustmanage=new custmanage();
				String name;
				try {
					System.out.println(tname+"\t"+tpass);
					name = caCustmanage.searchIm(tname).trim();
					
					System.out.println(name);
					String user[]=name.split(",");
					String user1=user[0];
					String pasword1=user[1];
					int pas=Integer.valueOf(pasword1);
					System.out.println(user1+"\t"+pas);
					if (Integer.valueOf(tpass)==Integer.parseInt(pasword1)) {
						new userchoice();
						infoLab.setText("登录成功");
					}else {
						infoLab.setText("登录失败，错误的用户名或密码");
						nameText.setText("");
						passText.setText("");
					}
					
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		}});
		userpan.add(login);
		
		JButton longi = new JButton("\u6CE8\u518C");
		longi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==longi) {
					System.out.println("djf");
					String name=nameText.getText();
					String pass=new String(passText.getPassword());
					try {
						System.out.println(new custmanage().searchIm(name));
						System.out.println(name+","+pass);
						if((new custmanage().searchIm(name)).contentEquals("s,1")) {
							new custmanage().addIm( name,pass);
							 infoLab.setText("注册成功,请重新输入登录");
						}else {
							infoLab.setText("账号已存在，请重新输入");
						}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						nameText.setText("");
						passText.setText("");
					}
			}
		});
		userpan.add(longi);
		JLabel info = new JLabel("\u7BA1\u7406\u5458\u767B\u5F55\u7CFB\u7EDF");
		
		userpan.add(infoLab);
		
		JPanel tourispan = new JPanel();
		tabbedPane.addTab("游客", null, tourispan, null);
		tourispan.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\u8FD8\u4E0D\u8D76\u7D27\u6CE8\u518C \u5728\u8FD9\u5E72\u5565\u5462\uFF1F\uFF01\uFF01\uFF01\uFF01");
		tourispan.add(lblNewLabel, "name_2224884625176299");
		
		JPanel managepan = new JPanel();
		tabbedPane.addTab("管理员", null, managepan, null);
		managepan.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		managepan.add(lblNewLabel_1);
		
		nam = new JTextField();
		managepan.add(nam);
		nam.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		managepan.add(lblNewLabel_2);
		
		pas = new JPasswordField();
		managepan.add(pas);
		pas.setColumns(10);
		
		JButton mlogin = new JButton("\u767B\u5F55");
		mlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==mlogin) {
				String tname=nam.getText();
				String tpass=new String(pas.getPassword());
				try {
					if("demo".equals(tname)&&"123".equals(tpass)) {
						new managechoice();
						info.setText("登录成功");
					}else {
						info.setText("登录失败，错误的用户名或密码");
						nameText.setText("");
						passText.setText("");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
					
					}
				}
			
		});
		managepan.add(mlogin);
		managepan.add(info);
	}

}
