package cn.oscar.common;

import java.util.UUID;

public class Temp {
    public static void main(String[] args) {
        String chinse= "中在人工111";

        System.out.println(chinse);
        String uuid = UUID.randomUUID().toString();
        String data="{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": \"6739787231311040512\",\n" +
                "      \"pubFamilyId\": \"6737539320107896832\",\n" +
                "      \"pubFamilyName\": \"张朋曲\",\n" +
                "      \"phone\": \"15800162587\",\n" +
                "      \"stuName\": \"张朋\",\n" +
                "      \"stuGender\": 1,\n" +
                "      \"stuGrade\": \"四年级\",\n" +
                "      \"stuSchool\": \"学军小学\",\n" +
                "      \"channel\": \"走访\",\n" +
                "      \"channelId\": \"6737538693847977984\",\n" +
                "      \"escortType\": 1,\n" +
                "      \"inviter\": \"李若亮\",\n" +
                "      \"promiseDateTime\": \"2020-12-03T04:00:00Z\",\n" +
                "      \"approveId\": \"6739795500511535104\",\n" +
                "      \"status\": 1,\n" +
                "      \"createdAt\": \"2020-12-02T06:28:15.179463Z\",\n" +
                "      \"visibleRevisit\": 1,\n" +
                "      \"visibleAbsent\": 0,\n" +
                "      \"visibleAlter\": 1,\n" +
                "      \"visitingPurpose\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6739784837613359104\",\n" +
                "      \"pubFamilyId\": \"6737539320107896832\",\n" +
                "      \"pubFamilyName\": \"张朋曲\",\n" +
                "      \"phone\": \"15800162587\",\n" +
                "      \"stuName\": \"张朋\",\n" +
                "      \"stuGender\": 1,\n" +
                "      \"stuGrade\": \"四年级\",\n" +
                "      \"stuSchool\": \"学军小学\",\n" +
                "      \"channel\": \"网络\",\n" +
                "      \"channelId\": \"6737538694485512192\",\n" +
                "      \"escortType\": 4,\n" +
                "      \"inviter\": \"李若亮\",\n" +
                "      \"promiseDateTime\": \"2020-12-03T06:07:10.951Z\",\n" +
                "      \"status\": 1,\n" +
                "      \"createdAt\": \"2020-12-02T06:18:44.480586Z\",\n" +
                "      \"visibleRevisit\": 1,\n" +
                "      \"visibleAbsent\": 0,\n" +
                "      \"visibleAlter\": 1,\n" +
                "      \"visitingPurpose\": 5\n" +
                "    }\n" +
                "  ],\n" +
                "  \"total\": 2  \n" +
                "}";

        String cc=JsonTest.getArrayNoKeyId(data,"data","approveId","id");
        System.out.println(cc);


    }
}
