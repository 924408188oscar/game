package cn.oscar.appointment;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Auto-generated: 2020-12-02 17:41:41
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class FormValue {
    public static String getBody(String uuidDate,String uuidName,String name,String uuidContent,String content){
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date date1 = new Date();
        String time1=bartDateFormat.format(date1).toString();

        String formValue="  \"formValue\": [\n" +
                "    {\n" +
                "      \"id\": \""+uuidDate+"\",\n" +
                "      \"value\": \""+time1+"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \""+uuidName+"\",\n" +
                "      \"value\": \""+name+"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \""+uuidContent+"\",\n" +
                "      \"value\": \""+content+"\"\n" +
                "    }\n" +
                "  ]";

        return formValue;
    }
}