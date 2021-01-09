package javadesign.fram;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javadesign.dao.bookmanage;

import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;

 public class showalll extends JFrame {
//搞一个集合加入
	private JFrame frame=new JFrame("展示所有");
	private Container container=frame.getContentPane();
	private JComboBox jcb=null;
	public showalll() throws Exception {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		
//		Vector<String> v=new Vector<String>();
//		v.add("78");
		Vector<String> v=new bookmanage().showbook();
		frame.getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		this.jcb = new JComboBox(v);
		//this.jcb = new JComboBox(v);
		jcb.setBorder(BorderFactory.createTitledBorder("所有的书"));
		jcb.setMaximumRowCount(3);
		frame.getContentPane().add(this.jcb);
		frame.setSize(690,524);
	    frame.setVisible(true);
	}

}
//public class showalll{
//	public static void main(String [] args) throws Exception {
//		new showall();
//	}
//}