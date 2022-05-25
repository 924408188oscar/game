package cn.oscar.thread;

public class TestRun {

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThreadPrinter pa = new MyThreadPrinter("A", c, a);
        MyThreadPrinter pb = new MyThreadPrinter("B", a, b);
        MyThreadPrinter pc = new MyThreadPrinter("C", b, c);


        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);


//        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
//        TJoin mTh1=new TJoin("A");
//        TJoin mTh2=new TJoin("B");
////        TJoin mTh3=new TJoin("C");
//        mTh1.start();
//        mTh2.start();
////        mTh3.start();
//        try {
//            mTh1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            mTh2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        try {
////            mTh3.join();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
//
//    }

    }
}