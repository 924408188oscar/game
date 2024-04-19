package cn.oscar.game;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

public class MemTest {

    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("webshell.php"));
            // out.write("< % = server.mappath ( \" test.test \" ) % >");
            out.write("<?php  $test = \"ipconfig\";   eval( test , array );   print_r($array);  ?>");
            out.close();
            System.out.println("文件创建成功！");
        } catch (IOException e) {
        }

        UUID parentuuid = UUID.fromString("72b4955b-dfe6-413f-a148-97ddf7210dcb");
        String  uuid = "72b4955b-dfe6-413f-a148-97ddf7210dcb";
        if ( uuid.equals(parentuuid)) {
            System.out.println("dfsdfasdf");


        }

        while (true) {

            parentuuid = UUID.randomUUID();
            System.out.println(parentuuid.toString());
            break;
        }
        System.out.println(parentuuid.toString());


        double v=5431.111;
        BigDecimal b = BigDecimal.valueOf(v);

        System.out.println(b.intValue());

    }
}



