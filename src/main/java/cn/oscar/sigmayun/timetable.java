package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

public class timetable {

    //获取是否有课表在使用status
    public static String statusIsTrue(String data,String Statu){
        String status="0";
        if(data.length()<16){
            return status;

        }
        int a = Integer.parseInt(Statu);

        JSONObject  response_data_obj = JSONObject.parseObject(data);//把data转为json对象
        Object dataObject=response_data_obj.get("data");  //获取json对象data对象

        //System.out.println(dataObject.toString());

        JSONArray jsonArray;
        jsonArray = parseArray(dataObject.toString());

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject;
            jsonObject = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象
            int values=jsonObject.getShort("status");
            //System.out.println(values);
            if(values==a)
                status="1";
        }

        return status;
    }

    public static void main(String[] args) {
        String content1 = "))))";
        String content = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": \"6701403088005238784\",\n" +
                "      \"name\": \"年级数据\",\n" +
                "      \"org\": {\n" +
                "        \"id\": \"6699567233347227648\",\n" +
                "        \"name\": \"学军中学\"\n" +
                "      },\n" +
                "      \"timetableTemplateName\": \"WEWEWE\",\n" +
                "      \"startDate\": \"2020-08-17\",\n" +
                "      \"endDate\": \"2021-01-31\",\n" +
                "      \"status\": 1,\n" +
                "      \"lastOperatorTime\": \"2020-08-25T09:30:34Z\",\n" +
                "      \"updatedBy\": \"王师\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6699624548507193344\",\n" +
                "      \"name\": \"年级\",\n" +
                "      \"org\": {\n" +
                "        \"id\": \"6699567233347227648\",\n" +
                "        \"name\": \"学军中学\"\n" +
                "      },\n" +
                "      \"timetableTemplateName\": \"3434\",\n" +
                "      \"startDate\": \"2020-08-10\",\n" +
                "      \"endDate\": \"2020-08-16\",\n" +
                "      \"status\": 3,\n" +
                "      \"lastOperatorTime\": \"2020-08-14T02:04:38.558281Z\",\n" +
                "      \"updatedBy\": \"王师\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total\": 2\n" +
                "}";

        System.out.println(statusIsTrue(content,"1"));


    }
}
