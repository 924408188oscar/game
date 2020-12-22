package cn.oscar.sigmayun;

import java.util.UUID;
//自定义表单--推荐表单
public class RecommendTemplate {

    public static String getBody(String uuid, String UserId, String name) {
        String template="{\n" +
                "  \"formJson\": [\n" +
                "    {\n" +
                "      \"componentName\": \"Recommendation\",\n" +
                "      \"props\": {\n" +
                "        \"validDays\": 3,\n" +
                "        \"id\": \""+uuid+"\"\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"家长姓名\",\n" +
                "            \"placeholder\": \"请输入\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"parentName\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"家长联系方式\",\n" +
                "            \"placeholder\": \"请输入\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"parentContact\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"学员姓名\",\n" +
                "            \"placeholder\": \"请输入\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"studentName\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"SsContact\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"提交人\",\n" +
                "            \"placeholder\": \"请选择\",\n" +
                "            \"initialValue\": [],\n" +
                "            \"required\": false,\n" +
                "            \"print\": true,\n" +
                "            \"multiple\": true,\n" +
                "            \"type\": \"dep\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"submitter\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"推荐单\",\n" +
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
                "  \"suiteType\": \"Recommendation\",\n" +
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

        return  template;
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
