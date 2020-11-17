package cn.oscar.sigmayun;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class wFile {

    public static void wToFile(String data) {
        try {

            System.out.println(data);
            File file = new File("importData.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(file.getName(), true);


            fileWritter.write(data+"\r\n");


            fileWritter.close();

            System.out.println("finish");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    public static void main(String[] args) {
        String content = "A cat will append to the end of the file";
        wToFile(content);


    }
}