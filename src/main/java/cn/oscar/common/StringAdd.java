package cn.oscar.common;

public class StringAdd {
    public static String slash(String data) {
        String s="";
        s=data.replace("\\","\\\\");
        data=s.replace("\"","\\\"");

        //System.out.println(data);
    return data;
    }

    public static void main(String[] args) {
        String aa="sh -c \"pidof upsh\\ield-modulesd\"";
        System.out.println(slash(aa));
    }
}
