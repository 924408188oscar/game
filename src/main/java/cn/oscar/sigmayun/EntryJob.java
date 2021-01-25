package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

public class EntryJob {
    public static String[] getChildNodeId(String data) {
        //System.out.println("==================test====================");
        String[] id = {"0","0","0"};
        try {
            JSONObject jsonObject, jsonObject1;
            jsonObject = JSONObject.parseObject(data);

            jsonObject = jsonObject.getJSONObject("procTemplate");
            jsonObject = jsonObject.getJSONObject("body");
            jsonObject1 = jsonObject.getJSONObject("childNode");
            //System.out.println(jsonObject.toString());

            id[1]=jsonObject1.getString("id");
            jsonObject1 = jsonObject1.getJSONObject("childNode");
            id[2] = jsonObject1.getString("id");
            // System.out.println(id[1]);
            jsonObject = JSONObject.parseObject(data);
            jsonObject = jsonObject.getJSONObject("formTemplate");
            jsonObject = jsonObject.getJSONObject("flowFormTemplate");
            JSONArray jsonArray;
            jsonArray = parseArray(jsonObject.getString("body"));//把string改变为Json数组
            //System.out.println(jsonArray.toString());
            if ( !jsonArray.isEmpty() ) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    // System.out.println("---------------" + result);
                    JSONObject inJsonObject;
                    JSONObject inJsonObject1;
                    inJsonObject = (JSONObject) jsonArray.getJSONObject(i);
                    inJsonObject1 = inJsonObject.getJSONObject("props");
                    id[0] = inJsonObject1.getString("id");
                    // System.out.println(id[0]);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");

        }


        return id;
    }

    public static void main(String[] args) {
        String content="{\n" +
                "  \"formTemplate\": {\n" +
                "    \"flowFormTemplate\": {\n" +
                "      \"id\": \"6755408361958940672\",\n" +
                "      \"createdAt\": \"2021-01-14T09:01:02.928073Z\",\n" +
                "      \"body\": \"[{\\\"props\\\": {\\\"id\\\": \\\"d9dd5ae2-b51f-4df5-b2a6-f1c0a433543b\\\", \\\"type\\\": \\\"datetime\\\", \\\"label\\\": \\\"日期\\\", \\\"print\\\": true, \\\"required\\\": true, \\\"limitType\\\": 1, \\\"limitSwitch\\\": false, \\\"placeholder\\\": \\\"请选择\\\"}, \\\"componentName\\\": \\\"SsDate\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"8b593a65-34f7-4b84-bd27-1aaba382ec19\\\", \\\"count\\\": 8000, \\\"label\\\": \\\"多行输入框\\\", \\\"print\\\": true, \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Textarea\\\"}]\",\n" +
                "      \"name\": \"我的学员\",\n" +
                "      \"updatedAt\": \"2021-01-14T09:01:02.928073Z\",\n" +
                "      \"createdBy\": \"6754231404416077824\",\n" +
                "      \"isEnabled\": 0,\n" +
                "      \"type\": 0,\n" +
                "      \"conditionComponents\": \"[]\",\n" +
                "      \"platform\": 3,\n" +
                "      \"approvalComponents\": \"[]\"\n" +
                "    },\n" +
                "    \"funcIdRelationDtoList\": [\n" +
                "      {\n" +
                "        \"funcRootId\": \"CustomerManage\",\n" +
                "        \"funcSecondId\": \"MyStudent\",\n" +
                "        \"funcSubId\": \"MyStudentParentMeet\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"funcRootId\": \"CustomerManage\",\n" +
                "        \"funcSecondId\": \"MyStudent\",\n" +
                "        \"funcSubId\": \"MyStudentTeacherMeet\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"funcRootId\": \"CustomerManage\",\n" +
                "        \"funcSecondId\": \"MyStudent\",\n" +
                "        \"funcSubId\": \"MyStudentVisit\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"procTemplate\": {\n" +
                "    \"id\": \"6755408361958940672\",\n" +
                "    \"createdAt\": \"2021-01-14T09:01:02.920918Z\",\n" +
                "    \"createdBy\": \"6754231404416077824\",\n" +
                "    \"updatedAt\": \"2021-01-14T09:01:02.920918Z\",\n" +
                "    \"status\": \"user_enable\",\n" +
                "    \"templateKey\": \"e144e761-a674-4a9c-90d2-bd84777b6022\",\n" +
                "    \"body\": \"{\\\"id\\\": \\\"63bd5da7-f6e9-483f-838a-35d3aa141cc1\\\", \\\"name\\\": \\\"发起人\\\", \\\"type\\\": \\\"initiator\\\", \\\"childNode\\\": {\\\"id\\\": \\\"91bf23e2-e141-4a72-8b7a-eb389f193c08\\\", \\\"name\\\": \\\"审批人\\\", \\\"type\\\": \\\"approve\\\", \\\"owner\\\": {\\\"list\\\": [{\\\"id\\\": \\\"6754231023392919552\\\", \\\"name\\\": \\\"老师\\\"}], \\\"type\\\": \\\"2\\\"}, \\\"visible\\\": true, \\\"childNode\\\": {\\\"id\\\": \\\"a0352c4d-1204-4163-943c-de9ad5e40a43\\\", \\\"name\\\": \\\"抄送人\\\", \\\"type\\\": \\\"carbonCopy\\\", \\\"owner\\\": {\\\"list\\\": [], \\\"type\\\": \\\"1\\\"}, \\\"roleRange\\\": \\\"mechanism\\\", \\\"chooseCopyer\\\": true}, \\\"roleRange\\\": \\\"mechanism\\\", \\\"approveType\\\": \\\"or\\\", \\\"emptyHandle\\\": \\\"0\\\", \\\"approveOpinion\\\": false, \\\"isSubmitManager\\\": false}}\"\n" +
                "  }\n" +
                "}";

        String[] aa={"1","2","3"};

        aa=getChildNodeId(content);
        System.out.println(aa[0]+"\n"+aa[1]+"\n"+aa[2]);

    }


}
