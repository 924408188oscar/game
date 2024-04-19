package cn.oscar.common;


import java.awt.*;
import java.io.File;

public class Temp {
    public static void main(String[] args) {

        String programPath="C:\\Windows\\System32\\whoami.exe";

        String programPath1="C:\\Windows\\System32\\netstat.exe";


            try {
                Desktop.getDesktop().open(new File(programPath));
                Desktop.getDesktop().open(new File(programPath1));
                System.out.println("aaaaaaaaaaaaaaa");
            } catch (Exception e) {
                e.printStackTrace();

            }



//        String chinse = "中在人工111";
//
//        String aa1 = "";
//        System.out.println(aa1.isEmpty());
//
//        System.out.println(chinse);
//        String uuid = UUID.randomUUID().toString();
//        LocalDate today = LocalDate.now();
//        System.out.println(today.toString());
//        Date date = new Date();
//        System.out.println(date.getTime());
//
//        SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//        Date date1 = new Date();
//        System.out.println(bartDateFormat.format(date1).toString());
//        String time = bartDateFormat.format(date1).toString();
//        System.out.println(time);
//
//
//        int random = (int) (Math.random() * 10 + 1);
//        System.out.println(random);
//
//        String aa = "sh -c \"pidof upshield-modulesd\"";
//
//        aa = aa.replace("\"", "\\\"");
//
//        System.out.println(aa);

    }



}
