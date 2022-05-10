package cn.oscar.sigmayun;

import java.util.UUID;

public class DimissionTemplate {
    public static String getBody(String uuid, String UserId, String name,String orgId,String orgName) {

        String template ="{\n" +
                "  \"formJson\": [\n" +
                "    {\n" +
                "      \"componentName\": \"Resignation\",\n" +
                "      \"props\": {\n" +
                "        \"reasonOptions\": [\n" +
                "          \"合同到期不续签\",\n" +
                "          \"职业发展\",\n" +
                "          \"薪资待遇\",\n" +
                "          \"企业管理方式和文化\",\n" +
                "          \"家庭原因\",\n" +
                "          \"个人原因\",\n" +
                "          \"其他\"\n" +
                "        ],\n" +
                "        \"id\": \""+uuid+"\"\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"componentName\": \"SsContact\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"申请人\",\n" +
                "            \"placeholder\": \"请选择\",\n" +
                "            \"initialValue\": [],\n" +
                "            \"required\": false,\n" +
                "            \"print\": true,\n" +
                "            \"multiple\": true,\n" +
                "            \"type\": \"dep\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"applicant\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"入职日期\",\n" +
                "            \"placeholder\": \"请输入\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"entryDate\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"SsDate\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"预计离职日期\",\n" +
                "            \"placeholder\": \"请选择\",\n" +
                "            \"required\": true,\n" +
                "            \"print\": true,\n" +
                "            \"limitSwitch\": false,\n" +
                "            \"type\": \"datetime\",\n" +
                "            \"limitType\": 1,\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"scheduledResignationDate\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"离职原因\",\n" +
                "            \"placeholder\": \"请输入\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"reason\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"离职申请\",\n" +
                "    \"formCategoryId\":\"0\",\n" +
                "    \"visibleOrgs\":[\n" +
                "        {\n" +
                "            \"id\":\""+orgId+"\",\n" +
                "            \"name\":\""+orgName+"\"\n" +
                "        }\n" +
                "    ],\n" +
                "  \"type\": 1,\n" +
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
                "  \"suiteType\": \"Resignation\",\n" +
                "  \"visibleObjects\": [\n" +
                "    {\n" +
                "      \"visibleType\": 2,\n" +
                "      \"visibleValue\": \""+UserId+"\",\n" +
                "      \"visibleName\": \""+name+"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"icon\": \"http://qiniu.sishuxuefu.com/tiansiyu/20191113/lbr7QOtdS4xy.png\",\n" +
                "  \"templateKey\": \""+getUUID()+"\"\n" +
                "}";

        return template;

    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();


        String cc = getBody(uuid, "1111111111111111", "name","135345345","学军中学");
        System.out.println(cc);


    }
}