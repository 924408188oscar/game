package cn.oscar.common;

import java.util.Random;

public class StringSplitJoint {

    //[aa,bb,cc],[gg,hh,jj]  拼接为一个[]
    //[aa,bb,cc,dd,ee,ff,gg,hh,jj]
    public static String getValue(String[] data){
        String result="";
        int x=0;
        x=data.length;
        System.out.println(x);
        if(x==1)
            result=data[0];
        if(x==2)
        {
            result=data[0].substring(0,data[0].length()-1);
            result=result+","+data[1].substring(1,data[1].length());

        }
        if(x>2){
            result=data[0].substring(0,data[0].length()-1);
            for(int i=1;i<x-1;i++){
                result=result+","+data[i].substring(1,data[i].length()-1);
            }
            result= result+","+data[x-1].substring(1,data[x-1].length());
        }

        return  result;


    }

    public static String getValue3(String data1,String data2,String data3){
        String result="";
        System.out.println(data1);
        result=data1.substring(0,data1.length()-1)+","+data2.substring(1,data2.length()-1)+","+data3.substring(1,data3.length());

       // System.out.println(result);
        return  result;


    }

    public static void main(String[] args){

        String[] data=new String[]{"[aa,bb,cc]","[gg,hh,jj]"};
        //[aa,bb,cc,dd,ee,ff,gg,hh,jj]
        System.out.println(getValue(data));

        System.out.println(getValue3("[aa,bb,cc]","[gg,hh,jj]","[aa,bb,cc]"));

        Random r = new Random();
        String[] aa=new String[]{"夯实基础","同步巩固","查漏补缺","培优拔高","充实业余时间","参与竞赛","其他"};
        int i= r.nextInt(7);
        System.out.println(aa[i]);



    }
}
