package cn.oscar.sigmayun;

import cn.oscar.appointment.FormValue;
import cn.oscar.appointment.TasksBody;

import java.util.UUID;

public class Appointment {
    public static String getBody(String startUserName, String templateId,String recordId,String templateKey,String fromValue, String tasks) {
        String body = "{\n" +
                "  \"startUserName\": \""+startUserName+"\",\n" + fromValue +",\n" +
                "  \"templateId\": \""+templateId+"\",\n" +
                "  \"formInstFuncRelDto\": {\n" +
                "    \"funcSecondId\": \"MyCustomer\",\n" +
                "    \"funcSubId\": \"MyCustomerConsultationPlan\",\n" +
                "    \"recordId\": \""+recordId+"\"\n" +
                "  },\n" +
                "  \"templateKey\": \""+templateKey+"\",\n" +tasks+
                "}";

        return body;
    }
//通过funcSubId 来区分是预约还是 咨询记录
    public static String getBody(String startUserName, String templateId,String recordId,String templateKey,String fromValue, String tasks,String funcSubId) {
        String body = "{\n" +
                "  \"startUserName\": \""+startUserName+"\",\n" + fromValue +",\n" +
                "  \"templateId\": \""+templateId+"\",\n" +
                "  \"formInstFuncRelDto\": {\n" +
                "    \"funcSecondId\": \"MyCustomer\",\n" +
                "    \"funcSubId\": \""+funcSubId+"\",\n" +
                "    \"recordId\": \""+recordId+"\"\n" +
                "  },\n" +
                "  \"templateKey\": \""+templateKey+"\",\n" +tasks+
                "}";

        return body;
    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();

        String formValue = FormValue.getBody("date1111", "李世民", "namessss", "uuid content", "崛起");


        //System.out.println(formValue);
        String taskbody= TasksBody.getBody("template11111","22222222","王博","copy111");

        System.out.println(taskbody);


        String cc = getBody("王维","templid11111","recordid11111","tempkey", formValue, taskbody);
        System.out.println(cc);
    }
}
