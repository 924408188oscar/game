package cn.oscar.sigmayun;

import java.util.UUID;
//自定义--我的到访模板
public class MyVisitTemplate {

    public static String getBody(String uuid, String UserId, String name) {
        String template = "{\n" +
                "  \"formJson\": [\n" +
                "    {\n" +
                "      \"componentName\": \"SsDate\",\n" +
                "      \"props\": {\n" +
                "        \"label\": \"日期\",\n" +
                "        \"placeholder\": \"请选择\",\n" +
                "        \"required\": true,\n" +
                "        \"print\": true,\n" +
                "        \"limitSwitch\": false,\n" +
                "        \"type\": \"datetime\",\n" +
                "        \"limitType\": 1,\n" +
                "        \"id\": \""+getUUID()+"\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"componentName\": \"Textarea\",\n" +
                "      \"props\": {\n" +
                "        \"label\": \"到访内容\",\n" +
                "        \"placeholder\": \"请输入\",\n" +
                "        \"required\": true,\n" +
                "        \"editable\": true,\n" +
                "        \"print\": true,\n" +
                "        \"count\": 8000,\n" +
                "        \"id\": \""+getUUID()+"\"\n" +
                "      }\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"我的到访\",\n" +
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
                "  \"funcIdRelationDtoList\": [\n" +
                "    {\n" +
                "      \"funcRootId\": \"SalesManage\",\n" +
                "      \"funcSecondId\": \"MyVisit\",\n" +
                "      \"funcSubId\": \"MyVisitConsultationPlan\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"templateKey\": \""+getUUID()+"\"\n" +
                "}";

        return template;


    }


    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();


        String cc=getBody(uuid,"1111111111111111", "name");
        System.out.println(cc);



    }


}
