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
import javadesign.util.ͼ��Ĺ���;
import javadesign.util.ͼ�����;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class buybook {//������Ϣ�洢���ı��ļ���
	 
	private JFrame frame=new JFrame("����ͼ��");
	private JButton re=new JButton("ȷ��");
	private JLabel nameLab=new JLabel("��������Ҫ�����ͼ������");
	//�������ƺ�������ֱ���ں�̨���м����ļ�
	private JTextField nameText=new JTextField();
	private final JTextField notic = new JTextField();
	public buybook() {
		re.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==re) {
					//�ٴβ�����������
					notic.setText("");
					//���ȷ������е�һЩ����
					//��д������������ʱ����ʵ���Ѿ������ֵ�������
					String name=nameText.getText();//�õ��������
				   try {
					   
					String en=new bookmanage().searchbook(name);//�õ������Ϣ
					
					System.out.println(en);
					if(en.equals("a")) {
						notic.setText("���������ͼ�鲻���ڣ���ȷ���Ƿ�������ȷ");
					}
					else {
						//д���ļ�
						
						 FileOutputStream file=new FileOutputStream(new File("C:\\Users\\��Ⱥ\\Desktop\\�ͻ��Ķ���.txt"),true);
					    OutputStreamWriter osw=new OutputStreamWriter(file, "UTF-8");
					    BufferedWriter  bw=new BufferedWriter(osw);
					        bw.write(en+"\t\n");
					    //ע��رյ��Ⱥ�˳���ȴ򿪵ĺ�رգ���򿪵��ȹر�
					    bw.close();
					    osw.close();
					  file.close();
					  notic.setText("����ɹ�");
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

