package cn.oscar.sigmayun;

import java.util.UUID;

//添加资料库 表单
public class DataLibrary {
    public static String getBody(String uuid, String UserId, String name) {
        String content="{\n" +
                "  \"formJson\": [\n" +
                "    {\n" +
                "      \"componentName\": \"Lecture\",\n" +
                "      \"props\": {\n" +
                "        \"id\": \""+getUUID()+"\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"讲义\",\n" +
                "  \"type\": 0,\n" +
                "  \"platform\": 3,\n" +
                "  \"conditionComponents\": [],\n" +
                "  \"approvalComponents\": [],\n" +
                "  \"procJson\": {\n" +
                "    \"id\": \""+getUUID()+"\",\n" +
                "    \"type\": \"initiator\",\n" +
                "    \"name\": \"发起人\",\n" +
                "    \"childNode\": {\n" +
                "      \"id\": \""+getUUID()+"\",\n" +
                "      \"type\": \"approve\",\n" +
                "      \"name\": \"审批人\",\n" +
                "      \"childNode\": {\n" +
                "        \"id\": \""+getUUID()+"\",\n" +
                "        \"type\": \"carbonCopy\",\n" +
                "        \"name\": \"抄送人\",\n" +
                "        \"chooseCopyer\": true,\n" +
                "        \"roleRange\": \"mechanism\",\n" +
                "        \"owner\": {\n" +
                "          \"type\": \"1\",\n" +
                "          \"list\": []\n" +
                "        }\n" +
                "      },\n" +
                "      \"approveType\": \"or\",\n" +
                "      \"approveOpinion\": false,\n" +
                "      \"visible\": true,\n" +
                "      \"emptyHandle\": \"0\",\n" +
                "      \"isSubmitManager\": false,\n" +
                "      \"roleRange\": \"mechanism\",\n" +
                "      \"owner\": {\n" +
                "        \"type\": \"2\",\n" +
                "        \"list\": [\n" +
                "          {\n" +
                "            \"id\": \""+UserId+"\",\n" +
                "            \"name\": \""+name+"\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"suiteType\": \"Lecture\",\n" +
                "  \"funcIdRelationDtoList\": [\n" +
                "    {\n" +
                "      \"funcRootId\": \"PersonalService\",\n" +
                "      \"funcSecondId\": \"DataLibrary\",\n" +
                "      \"funcSubId\": \"DataLibraryLectureNotes\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"templateKey\": \""+getUUID()+"\"\n" +
                "}";

        return content;

    }
    public static String getUUID() {
        return UUID.randomUUID().toString();

    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();


        String cc = getBody(uuid, "1111111111111111", "name");
        System.out.println(cc);


    }
}
