package cn.oscar.common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PerfmonTestFile {


    public static void main(String[] args) {

        String IP="204.25.220.249";
        String uuid="8e5c4d6128fa486baeb88ff830a9b300";

        String reg="[0-9]{13}";

        Pattern patten = Pattern.compile(reg);

        Date date = new Date();
        String timestamp = String.valueOf(date.getTime()/1000);
        System.out.println(Integer.valueOf(timestamp));

        // 读取文件内容public String readFile(){
        String path = "E:\\Atest\\perfmon\\20211110_102123\\a.txt";
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

            String s = null;
            int i=0;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                // result.append( System.lineSeparator() + s);
//                String[] strarr = s.split(",");
                s=s.replace("192.168.1.50",IP);
                s=s.replace("353837a93db8ba334ba43e55c08572c1",uuid);

                // 指定要匹配的字符串
                Matcher matcher = patten.matcher(s);
                //此处find()每次被调用后，会偏移到下一个匹配
                while (matcher.find()) {
                    String target = matcher.group();
                    s = s.replaceFirst(target, timestamp);
                    System.out.println(target);
                }


//                System.out.println(s.toString());

                i++;
            }
            System.out.println(i);
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }






//        //读取目标日志文件
//        String temp = FileOperateUtils.readToString(path);
//        //按行分割
//        String[] lines = temp.split("\n");
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < lines.length; i++) {
//            // 指定要匹配的字符串
//            Matcher matcher = patten.matcher(lines[i]);
//            //此处find()每次被调用后，会偏移到下一个匹配
//            while (matcher.find()) {
//                String target = matcher.group();
//                lines[i] = lines[i].replaceFirst(target, DateUtil.getTime(new Date(Long.parseLong(target) * 1000)));
//                System.out.println(target);
//            }
//            result.append(lines[i]).append("\n");
//        }
//        //输出
//        FileOperateUtils.createAndWriteAppendFile(result.toString(), "D:\\subResult.log");
//        System.out.println("OK! D:\\subResult.log");
    }


}
