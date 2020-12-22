package cn.oscar.appointment;

import com.alibaba.fastjson.JSONObject;

public class TasksBody {
    public static String getBody(String templateNodeId,String Userid,String UserName,String copytemplateNodeId){
        String body="\"tasks\": [\n" +
                "    {\n" +
                "      \"templateNodeId\": \""+templateNodeId+"\",\n" +
                "      \"taskType\": \"or\",\n" +
                "      \"candidate\": [\n" +
                "        {\n" +
                "          \"userId\": \""+Userid+"\",\n" +
                "          \"name\": \""+UserName+"\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"templateNodeId\": \""+copytemplateNodeId+"\",\n" +
                "      \"taskType\": \"copy\",\n" +
                "      \"candidate\": []\n" +
                "    }\n" +
                "  ]";

        return  body;
    }

    public static String[] getUUIDvalue(String data){
        String resultArray[] = new String[]{"0","0"};
        JSONObject jsonObject;
        jsonObject=JSONObject.parseObject(data);

        jsonObject=jsonObject.getJSONObject("procTemplate");
        jsonObject=jsonObject.getJSONObject("body");
        jsonObject=jsonObject.getJSONObject("childNode");
        resultArray[0]=jsonObject.getString("id");
        jsonObject=jsonObject.getJSONObject("childNode");
        resultArray[1]=jsonObject.getString("id");

        return resultArray;
    }
}
