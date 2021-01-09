package javadesign.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//把客户的账号和密码输入到文本文件中，删除或修改用户的信息
 public class custmanage{
	  
	//增加一个用户
	public void addIm(String name,String password ) throws IOException {
		 // FileOutputStream类如果该流在打开文件进行输出前，目标文件不存在，那么该流会创建该文件，使用true进行追加
	    /*
		 转换流 java.io.OutputStreamWriter，是Writer的子类，是从字符流到字节流的桥梁。
　　　　 它使用指定的字符集将字符编码为字节。它的字符集可以由名称指定，也可以接受平台的默认字符集。
                  该类继承 Writer 类
                  ① 创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称

　　　　② 使用OutputStreamWriter对象中的方法write,把字符转换为字节存储缓冲区中(编码)

　　　　③ 使用OutputStreamWriter对象中的方法flush,把内存缓冲区中的字节刷新到文件中(使用字节流写字节的过程)

　　　　④ 释放资源
		 */
		/*
		 * BufferedWriter:字符缓冲输出流
		 * 关闭流之前刷新流
		 *  bw.flush();
		 */
   FileOutputStream file=new FileOutputStream(new File("C:\\Users\\杨群\\Desktop\\用户的账户信息.txt"),true);
   OutputStreamWriter osw=new OutputStreamWriter(file, "UTF-8");
   BufferedWriter  bw=new BufferedWriter(osw);
       bw.write(name+","+password+"\t\n");
       bw.flush();
       bw.close();
       osw.close();
       file.close();
	}
	
	//根据账户的名字来删除账户 
   public void deleteIm(String name) throws Exception{
	 
	   FileInputStream fis=new FileInputStream("C:\\Users\\杨群\\Desktop\\用户的账户信息.txt");
	     InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	     BufferedReader br = new BufferedReader(isr);
	     String line="";
	     String[] arrs = new String[50];
	 String[]arr=null;
	 int a=0;
	 while ((line=br.readLine())!=null) {//用readline一行一行读取
		 arr=line.split(",");//用，作为分隔符
	    if(!(arr[0].contentEquals(name))) {//如果不等于就加入
	    	arrs[a]=line;
	    	System.out.println(arrs[a]);
	         a++;
	 	 }
	    }
	 OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\杨群\\Desktop\\用户的账户信息.txt"), "utf-8");
	 BufferedWriter  bw=new BufferedWriter(osw);
	 for(int i=0;i<a;i++) {
		 bw.write(arrs[i]+"\t\n");
	 }
	            isr.close();
	 	        br.close();
		        fis.close();
		        bw.flush();
		        bw.close();
		        osw.close();
		       
		
		 
}
	
	//返回账户及密码
public String searchIm(String name) throws Exception{
	 FileInputStream fis=new FileInputStream("C:\\Users\\杨群\\Desktop\\用户的账户信息.txt");
     InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
     BufferedReader br = new BufferedReader(isr);
     String line="";
     String[] arrs=null;
     String a="s,1";
 while ((line=br.readLine())!=null) {//用readline一行一行读取
    arrs=line.split(",");//用，作为分隔符
    if(arrs[0].contentEquals(name)) {
 	 a=arrs[0]+","+arrs[1];
 	 break;
 	 }
    }
		    br.close();
	        isr.close();
	        fis.close();
	       return a;
	}
 
//修改账户的密码
public void modifyIm(String name,String password) throws Exception{
		 FileInputStream fis=new FileInputStream("C:\\Users\\杨群\\Desktop\\用户的账户信息.txt");
	     InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	     BufferedReader br = new BufferedReader(isr);
	     String line="";
	     String[] arrs = new String[50];
	 String[]arr=null;
	 int a=0;
	 while ((line=br.readLine())!=null) {//用readline一行一行读取
		 arr=line.split(",");//用，作为分隔符
	    if(!(arr[0].contentEquals(name))) {//如果不等于就加入
	    	arrs[a]=line;
	    	System.out.println(arrs[a]);
	         a++;
	 	 }
	    if(arr[0].contentEquals(name))
	     {
	    	arrs[a]=name+","+password;
	    	a++;
	    }
	    }
	 OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\杨群\\Desktop\\用户的账户信息.txt"), "utf-8");
	 BufferedWriter  bw=new BufferedWriter(osw);
	 for(int i=0;i<a;i++) {
		 bw.write(arrs[i]+"\t\n");
	 }
	            isr.close();
	 	        br.close();
		        fis.close();
		        bw.flush();
		        bw.close();
		        osw.close();
		       
		
		 
}
  }
