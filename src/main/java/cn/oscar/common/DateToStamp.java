package cn.oscar.common;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStamp {
    //将时间转换为时间戳
    public static String dateToStamp(String s) throws Exception {
        String res;
        //设置时间格式，将该时间格式的时间转换为时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long time = date.getTime();
        res = String.valueOf(time);
        return res;
    }

    public static String stampToTime(String s)  {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        //将时间戳转换为时间
        Date date = new Date(lt);
        //将时间调整为yyyy-MM-dd HH:mm:ss时间样式
        res = simpleDateFormat.format(date);
        return res;
    }

// 通过时间2022-09-20 11:00:00 增加时间
    public static String dataAddSecondTime(String time, String millisecond) throws Exception {
        String startTime = dateToStamp(time);
        long startTimeLong = Long.parseLong(startTime);

        long secondTime = Long.parseLong(millisecond);
        long newTime = startTimeLong + secondTime;
        return Long.toString(newTime);
    }

    //通过时间磋直接增加时间
    public static String stampAddSecondTime(String stampTime, String millisecond) {

        long startTimeLong = Long.valueOf(stampTime);

        long secondTime = Long.valueOf(millisecond);
        long newTime = startTimeLong + secondTime;
        return Long.toString(newTime);
    }


    public static void main(String[] args) throws Exception {
        String time = "2022-09-20 18:24:00";
        System.out.println(dateToStamp(time));
        System.out.println(dataAddSecondTime(time,"9000"));

        String aaa="24653645555555";
        System.out.println(stampAddSecondTime(aaa,"100"));

    }

}
