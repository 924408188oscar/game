package cn.oscar.thread;

public class Machine  extends Thread{
    public void run(){
        for (int a=0;a<50;a++)
            System.out.println(a);
    }

    public static void main(String args[]){
        Machine machine=new Machine();
        machine.start();  //启动machine线程
    }
}
