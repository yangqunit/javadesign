package javadesign.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

//ͨ��ͼ���Ź������ͼ�����ز���
//ͼ�������Ϊһ��һ������



//��ɾ��Ķ�ֻ��Ҫ�ı�SQL��伴��
public  class bookmanage {
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//����SQLServer���ݿ����ӵ�ַ��testdb�ɸĳ��Լ������ݿ�����
		private static final String DBURL="jdbc:sqlserver://localhost:1433 ;DatabaseName=java ";
		private static  final String DBUSER="sa"; //SQLServer���ݿ������û���
		private static final String PASSWORD="1272443632"; //SQLServer���ݿ���������
		
		//����ͼ��ɹ�
		//
	public  void addbook(String a,String b,String c,float d) throws Exception {
		Connection coon=null;
		 Statement stmt= null;
		Class.forName(DBRIVER);
		String sql=" insert into bookinformation(book_num,book_type,book_name,book_price)"+" values('"+a+"','"+b+"','"+c+"','"+d+"')";
		coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//�������ݿ�
		stmt=coon.createStatement();//ʵ����statement
		stmt.executeUpdate(sql);
		stmt.close();
		coon.close();

	}
	
 //�޸�ͼ��
	public  void rebook(String a,float c) throws Exception {
		Connection coon=null;
		 Statement stmt= null;
		String sql="update  bookinformation  set book_price='"+c+"' where book_name= '"+a+"'";
		Class.forName(DBRIVER);
		coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//�������ݿ�
		stmt=coon.createStatement();//ʵ����statement
		stmt.executeUpdate(sql);
		stmt.close();
		coon.close();
	}
	//ɾ��ͼ��
	public  void deletebook(String b) throws Exception {
		
		Connection coon=null;
		 Statement stmt= null;
		String sql="delete from bookinformation where book_name='"+b+"'";
		
		Class.forName(DBRIVER);
		coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//�������ݿ�
		stmt=coon.createStatement();//ʵ����statement
		stmt.executeUpdate(sql);
		stmt.close();
		coon.close();
	}
	  //��ѯͼ��(������������ѯ)����һ���ַ���
	
	//���ڸĳ�����
		public static String  searchbook(String a) throws Exception {
			Connection coon=null;
			 Statement stmt= null;
			 ResultSet rs=null;
			String sql="select book_num,book_type,book_name,book_price from bookinformation where book_name='"+a+"'";
			//String sql="select ͼ����,ͼ������,ͼ������,ͼ��۸� from ͼ�����";
			Class.forName(DBRIVER);
			coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//�������ݿ�
			stmt=coon.createStatement();//ʵ����statement
			rs=stmt.executeQuery(sql);
			String sta="a";
			while(rs.next()) {
				String num1=rs.getString("book_num");
				String kind=rs.getString("book_type");
				String name=rs.getString("book_name");
				float price=rs.getFloat("book_price");
				sta= num1+","+kind+","+name+","+price;
			}
			stmt.close();
			coon.close();
			return sta;
			
		}
		
		public static   Vector<String> showbook() throws Exception {
			Connection coon=null;
			 Statement stmt= null;
			 ResultSet rs=null;
			 Vector<String> v=new Vector<String>();
			//��ѯ���еļ��뼯��
			 
			String sql="select book_num,book_type,book_name,book_price from bookinformation ";
			
			
			Class.forName(DBRIVER);
			coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//�������ݿ�
			stmt=coon.createStatement();//ʵ����statement
			rs=stmt.executeQuery(sql);
			
			
			String sta="a";
			while(rs.next()) {
				String num1=rs.getString("book_num");
				String kind=rs.getString("book_type");
				String name=rs.getString("book_name");
				float price=rs.getFloat("book_price");
				sta= num1+","+kind+","+name+","+price;
				v.add(sta);
			}
			 
			stmt.close();
			coon.close();
			return v;
			
		}
}


//	public class bookmanage{
//		public static void main(String [] args) throws Exception {
//		 Vector<String> v=new bookmanag().showbook();
//			Iterator<String> iter = v.iterator();
//		        while(iter.hasNext())
//		        {
//		            System.out.println(iter.next());
//		        }
//		}
//	}
