package cn.oscar.sigmayun;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class wFile {

    public static void wToFile(String data) {
        try {

//            System.out.println(data);
            File file = new File("importData.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(file.getName(), true);
            fileWritter.write(data + "\r\n");
            fileWritter.close();
//            System.out.println("finish");
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static boolean vailPath(String path) {
        File file = new File(path);
        try {
            file.getCanonicalPath();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void wToFile(String data, String path, String fileName, boolean isAppend) {
        File file;
        if (vailPath(path)) {
            String dataFilePath = path + fileName;
            System.out.println(dataFilePath);
            file = new File(dataFilePath);
        } else {
            file = new File(fileName);
            System.out.println("1111111111111111111");
        }

//        try {
//            file.getCanonicalPath();
//        } catch (IOException e) {
//            System.out.println("invalid path: " + path);
//        }
        try {
//            System.out.println(data);
//            File file = new File("importData.txt");
            if (!file.exists()) {  //
                file.createNewFile();
            }
            System.out.println(file.getName());
            FileWriter fileWritter = new FileWriter(file, isAppend);
            fileWritter.write(data + "\r\n");
            fileWritter.close();
            System.out.println("finish");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)  {


        String content = "A cat will append to the end of the file！！！";

        wToFile(content, "e:\\", "ddd.txt", false);   // false 不追加，覆盖。
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        String aa = df.format(new Date());
        System.out.println(aa);// new Date()为获取当前系统时间
    }
}