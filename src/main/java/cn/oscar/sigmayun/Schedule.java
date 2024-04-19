package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

public class Schedule {
    //获取 排课某天 排课ID
    public static String getScheduleId(String data,String date,int sequence){
        String scheduleId="0";
        int sequenceValue=0;
        JSONArray jsonArray;

        jsonArray = parseArray(data);//把string改变为Json数组
        //System.out.println(data);
        String date1="0";
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject;
            jsonObject = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象
            if ( !jsonObject.isEmpty() ) {
                date1=jsonObject.getString("date");
                if(date1.equals(date)){
                    JSONArray jsonArrayInfo;
                    jsonArrayInfo = jsonObject.getJSONArray("info");
                    for (int j= 0; j < jsonArrayInfo.size(); j++) {
                        JSONObject jsonObjectinfo;
                        jsonObjectinfo = (JSONObject) jsonArrayInfo.getJSONObject(j);//把每个数组转的josn对象
                        if ( !jsonObjectinfo.isEmpty() ) {
                            sequenceValue=jsonObjectinfo.getIntValue("sequence");
                            if(sequenceValue==sequence){
                                JSONObject jsonObjectGroup;
                                if(jsonObjectinfo.containsKey("group")) {
                                    jsonObjectGroup = jsonObjectinfo.getJSONObject("group");
                                    System.out.println(jsonObjectGroup.toString());
                                if(jsonObjectGroup.containsKey("scheduleId")){//判断是否包含scheduleId key
                                    scheduleId = jsonObjectGroup.getString("scheduleId");

                                }
                            }
                            }
                        }


                    }

                }

            }
        }


        return  scheduleId;
    }


    public static void main(String[] args) {
        String content = "[\n" +
                "  {\n" +
                "    \"date\": \"2021-03-22\",\n" +
                "    \"info\": [\n" +
                "      {\n" +
                "        \"sequence\": 1,\n" +
                "        \"startTime\": \"08:00\",\n" +
                "        \"endTime\": \"09:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214509577375744\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 2,\n" +
                "        \"startTime\": \"09:00\",\n" +
                "        \"endTime\": \"10:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214509577375744\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 3,\n" +
                "        \"startTime\": \"10:00\",\n" +
                "        \"endTime\": \"11:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 4,\n" +
                "        \"startTime\": \"11:00\",\n" +
                "        \"endTime\": \"12:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 5,\n" +
                "        \"startTime\": \"12:00\",\n" +
                "        \"endTime\": \"13:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 6,\n" +
                "        \"startTime\": \"13:00\",\n" +
                "        \"endTime\": \"14:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 7,\n" +
                "        \"startTime\": \"14:00\",\n" +
                "        \"endTime\": \"15:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 8,\n" +
                "        \"startTime\": \"15:00\",\n" +
                "        \"endTime\": \"16:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 9,\n" +
                "        \"startTime\": \"16:00\",\n" +
                "        \"endTime\": \"17:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 10,\n" +
                "        \"startTime\": \"17:00\",\n" +
                "        \"endTime\": \"18:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 11,\n" +
                "        \"startTime\": \"18:00\",\n" +
                "        \"endTime\": \"19:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 12,\n" +
                "        \"startTime\": \"19:00\",\n" +
                "        \"endTime\": \"20:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2021-03-23\",\n" +
                "    \"info\": [\n" +
                "      {\n" +
                "        \"sequence\": 1,\n" +
                "        \"startTime\": \"08:00\",\n" +
                "        \"endTime\": \"09:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214512781824000\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 2,\n" +
                "        \"startTime\": \"09:00\",\n" +
                "        \"endTime\": \"10:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214512781824000\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 3,\n" +
                "        \"startTime\": \"10:00\",\n" +
                "        \"endTime\": \"11:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 4,\n" +
                "        \"startTime\": \"11:00\",\n" +
                "        \"endTime\": \"12:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 5,\n" +
                "        \"startTime\": \"12:00\",\n" +
                "        \"endTime\": \"13:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 6,\n" +
                "        \"startTime\": \"13:00\",\n" +
                "        \"endTime\": \"14:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 7,\n" +
                "        \"startTime\": \"14:00\",\n" +
                "        \"endTime\": \"15:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 8,\n" +
                "        \"startTime\": \"15:00\",\n" +
                "        \"endTime\": \"16:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 9,\n" +
                "        \"startTime\": \"16:00\",\n" +
                "        \"endTime\": \"17:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 10,\n" +
                "        \"startTime\": \"17:00\",\n" +
                "        \"endTime\": \"18:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 11,\n" +
                "        \"startTime\": \"18:00\",\n" +
                "        \"endTime\": \"19:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 12,\n" +
                "        \"startTime\": \"19:00\",\n" +
                "        \"endTime\": \"20:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2021-03-24\",\n" +
                "    \"info\": [\n" +
                "      {\n" +
                "        \"sequence\": 1,\n" +
                "        \"startTime\": \"08:00\",\n" +
                "        \"endTime\": \"09:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214519723397120\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 2,\n" +
                "        \"startTime\": \"09:00\",\n" +
                "        \"endTime\": \"10:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214519723397120\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 3,\n" +
                "        \"startTime\": \"10:00\",\n" +
                "        \"endTime\": \"11:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 4,\n" +
                "        \"startTime\": \"11:00\",\n" +
                "        \"endTime\": \"12:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 5,\n" +
                "        \"startTime\": \"12:00\",\n" +
                "        \"endTime\": \"13:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 6,\n" +
                "        \"startTime\": \"13:00\",\n" +
                "        \"endTime\": \"14:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 7,\n" +
                "        \"startTime\": \"14:00\",\n" +
                "        \"endTime\": \"15:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 8,\n" +
                "        \"startTime\": \"15:00\",\n" +
                "        \"endTime\": \"16:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 9,\n" +
                "        \"startTime\": \"16:00\",\n" +
                "        \"endTime\": \"17:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 10,\n" +
                "        \"startTime\": \"17:00\",\n" +
                "        \"endTime\": \"18:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 11,\n" +
                "        \"startTime\": \"18:00\",\n" +
                "        \"endTime\": \"19:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 12,\n" +
                "        \"startTime\": \"19:00\",\n" +
                "        \"endTime\": \"20:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2021-03-25\",\n" +
                "    \"info\": [\n" +
                "      {\n" +
                "        \"sequence\": 1,\n" +
                "        \"startTime\": \"08:00\",\n" +
                "        \"endTime\": \"09:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214523183697920\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 2,\n" +
                "        \"startTime\": \"09:00\",\n" +
                "        \"endTime\": \"10:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214523183697920\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 3,\n" +
                "        \"startTime\": \"10:00\",\n" +
                "        \"endTime\": \"11:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 4,\n" +
                "        \"startTime\": \"11:00\",\n" +
                "        \"endTime\": \"12:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 5,\n" +
                "        \"startTime\": \"12:00\",\n" +
                "        \"endTime\": \"13:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 6,\n" +
                "        \"startTime\": \"13:00\",\n" +
                "        \"endTime\": \"14:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778251583336615936\",\n" +
                "          \"name\": \"蒋西\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6780670640480456704\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 7,\n" +
                "        \"startTime\": \"14:00\",\n" +
                "        \"endTime\": \"15:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778251583336615936\",\n" +
                "          \"name\": \"蒋西\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6780670640480456704\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 8,\n" +
                "        \"startTime\": \"15:00\",\n" +
                "        \"endTime\": \"16:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 9,\n" +
                "        \"startTime\": \"16:00\",\n" +
                "        \"endTime\": \"17:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 10,\n" +
                "        \"startTime\": \"17:00\",\n" +
                "        \"endTime\": \"18:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 11,\n" +
                "        \"startTime\": \"18:00\",\n" +
                "        \"endTime\": \"19:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 12,\n" +
                "        \"startTime\": \"19:00\",\n" +
                "        \"endTime\": \"20:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2021-03-26\",\n" +
                "    \"info\": [\n" +
                "      {\n" +
                "        \"sequence\": 1,\n" +
                "        \"startTime\": \"08:00\",\n" +
                "        \"endTime\": \"09:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214526769827840\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 2,\n" +
                "        \"startTime\": \"09:00\",\n" +
                "        \"endTime\": \"10:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214526769827840\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 3,\n" +
                "        \"startTime\": \"10:00\",\n" +
                "        \"endTime\": \"11:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 4,\n" +
                "        \"startTime\": \"11:00\",\n" +
                "        \"endTime\": \"12:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 5,\n" +
                "        \"startTime\": \"12:00\",\n" +
                "        \"endTime\": \"13:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 6,\n" +
                "        \"startTime\": \"13:00\",\n" +
                "        \"endTime\": \"14:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 7,\n" +
                "        \"startTime\": \"14:00\",\n" +
                "        \"endTime\": \"15:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 8,\n" +
                "        \"startTime\": \"15:00\",\n" +
                "        \"endTime\": \"16:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 9,\n" +
                "        \"startTime\": \"16:00\",\n" +
                "        \"endTime\": \"17:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6777501735872237568\",\n" +
                "          \"name\": \"沈名\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6781093001763622912\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 10,\n" +
                "        \"startTime\": \"17:00\",\n" +
                "        \"endTime\": \"18:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6777501735872237568\",\n" +
                "          \"name\": \"沈名\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6781093001763622912\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 11,\n" +
                "        \"startTime\": \"18:00\",\n" +
                "        \"endTime\": \"19:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 12,\n" +
                "        \"startTime\": \"19:00\",\n" +
                "        \"endTime\": \"20:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2021-03-27\",\n" +
                "    \"info\": [\n" +
                "      {\n" +
                "        \"sequence\": 1,\n" +
                "        \"startTime\": \"08:00\",\n" +
                "        \"endTime\": \"09:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214530129465344\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 2,\n" +
                "        \"startTime\": \"09:00\",\n" +
                "        \"endTime\": \"10:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214530129465344\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 3,\n" +
                "        \"startTime\": \"10:00\",\n" +
                "        \"endTime\": \"11:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 4,\n" +
                "        \"startTime\": \"11:00\",\n" +
                "        \"endTime\": \"12:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 5,\n" +
                "        \"startTime\": \"12:00\",\n" +
                "        \"endTime\": \"13:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 6,\n" +
                "        \"startTime\": \"13:00\",\n" +
                "        \"endTime\": \"14:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 7,\n" +
                "        \"startTime\": \"14:00\",\n" +
                "        \"endTime\": \"15:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 8,\n" +
                "        \"startTime\": \"15:00\",\n" +
                "        \"endTime\": \"16:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 9,\n" +
                "        \"startTime\": \"16:00\",\n" +
                "        \"endTime\": \"17:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 10,\n" +
                "        \"startTime\": \"17:00\",\n" +
                "        \"endTime\": \"18:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 11,\n" +
                "        \"startTime\": \"18:00\",\n" +
                "        \"endTime\": \"19:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 12,\n" +
                "        \"startTime\": \"19:00\",\n" +
                "        \"endTime\": \"20:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"date\": \"2021-03-28\",\n" +
                "    \"info\": [\n" +
                "      {\n" +
                "        \"sequence\": 1,\n" +
                "        \"startTime\": \"08:00\",\n" +
                "        \"endTime\": \"09:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214533841424384\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 2,\n" +
                "        \"startTime\": \"09:00\",\n" +
                "        \"endTime\": \"10:00\",\n" +
                "        \"group\": {\n" +
                "          \"id\": \"6778214431659790336\",\n" +
                "          \"name\": \"峨语文班\",\n" +
                "          \"length\": 2,\n" +
                "          \"scheduleId\": \"6778214533841424384\"\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 3,\n" +
                "        \"startTime\": \"10:00\",\n" +
                "        \"endTime\": \"11:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 4,\n" +
                "        \"startTime\": \"11:00\",\n" +
                "        \"endTime\": \"12:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 5,\n" +
                "        \"startTime\": \"12:00\",\n" +
                "        \"endTime\": \"13:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 6,\n" +
                "        \"startTime\": \"13:00\",\n" +
                "        \"endTime\": \"14:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 7,\n" +
                "        \"startTime\": \"14:00\",\n" +
                "        \"endTime\": \"15:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 8,\n" +
                "        \"startTime\": \"15:00\",\n" +
                "        \"endTime\": \"16:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 9,\n" +
                "        \"startTime\": \"16:00\",\n" +
                "        \"endTime\": \"17:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 10,\n" +
                "        \"startTime\": \"17:00\",\n" +
                "        \"endTime\": \"18:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 11,\n" +
                "        \"startTime\": \"18:00\",\n" +
                "        \"endTime\": \"19:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"sequence\": 12,\n" +
                "        \"startTime\": \"19:00\",\n" +
                "        \"endTime\": \"20:00\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";


    Schedule.getScheduleId(content,"2021-03-26",9);



    }
}
