package cn.oscar.common;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class OnWeek {

    public static String[] onWeek(){
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY));
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY ));
        String[] resultDate = new String[] {"0","0"};
        resultDate[0]= String.valueOf(monday.plusDays(1));
        resultDate[1]=String.valueOf(sunday.plusDays(1));

        return resultDate;
    }

    public static String onDate(int x){
        LocalDate today = LocalDate.now();
        String result="2020-10-01";

        result=String.valueOf(today.plusDays(x));

        return result;
    }

   //获取某一周的时间
    public static String[] onWeekX(int x){
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY));
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY ));
        String[] resultDate = new String[] {"0","0"};
        resultDate[0]= String.valueOf(monday.plusDays(x));
        resultDate[1]=String.valueOf(sunday.plusDays(x));

        return resultDate;
    }
    //获取周一 到周日（x+y）
    public static String[] onWeekX(int x,int y){
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY));
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY ));
        String[] resultDate = new String[] {"0","0"};
        resultDate[0]= String.valueOf(monday.plusDays(x));
        resultDate[1]=String.valueOf(sunday.plusDays(x+y));

        return resultDate;
    }

    //1get frist month day, -1 month last day
    public static String getMonthDay(int x){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String date="";
        if(x == 1)
        {
            date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

        }else {
            cal.roll(Calendar.DAY_OF_MONTH, -1);
            date=new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        }
        return date;
    }

    public static String getLastMonthDay(int lastMonth,int x){

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH,lastMonth);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String date="";
        if(x == 1)
        {
            date = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

        }else {
            cal.roll(Calendar.DAY_OF_MONTH, -1);
            date=new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        }
        return date;

    }

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(TemporalAdjusters.previousOrSame( DayOfWeek.MONDAY));
        LocalDate sunday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY ));
        System.out.println(monday.plusDays(1));
        System.out.println(sunday.plusDays(1));
        System.out.println("==================================");
        System.out.println("onDate:"+onDate(1));
        String[] aa=onWeekX(0);

        System.out.println(aa[0]);
        System.out.println(aa[1]);
        System.out.println("==================================");
        System.out.println(getMonthDay(-1));

        //System.out.println(onDate(-6));
        //获取上个月第一天日期
        System.out.println(getLastMonthDay(-1,1));
        //获取上个月最后一天的日期
        System.out.println(getLastMonthDay(-1,-1));

    }





}
