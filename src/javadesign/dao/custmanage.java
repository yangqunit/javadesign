package javadesign.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//�ѿͻ����˺ź��������뵽�ı��ļ��У�ɾ�����޸��û�����Ϣ
 public class custmanage{
	  
	//����һ���û�
	public void addIm(String name,String password ) throws IOException {
		 // FileOutputStream����������ڴ��ļ��������ǰ��Ŀ���ļ������ڣ���ô�����ᴴ�����ļ���ʹ��true����׷��
	    /*
		 ת���� java.io.OutputStreamWriter����Writer�����࣬�Ǵ��ַ������ֽ�����������
�������� ��ʹ��ָ�����ַ������ַ�����Ϊ�ֽڡ������ַ�������������ָ����Ҳ���Խ���ƽ̨��Ĭ���ַ�����
                  ����̳� Writer ��
                  �� ����OutputStreamWriter����,���췽���д����ֽ��������ָ���ı��������

���������� ʹ��OutputStreamWriter�����еķ���write,���ַ�ת��Ϊ�ֽڴ洢��������(����)

���������� ʹ��OutputStreamWriter�����еķ���flush,���ڴ滺�����е��ֽ�ˢ�µ��ļ���(ʹ���ֽ���д�ֽڵĹ���)

���������� �ͷ���Դ
		 */
		/*
		 * BufferedWriter:�ַ����������
		 * �ر���֮ǰˢ����
		 *  bw.flush();
		 */
   FileOutputStream file=new FileOutputStream(new File("C:\\Users\\��Ⱥ\\Desktop\\�û����˻���Ϣ.txt"),true);
   OutputStreamWriter osw=new OutputStreamWriter(file, "UTF-8");
   BufferedWriter  bw=new BufferedWriter(osw);
       bw.write(name+","+password+"\t\n");
       bw.flush();
       bw.close();
       osw.close();
       file.close();
	}
	
	//�����˻���������ɾ���˻� 
   public void deleteIm(String name) throws Exception{
	 
	   FileInputStream fis=new FileInputStream("C:\\Users\\��Ⱥ\\Desktop\\�û����˻���Ϣ.txt");
	     InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	     BufferedReader br = new BufferedReader(isr);
	     String line="";
	     String[] arrs = new String[50];
	 String[]arr=null;
	 int a=0;
	 while ((line=br.readLine())!=null) {//��readlineһ��һ�ж�ȡ
		 arr=line.split(",");//�ã���Ϊ�ָ���
	    if(!(arr[0].contentEquals(name))) {//��������ھͼ���
	    	arrs[a]=line;
	    	System.out.println(arrs[a]);
	         a++;
	 	 }
	    }
	 OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\��Ⱥ\\Desktop\\�û����˻���Ϣ.txt"), "utf-8");
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
	
	//�����˻�������
public String searchIm(String name) throws Exception{
	 FileInputStream fis=new FileInputStream("C:\\Users\\��Ⱥ\\Desktop\\�û����˻���Ϣ.txt");
     InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
     BufferedReader br = new BufferedReader(isr);
     String line="";
     String[] arrs=null;
     String a="s,1";
 while ((line=br.readLine())!=null) {//��readlineһ��һ�ж�ȡ
    arrs=line.split(",");//�ã���Ϊ�ָ���
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
 
//�޸��˻�������
public void modifyIm(String name,String password) throws Exception{
		 FileInputStream fis=new FileInputStream("C:\\Users\\��Ⱥ\\Desktop\\�û����˻���Ϣ.txt");
	     InputStreamReader isr=new InputStreamReader(fis, "UTF-8");
	     BufferedReader br = new BufferedReader(isr);
	     String line="";
	     String[] arrs = new String[50];
	 String[]arr=null;
	 int a=0;
	 while ((line=br.readLine())!=null) {//��readlineһ��һ�ж�ȡ
		 arr=line.split(",");//�ã���Ϊ�ָ���
	    if(!(arr[0].contentEquals(name))) {//��������ھͼ���
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
	 OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\��Ⱥ\\Desktop\\�û����˻���Ϣ.txt"), "utf-8");
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
