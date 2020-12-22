package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class StudentRefundTemplate {
    public static String getBody(String uuid, String UserId, String name) {
        String template = "{\n" +
                "  \"formJson\": [\n" +
                "    {\n" +
                "      \"componentName\": \"RefundApprove\",\n" +
                "      \"props\": {\n" +
                "        \"id\": \"" + uuid + "\"\n" +
                "      },\n" +
                "      \"children\": [\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"学员姓名\",\n" +
                "            \"placeholder\": \"请输入：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"studentName\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单编号\",\n" +
                "            \"placeholder\": \"请输入：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"orderId\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"NumberInput\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单课时\",\n" +
                "            \"placeholder\": \"请输入数字：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"integer\": false,\n" +
                "            \"numberRange\": false,\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"orderPeriod\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"NumberInput\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单金额\",\n" +
                "            \"placeholder\": \"请输入数字：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"integer\": false,\n" +
                "            \"numberRange\": false,\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"orderAmount\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单签约时间\",\n" +
                "            \"placeholder\": \"请输入：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"orderTime\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"订单签约人：\",\n" +
                "            \"placeholder\": \"请输入：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"orderSubmitter\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Group\",\n" +
                "          \"props\": {\n" +
                "           \"label\":\"还费区域\",\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"refundPeriodCardList\",\n" +
                "            \"children\": [\n" +
                "              {\n" +
                "                \"componentName\": \"Input\",\n" +
                "                \"props\": {\n" +
                "                  \"label\": \"课时卡编号：\",\n" +
                "                  \"placeholder\": \"请输入：\",\n" +
                "                  \"required\": true,\n" +
                "                  \"editable\": true,\n" +
                "                  \"print\": true,\n" +
                "                  \"format\": \"none\",\n" +
                "                  \"id\": \"" + uuid + "\",\n" +
                "                  \"alias\": \"id\"\n" +
                "                }\n" +
                "              },\n" +
                "              {\n" +
                "                \"componentName\": \"Input\",\n" +
                "                \"props\": {\n" +
                "                  \"label\": \"科目\",\n" +
                "                  \"placeholder\": \"请输入：\",\n" +
                "                  \"required\": true,\n" +
                "                  \"editable\": true,\n" +
                "                  \"print\": true,\n" +
                "                  \"format\": \"none\",\n" +
                "                  \"id\": \"" + uuid + "\",\n" +
                "                  \"alias\": \"name\"\n" +
                "                }\n" +
                "              },\n" +
                "              {\n" +
                "                \"componentName\": \"NumberInput\",\n" +
                "                \"props\": {\n" +
                "                  \"label\": \"还费课时\",\n" +
                "                  \"placeholder\": \"请输入数字：\",\n" +
                "                  \"required\": true,\n" +
                "                  \"editable\": true,\n" +
                "                  \"print\": true,\n" +
                "                  \"integer\": false,\n" +
                "                  \"numberRange\": false,\n" +
                "                  \"id\": \"" + uuid + "\",\n" +
                "                  \"alias\": \"period\"\n" +
                "                }\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"NumberInput\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"合计还费课时\",\n" +
                "            \"placeholder\": \"请输入数字：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"integer\": false,\n" +
                "            \"numberRange\": false,\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"refundPeriod\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"NumberInput\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"合计还费金额\",\n" +
                "            \"placeholder\": \"请输入数字：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"integer\": false,\n" +
                "            \"numberRange\": false,\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"refundAmount\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"SsContact\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"提交人：\",\n" +
                "            \"placeholder\": \"请择\",\n" +
                "            \"initialValue\": [],\n" +
                "            \"required\": false,\n" +
                "            \"print\": true,\n" +
                "            \"multiple\": true,\n" +
                "            \"type\": \"dep\",\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"refundSubmitter\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"componentName\": \"Input\",\n" +
                "          \"props\": {\n" +
                "            \"label\": \"还费原因\",\n" +
                "            \"placeholder\": \"请输入：\",\n" +
                "            \"required\": true,\n" +
                "            \"editable\": true,\n" +
                "            \"print\": true,\n" +
                "            \"format\": \"none\",\n" +
                "            \"id\": \"" + uuid + "\",\n" +
                "            \"alias\": \"reason\"\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"name\": \"学员订单入口退费申请\",\n" +
                "  \"type\": 0,\n" +
                "  \"platform\": 3,\n" +
                "  \"conditionComponents\": [],\n" +
                "  \"approvalComponents\": [],\n" +
                "  \"procJson\": {\n" +
                "    \"id\": \"" + getUUID() + "\",\n" +
                "    \"type\": \"initiator\",\n" +
                "    \"name\": \"发起人：\",\n" +
                "    \"childNode\": {\n" +
                "      \"id\": \"" + getUUID() + "\",\n" +
                "      \"type\": \"approve\",\n" +
                "      \"name\": \"审批人：\",\n" +
                "      \"childNode\": {\n" +
                "        \"id\": \"" + getUUID() + "\",\n" +
                "        \"type\": \"carbonCopy\",\n" +
                "        \"name\": \"抄人\",\n" +
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
                "        \"type\": \"1\",\n" +
                "        \"list\": [\n" +
                "          {\n" +
                "            \"userId\": \"" + UserId + "\",\n" +
                "            \"name\": \"" + name + "\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"suiteType\": \"RefundApprove\",\n" +
                "  \"funcIdRelationDtoList\": [\n" +
                "    {\n" +
                "      \"funcRootId\": \"SalesManage\",\n" +
                "      \"funcSecondId\": \"MyOrders\",\n" +
                "      \"funcSubId\": \"OrdersAuditManageRefund\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"templateKey\": \"" + getUUID() + "\"\n" +
                "}";


        String aa = null;
        try {
            aa = new String(template.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return aa;

    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();


        String cc = getBody(uuid, "1111111111111111", "name");
        System.out.println(cc);
        String data = "{\n" +
                "  \"formTemplate\": {\n" +
                "    \"flowFormTemplate\": {\n" +
                "      \"id\": \"6731406123934687232\",\n" +
                "      \"createdAt\": \"2020-11-09T03:24:43.482806Z\",\n" +
                "      \"body\": \"[{\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\"}, \\\"children\\\": [{\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"studentName\\\", \\\"label\\\": \\\"学员姓名\\\", \\\"print\\\": true, \\\"format\\\": \\\"none\\\", \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Input\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"orderId\\\", \\\"label\\\": \\\"订单编号\\\", \\\"print\\\": true, \\\"format\\\": \\\"none\\\", \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Input\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"orderPeriod\\\", \\\"label\\\": \\\"订单课时\\\", \\\"print\\\": true, \\\"integer\\\": false, \\\"editable\\\": true, \\\"required\\\": true, \\\"numberRange\\\": false, \\\"placeholder\\\": \\\"请输入数字\\\"}, \\\"componentName\\\": \\\"NumberInput\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"orderAmount\\\", \\\"label\\\": \\\"订单金额\\\", \\\"print\\\": true, \\\"integer\\\": false, \\\"editable\\\": true, \\\"required\\\": true, \\\"numberRange\\\": false, \\\"placeholder\\\": \\\"请输入数字\\\"}, \\\"componentName\\\": \\\"NumberInput\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"orderTime\\\", \\\"label\\\": \\\"订单签约时间\\\", \\\"print\\\": true, \\\"format\\\": \\\"none\\\", \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Input\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"orderSubmitter\\\", \\\"label\\\": \\\"订单签约人\\\", \\\"print\\\": true, \\\"format\\\": \\\"none\\\", \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Input\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"refundPeriodCardList\\\", \\\"label\\\": \\\"退费区域\\\", \\\"children\\\": [{\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"id\\\", \\\"label\\\": \\\"课时卡编号\\\", \\\"print\\\": true, \\\"format\\\": \\\"none\\\", \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Input\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"name\\\", \\\"label\\\": \\\"退费科目\\\", \\\"print\\\": true, \\\"format\\\": \\\"none\\\", \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Input\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"period\\\", \\\"label\\\": \\\"退费课时\\\", \\\"print\\\": true, \\\"integer\\\": false, \\\"editable\\\": true, \\\"required\\\": true, \\\"numberRange\\\": false, \\\"placeholder\\\": \\\"请输入数字\\\"}, \\\"componentName\\\": \\\"NumberInput\\\"}]}, \\\"componentName\\\": \\\"Group\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"refundPeriod\\\", \\\"label\\\": \\\"合计退费课时\\\", \\\"print\\\": true, \\\"integer\\\": false, \\\"editable\\\": true, \\\"required\\\": true, \\\"numberRange\\\": false, \\\"placeholder\\\": \\\"请输入数字\\\"}, \\\"componentName\\\": \\\"NumberInput\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"refundAmount\\\", \\\"label\\\": \\\"合计退费金额\\\", \\\"print\\\": true, \\\"integer\\\": false, \\\"editable\\\": true, \\\"required\\\": true, \\\"numberRange\\\": false, \\\"placeholder\\\": \\\"请输入数字\\\"}, \\\"componentName\\\": \\\"NumberInput\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"type\\\": \\\"dep\\\", \\\"alias\\\": \\\"refundSubmitter\\\", \\\"label\\\": \\\"提交人\\\", \\\"print\\\": true, \\\"multiple\\\": true, \\\"required\\\": false, \\\"placeholder\\\": \\\"请选择\\\", \\\"initialValue\\\": []}, \\\"componentName\\\": \\\"SsContact\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"66f814ea-8837-4b0b-8e64-07db958684ee\\\", \\\"alias\\\": \\\"reason\\\", \\\"label\\\": \\\"退费原因\\\", \\\"print\\\": true, \\\"format\\\": \\\"none\\\", \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Input\\\"}], \\\"componentName\\\": \\\"RefundApprove\\\"}]\",\n" +
                "      \"name\": \"2323\",\n" +
                "      \"updatedAt\": \"2020-11-09T03:24:43.482806Z\",\n" +
                "      \"createdBy\": \"6699582508113203200\",\n" +
                "      \"isEnabled\": 0,\n" +
                "      \"type\": 0,\n" +
                "      \"conditionComponents\": \"[]\",\n" +
                "      \"platform\": 3,\n" +
                "      \"approvalComponents\": \"[]\"\n" +
                "    },\n" +
                "    \"funcIdRelationDtoList\": [\n" +
                "      {\n" +
                "        \"funcRootId\": \"SalesManage\",\n" +
                "        \"funcSecondId\": \"MyOrders\",\n" +
                "        \"funcSubId\": \"OrdersAuditManageRefund\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"procTemplate\": {\n" +
                "    \"id\": \"6731406123934687232\",\n" +
                "    \"createdAt\": \"2020-11-09T03:24:43.461920Z\",\n" +
                "    \"createdBy\": \"6699582508113203200\",\n" +
                "    \"updatedAt\": \"2020-11-09T03:24:43.461920Z\",\n" +
                "    \"status\": \"user_enable\",\n" +
                "    \"templateKey\": \"76410496-fa6e-4677-88d1-5a7493ce1e19\",\n" +
                "    \"body\": \"{\\\"id\\\": \\\"813a8afd-23b7-4ac6-b59e-cdfc5229b493\\\", \\\"name\\\": \\\"发起人\\\", \\\"type\\\": \\\"initiator\\\", \\\"childNode\\\": {\\\"id\\\": \\\"69ddc2f6-9263-4d43-912c-2f4d09ca9ed1\\\", \\\"name\\\": \\\"审批人\\\", \\\"type\\\": \\\"approve\\\", \\\"owner\\\": {\\\"list\\\": [{\\\"name\\\": \\\"王老师\\\", \\\"userId\\\": \\\"6699582508113203200\\\"}], \\\"type\\\": \\\"1\\\"}, \\\"visible\\\": true, \\\"childNode\\\": {\\\"id\\\": \\\"bbbf4f68-0d84-4fae-916f-7fd1e3f9f9db\\\", \\\"name\\\": \\\"抄送人\\\", \\\"type\\\": \\\"carbonCopy\\\", \\\"owner\\\": {\\\"list\\\": [], \\\"type\\\": \\\"1\\\"}, \\\"roleRange\\\": \\\"mechanism\\\", \\\"chooseCopyer\\\": true}, \\\"roleRange\\\": \\\"mechanism\\\", \\\"approveType\\\": \\\"or\\\", \\\"emptyHandle\\\": \\\"0\\\", \\\"approveOpinion\\\": false, \\\"isSubmitManager\\\": false}}\"\n" +
                "  }\n" +
                "}";

        String[] aa;
        aa = getOwnerInfo(data);
        System.out.println(aa[0]+aa[1]);

    }

    public static String[] getOwnerInfo(String data) {
        String resultArray[] = new String[]{"0", "0"};


        JSONObject jsonObject;
        JSONObject jsonObject1;
        jsonObject = JSONObject.parseObject(data);
        jsonObject1 = jsonObject.getJSONObject("procTemplate");
        jsonObject = jsonObject1.getJSONObject("body");
        jsonObject1 = jsonObject.getJSONObject("childNode");
        jsonObject = jsonObject1.getJSONObject("owner");
        System.out.println(jsonObject.toString());
        JSONArray rolesJSONArray = new JSONArray();
        try {
            if (!jsonObject.isEmpty()) {
                rolesJSONArray = jsonObject.getJSONArray("list");
                int x=0;
                if ( !rolesJSONArray.isEmpty() ) {
                    x = rolesJSONArray.size();
                for (int j = 0; j < x; j++) {
                    JSONObject rolejsonObject;
                    rolejsonObject = (JSONObject) rolesJSONArray.getJSONObject(j);
                    resultArray[0]=rolejsonObject.getString("name");
                    resultArray[1]=rolejsonObject.getString("userId");
                    System.out.println(rolejsonObject.toString());
            }
        }}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultArray;
    }
}
