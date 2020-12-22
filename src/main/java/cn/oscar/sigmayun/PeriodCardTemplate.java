package cn.oscar.sigmayun;

import java.util.UUID;

//自定义表单--学员课时卡表单模板
public class PeriodCardTemplate {
    public static String getBody(String uuid, String roleId, String roleName) {
        String template="{\n" +
                "  \"formJson\": [\n" +
                "    {\n" +
                "      \"componentName\": \"RefundApprove\",\n" +
                "      \"props\": {\n" +
                "        \"id\": \""+uuid+"\"\n" +
                "      },\n" +
                "      \"children\": [\n" +
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
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单编号\",\n" +
                "            \"placeholder\": \"请输入\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"orderId\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"NumberInput\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单课时\",\n" +
                "            \"placeholder\": \"请输入数字\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"integer\": false,\n" +
                "            \"numberRange\": false,\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"orderPeriod\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"NumberInput\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单金额\",\n" +
                "            \"placeholder\": \"请输入数字\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"integer\": false,\n" +
                "            \"numberRange\": false,\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"orderAmount\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单签约时间\",\n" +
                "            \"placeholder\": \"请输入\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"orderTime\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单签约人\",\n" +
                "            \"placeholder\": \"请输入\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"orderSubmitter\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Group\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"退费区域\",\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"refundPeriodCardList\",\n" +
                "            \"children\": [\n" +
                "              {\n" +
                "                \"componentName\": \"Input\",\n" +
                "                \"props\": {\n" +
                "                  \"label\": \"课时卡编号\",\n" +
                "                  \"placeholder\": \"请输入\",\n" +
                "                  \"required\": true,\n" +
                "                  \"editable\": true,\n" +
                "                  \"print\": true,\n" +
                "                  \"format\": \"none\",\n" +
                "                  \"id\": \""+uuid+"\",\n" +
                "                  \"alias\": \"id\"\n" +
                "                }\n" +
                "              },\n" +
                "              {\n" +
                "                \"componentName\": \"Input\",\n" +
                "                \"props\": {\n" +
                "                  \"label\": \"退费科目\",\n" +
                "                  \"placeholder\": \"请输入\",\n" +
                "                  \"required\": true,\n" +
                "                  \"editable\": true,\n" +
                "                  \"print\": true,\n" +
                "                  \"format\": \"none\",\n" +
                "                  \"id\": \""+uuid+"\",\n" +
                "                  \"alias\": \"name\"\n" +
                "                }\n" +
                "              },\n" +
                "              {\n" +
                "                \"componentName\": \"NumberInput\",\n" +
                "                \"props\": {\n" +
                "                  \"label\": \"退费课时\",\n" +
                "                  \"placeholder\": \"请输入数字\",\n" +
                "                  \"required\": true,\n" +
                "                  \"editable\": true,\n" +
                "                  \"print\": true,\n" +
                "                  \"integer\": false,\n" +
                "                  \"numberRange\": false,\n" +
                "                  \"id\": \""+uuid+"\",\n" +
                "                  \"alias\": \"period\"\n" +
                "                }\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"NumberInput\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"合计退费课时\",\n" +
                "            \"placeholder\": \"请输入数字\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"integer\": false,\n" +
                "            \"numberRange\": false,\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"refundPeriod\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"NumberInput\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"合计退费金额\",\n" +
                "            \"placeholder\": \"请输入数字\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"integer\": false,\n" +
                "            \"numberRange\": false,\n" +
                "            \"id\": \""+uuid+"\",\n" +
                "            \"alias\": \"refundAmount\"\n" +
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
                "            \"alias\": \"refundSubmitter\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"退费原因\",\n" +
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
                "  \"name\": \"课时卡表单\",\n" +
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
                "            \"id\": \""+roleId+"\",\n" +
                "            \"name\": \""+roleName+"\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"suiteType\": \"RefundApprove\",\n" +
                "  \"funcIdRelationDtoList\": [\n" +
                "    {\n" +
                "      \"funcRootId\": \"SalesManage\",\n" +
                "      \"funcSecondId\": \"PeriodCard\",\n" +
                "      \"funcSubId\": \"PeriodCardAuditManageRefund\"\n" +
                "    }\n" +
                "  ],\n" +
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


        String cc=getBody(uuid,"1111111111111111", "老师");
        System.out.println(cc);



    }



}
