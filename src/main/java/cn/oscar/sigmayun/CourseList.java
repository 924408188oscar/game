package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

public class CourseList {
    public static String[] getCourseScheduleIdStudentGroupId(String data,String node,String status,int statusValue,String getscheduleId,String getstudentGroupId ){
        String resultArray[] = new String[]{"0", "0","0"};
        int result = -10;

        JSONObject jsonObject;
        jsonObject=JSONObject.parseObject(data);

        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject.getString(node));//把string改变为Json数组

        resultArray[0] = String.valueOf(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            // System.out.println("---------------" + result);
            JSONObject jsonObject1;
            jsonObject1 = (JSONObject) jsonArray.getJSONObject(i);
            result = jsonObject1.getShortValue(status) ;
            if(statusValue==result){
                resultArray[1]=jsonObject1.getString(getscheduleId);
                resultArray[2]=jsonObject1.getString(getstudentGroupId);
            }
        }

        System.out.println(getscheduleId+":"+resultArray[1]);
        System.out.println(getstudentGroupId+":"+resultArray[2]);
        System.out.println(resultArray[0]);
        return resultArray;
    }

    public static void main(String[] args){
        String aa="{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"scheduleId\": \"6726300157488533504\",\n" +
                "      \"startTime\": \"15:00:00\",\n" +
                "      \"endTime\": \"17:00:00\",\n" +
                "      \"status\": 2,\n" +
                "      \"studentGroupId\": \"6711828083479023616\",\n" +
                "      \"studentGroupSn\": \"20900060\",\n" +
                "      \"studentGroupName\": \"冯余\",\n" +
                "      \"configPeriodCardBaseName\": \"语文0901\",\n" +
                "      \"subject\": \"语文\",\n" +
                "      \"teacher\": \"3434\",\n" +
                "      \"consumePeriodSum\": 14,\n" +
                "      \"studentNames\": [\n" +
                "        \"冯余\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total\": 4\n" +
                "}";

        String result[];

        result=getCourseScheduleIdStudentGroupId(aa,"data","status",2,"scheduleId","studentGroupId");


        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[0]);


    }





}
