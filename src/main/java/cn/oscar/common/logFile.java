package cn.oscar.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class logFile {

    public static void logToFile(String data, String fileName) {
        if (fileName.isEmpty()) {
            fileName = "default.txt";
        }
        try {

            System.out.println(data);
            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(file.getName(), true);


            fileWritter.write(data + "\r\n");


            fileWritter.close();

            System.out.println("finish");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


    public static void main(String[] args) {
        String content = "A cat will append to the end of the file";
        logToFile(content, "1111");
    }

}
