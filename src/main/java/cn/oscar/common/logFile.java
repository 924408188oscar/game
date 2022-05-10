package cn.oscar.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class logFile {
    private static String REGEX = "(\\w{8}(-\\w{4}){3}-\\w{12}?)";
    private static String REGEXTime = "(\\d{13}?)";
    private static String fileName= "E:\\Atest\\perfmon\\20211110_102123\\20211110_102123b";
    private static String zipfile= "E:\\Atest\\perfmon\\20211110_102123\\20211110_102123b.zip";

    public static void logToFile(String data, String fileName) {
        if (fileName.isEmpty()) {
            fileName = "default.txt";
        }
        try {
//            System.out.println(data);
            File file = new File(fileName);
            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(data+"\r\n");
            bufferWritter.close();
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void logfilezip() throws IOException {
        File fileOut = new File(fileName);

        if (fileOut.exists()) {
            fileOut.delete();
            fileOut.createNewFile();}
        else {
            fileOut.createNewFile();
        }

        // 读取文件内容public String readFile()
        String path = "E:\\Atest\\perfmon\\20211110_102123\\20211110_1021231bak";
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件
            String s = null;
            int i=0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
//替换UUID
//                System.out.println(s.toString());
                String REPLACE= UUID.randomUUID().toString().toUpperCase();
//                System.out.println(REPLACE);
                Pattern p = Pattern.compile(REGEX);
                // get a matcher object
                Matcher m = p.matcher(s);
                s = m.replaceAll(REPLACE);
//替换时间蹉
                Long startTs = System.currentTimeMillis();
                String startTstring=startTs.toString();
                Pattern p1 = Pattern.compile(REGEXTime);
                // get a matcher object
                Matcher m1 = p1.matcher(s);
                s = m1.replaceAll(startTstring);
//                System.out.println(s);

                logToFile(s,fileName);
                i++;
//
            }
            System.out.println(i);
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }


        //压缩文件
        fileOut = new File(zipfile);
        if (fileOut.exists()) {fileOut.delete();}

        List<File> fileList = new ArrayList<>();
        fileList.add(new File(fileName));

        FileOutputStream fos2 = new FileOutputStream(new File(zipfile));
        ZipUtils.toZip(fileList,fos2);



    }

    public static void main(String[] args) throws IOException {
//        String content = "A cat will append to the end of the file";
//        logToFile(content, "1111");
        logfilezip();

//       String uuid= UUID.randomUUID().toString().toUpperCase();
//       System.out.println(uuid);
//
//        Pattern p = Pattern.compile(REGEX);
//        // get a matcher object
//        Matcher m = p.matcher(INPUT);
//        INPUT = m.replaceAll(uuid);
//        System.out.println(INPUT);
    }

}
