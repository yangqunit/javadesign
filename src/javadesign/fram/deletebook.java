package javadesign.fram;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javadesign.dao.bookmanage;

//����������ɾ��
//������Ҫɾ��������
//ɾ��
class deletBook{
	private String name;
	public deletBook(String name) {
		this.name=name;
	}
	public void delet() throws Exception {
		new bookmanage().deletebook(name);
		
	}
}
public class deletebook{
	private JFrame frame=new JFrame("ɾ��ͼ��");
	private JButton de=new JButton("ɾ��");
	private JLabel nameLab=new JLabel("������Ҫɾ��������");
	private JTextField nameText=new JTextField();
	private final JTextField show = new JTextField();
	public deletebook() {
		show.setColumns(10);
		de.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				show.setText("");
				if(arg0.getSource()==de) {
					String name=nameText.getText();
					deletBook one=new deletBook(name);
					try {
						one.delet();
						show.setText("ɾ���ɹ�");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}});
		
		frame.getContentPane().setLayout(new GridLayout(3,1));
		frame.getContentPane().add(nameLab);
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(de);
		
		frame.getContentPane().add(show);
		this.frame.setSize(526,388);
		this.frame.setVisible(true);
	}
}
