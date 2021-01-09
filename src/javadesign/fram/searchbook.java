package javadesign.fram;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javadesign.dao.bookmanage;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

//�Ľ������� ���гɹ��󣬰ѽ����ʾ���û�

class searchinfo{
	private String name;
	public searchinfo(String name) {
		this.name=name;
	}
	public String search() throws Exception {
		return new bookmanage().searchbook(name);
	}
}
public class searchbook{
	private JFrame frame=new JFrame("��ѯͼ��");
	private JButton se=new JButton("��ѯ");
	private JTextField nameText=new JTextField();
	private JLabel noticLab=new JLabel("\u8BF7\u8F93\u5165\u8981\u67E5\u8BE2\u56FE\u4E66\u7684\u540D\u79F0\uFF1A");
	private final JLabel sho = new JLabel("");
	//��һ��TextArea �����ѯ����
	public searchbook() {
		se.setBounds(22, 167, 654, 62);
		se.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==se) {
					//���µ���� ��ʾ����
					sho.setText(" ");
					String name=nameText.getText();
					if(name.equals("")) {
						try {
							new showalll();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {
					searchinfo three=new searchinfo(name);//����������
					try {
						String po=three.search();
						System.out.printf(po);
						if(po.equals("a"))
							//jita.append("������Ѱ��ͼ�鲻���ڣ���ȷ�������Ƿ���ȷ");
						sho.setText("������Ѱ��ͼ�鲻���ڣ���ȷ�������Ƿ���ȷ");
						else {
							sho.setText(po+"\n");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
			}
		}});
		frame.getContentPane().setLayout(null);
		noticLab.setFont(new Font("����", Font.BOLD, 34));
		noticLab.setBounds(7, 7, 654, 61);
		frame.getContentPane().add(noticLab);
		nameText.setFont(new Font("����", Font.ITALIC, 28));
		nameText.setBounds(9, 85, 654, 61);
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(se);
		sho.setBounds(15, 318, 638, 150);
		
		frame.getContentPane().add(sho);
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent args0) {
//				System.exit(1);
//			}
//		});
		
		this.frame.setSize(690,524);
		this.frame.setVisible(true);
	}
}
