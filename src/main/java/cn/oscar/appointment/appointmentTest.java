package cn.oscar.appointment;

public class appointmentTest {
    public static void main(String[] args) {
        JsonRootBean jsonRootBean = new JsonRootBean();
        jsonRootBean.setStartUserName("李若亮");
        jsonRootBean.setTemplateId("tempid11111111");
        jsonRootBean.setTemplateKey("tempKey11111");

        FormValue formValue=new FormValue();


        String data="{\n" +
                "  \"formTemplate\": {\n" +
                "    \"flowFormTemplate\": {\n" +
                "      \"id\": \"6739478319387123712\",\n" +
                "      \"createdAt\": \"2020-12-01T10:00:44.809369Z\",\n" +
                "      \"body\": \"[{\\\"props\\\": {\\\"id\\\": \\\"8ada0b1f-49fa-4c64-b370-cd672648d2af\\\", \\\"type\\\": \\\"datetime\\\", \\\"label\\\": \\\"日期\\\", \\\"print\\\": true, \\\"required\\\": true, \\\"limitType\\\": 1, \\\"limitSwitch\\\": false, \\\"placeholder\\\": \\\"请选择\\\"}, \\\"componentName\\\": \\\"SsDate\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"914602ea-2902-41cb-9a23-14d747c0a3b4\\\", \\\"label\\\": \\\"客户名称\\\", \\\"print\\\": true, \\\"format\\\": \\\"none\\\", \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入客户名\\\"}, \\\"componentName\\\": \\\"Input\\\"}, {\\\"props\\\": {\\\"id\\\": \\\"a4d79da9-e78b-4787-81b3-0eace448d43d\\\", \\\"count\\\": 8000, \\\"label\\\": \\\"内容记录\\\", \\\"print\\\": true, \\\"editable\\\": true, \\\"required\\\": true, \\\"placeholder\\\": \\\"请输入\\\"}, \\\"componentName\\\": \\\"Textarea\\\"}]\",\n" +
                "      \"name\": \"我的家长\",\n" +
                "      \"updatedAt\": \"2020-12-01T10:00:44.809369Z\",\n" +
                "      \"createdBy\": \"6716553800968179712\",\n" +
                "      \"isEnabled\": 0,\n" +
                "      \"type\": 0,\n" +
                "      \"conditionComponents\": \"[]\",\n" +
                "      \"platform\": 3,\n" +
                "      \"approvalComponents\": \"[]\"\n" +
                "    },\n" +
                "    \"funcIdRelationDtoList\": [\n" +
                "      {\n" +
                "        \"funcRootId\": \"CustomerManage\",\n" +
                "        \"funcSecondId\": \"MyCustomer\",\n" +
                "        \"funcSubId\": \"MyCustomerConsultationPlan\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"funcRootId\": \"CustomerManage\",\n" +
                "        \"funcSecondId\": \"MyCustomer\",\n" +
                "        \"funcSubId\": \"MyCustomerConsultationRecord\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"funcRootId\": \"CustomerManage\",\n" +
                "        \"funcSecondId\": \"MyCustomer\",\n" +
                "        \"funcSubId\": \"MyCustomerTrackRecord\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"procTemplate\": {\n" +
                "    \"id\": \"6739478319387123712\",\n" +
                "    \"createdAt\": \"2020-12-01T10:00:44.803573Z\",\n" +
                "    \"createdBy\": \"6716553800968179712\",\n" +
                "    \"updatedAt\": \"2020-12-01T10:00:44.803573Z\",\n" +
                "    \"status\": \"user_enable\",\n" +
                "    \"templateKey\": \"482ffc23-38ed-4bed-9b49-5b8237cecd25\",\n" +
                "    \"body\": \"{\\\"id\\\": \\\"22295937-6918-45b7-a401-de96debd2793\\\", \\\"name\\\": \\\"发起人\\\", \\\"type\\\": \\\"initiator\\\", \\\"childNode\\\": {\\\"id\\\": \\\"985e8e30-a400-42d9-a143-34f9af756f65\\\", \\\"name\\\": \\\"审批人\\\", \\\"type\\\": \\\"approve\\\", \\\"owner\\\": {\\\"list\\\": [{\\\"id\\\": \\\"6737538566039146496\\\", \\\"name\\\": \\\"老师\\\"}], \\\"type\\\": \\\"2\\\"}, \\\"visible\\\": true, \\\"childNode\\\": {\\\"id\\\": \\\"a36a67dd-1961-4403-9def-c76319c79359\\\", \\\"name\\\": \\\"抄送人\\\", \\\"type\\\": \\\"carbonCopy\\\", \\\"owner\\\": {\\\"list\\\": [], \\\"type\\\": \\\"1\\\"}, \\\"roleRange\\\": \\\"mechanism\\\", \\\"chooseCopyer\\\": true}, \\\"roleRange\\\": \\\"mechanism\\\", \\\"approveType\\\": \\\"or\\\", \\\"emptyHandle\\\": \\\"0\\\", \\\"approveOpinion\\\": false, \\\"isSubmitManager\\\": false}}\"\n" +
                "  }\n" +
                "}";


        String[] aa;
        aa=TasksBody.getUUIDvalue(data);
        int i=0;
       while (i<2){
            System.out.println(aa[i]);
        i++;
        }

    }


}
