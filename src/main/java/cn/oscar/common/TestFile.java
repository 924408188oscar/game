package cn.oscar.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestFile {

	public static void main(String[] args) {

	// 读取文件内容public String readFile(){
    String path = "D:\\性能\\导数据\\邯郸校区\\111.txt";
     File file = new File(path);
     StringBuilder result = new StringBuilder();
     try{
         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

         String s = null;
         int i=0;
         while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            // result.append( System.lineSeparator() + s);
        	 String[] strarr = s.split(",");
             
            // System.out.println(strarr[2]);
			 //System.out.println(i);
			 i++;
             Acompare(strarr[2],strarr[3],path);
         }
		 System.out.println(i);
         br.close();
     }catch(Exception e){
         e.printStackTrace();
     }
	}
	
	public static  String Acompare(String a,String b,String pathA) {
		String result1="";
		
		
		 String path = pathA;
	     File file = new File(path);
	     StringBuilder result = new StringBuilder();
	     try{
	         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

	         String s = null;
	         while((s = br.readLine())!=null){//使用readLine方法，一次读一行
	            // result.append( System.lineSeparator() + s);
	        	 String[] strarr = s.split(",");
	        	 if(a.equals(strarr[2]))
	        			 if(!b.equals(strarr[3])) {
	        				 System.out.println("=="+s.toString());
	        			 }
	             
	            // System.out.println(s.toString());
	         }
	         br.close();
	     }catch(Exception e){
	         e.printStackTrace();
	     }
		
		return result1;
		
	}
	
	
	}
