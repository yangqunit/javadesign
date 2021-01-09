package javadesign.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

//通过图书信管理进行图书的相关操作
//图书操作化为一个一个方法



//增删查改都只需要改变SQL语句即可
public  class bookmanage {
	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//定义SQLServer数据库连接地址，testdb可改成自己的数据库名称
		private static final String DBURL="jdbc:sqlserver://localhost:1433 ;DatabaseName=java ";
		private static  final String DBUSER="sa"; //SQLServer数据库连接用户名
		private static final String PASSWORD="1272443632"; //SQLServer数据库连接密码
		
		//增加图书成功
		//
	public  void addbook(String a,String b,String c,float d) throws Exception {
		Connection coon=null;
		 Statement stmt= null;
		Class.forName(DBRIVER);
		String sql=" insert into bookinformation(book_num,book_type,book_name,book_price)"+" values('"+a+"','"+b+"','"+c+"','"+d+"')";
		coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//连接数据库
		stmt=coon.createStatement();//实例化statement
		stmt.executeUpdate(sql);
		stmt.close();
		coon.close();

	}
	
 //修改图书
	public  void rebook(String a,float c) throws Exception {
		Connection coon=null;
		 Statement stmt= null;
		String sql="update  bookinformation  set book_price='"+c+"' where book_name= '"+a+"'";
		Class.forName(DBRIVER);
		coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//连接数据库
		stmt=coon.createStatement();//实例化statement
		stmt.executeUpdate(sql);
		stmt.close();
		coon.close();
	}
	//删除图书
	public  void deletebook(String b) throws Exception {
		
		Connection coon=null;
		 Statement stmt= null;
		String sql="delete from bookinformation where book_name='"+b+"'";
		
		Class.forName(DBRIVER);
		coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//连接数据库
		stmt=coon.createStatement();//实例化statement
		stmt.executeUpdate(sql);
		stmt.close();
		coon.close();
	}
	  //查询图书(根据姓名来查询)返回一个字符串
	
	//后期改成数组
		public static String  searchbook(String a) throws Exception {
			Connection coon=null;
			 Statement stmt= null;
			 ResultSet rs=null;
			String sql="select book_num,book_type,book_name,book_price from bookinformation where book_name='"+a+"'";
			//String sql="select 图书编号,图书种类,图书名称,图书价格 from 图书浏览";
			Class.forName(DBRIVER);
			coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//连接数据库
			stmt=coon.createStatement();//实例化statement
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
			//查询所有的加入集合
			 
			String sql="select book_num,book_type,book_name,book_price from bookinformation ";
			
			
			Class.forName(DBRIVER);
			coon=DriverManager.getConnection(DBURL, DBUSER, PASSWORD);//连接数据库
			stmt=coon.createStatement();//实例化statement
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
