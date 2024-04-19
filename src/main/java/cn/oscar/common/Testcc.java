package cn.oscar.common;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testcc {


    public static void main(String[] args) {

        // 按指定模式在字符串查找
        String line = "dhw-423423.sqs";
        String pattern = "([-]\\d+)|((\\d+))";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {

            if (m.group(0).contains("-")) {
                try {
                    float number = Float.valueOf(m.group(0));
                    if(number <-Math.pow(2,32))
                        System.out.println("-2^32");
                    else
                        System.out.println(m.group(0));
                } catch (NumberFormatException e) {
                    System.out.println("-2^32");
                    e.printStackTrace();
                }
            } else {
                try {
                    float number = Float.valueOf(m.group(0));
                    if(number >Math.pow(2,32))
                        System.out.println("2^32");
                    else
                    System.out.println(m.group(0));
                } catch (NumberFormatException e) {
                    System.out.println("2^32");
                    e.printStackTrace();
                }
            }


        }else
            System.out.println("0");
    }
}
