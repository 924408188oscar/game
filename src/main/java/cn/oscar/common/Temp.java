package cn.oscar.common;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Temp {
    public static void main(String[] args) {
        String chinse= "中在人工111";

        System.out.println(chinse);
        String uuid = UUID.randomUUID().toString();
        LocalDate today = LocalDate.now();
        System.out.println(today.toString());
        Date date = new Date();
        System.out.println(date.getTime());

        SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date1 = new Date();
        System.out.println(bartDateFormat.format(date1).toString());
        String time=bartDateFormat.format(date1).toString();
        System.out.println(time);


    }
}
