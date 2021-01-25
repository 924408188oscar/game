package cn.oscar.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSONArray.*;

public class JsonArrayTest {

    //抽取json数组中的每个数组某个字段Key []字符
    public static String[] JsonArrayToJA(String data, String key) {
        String resultArray[] = new String[]{"0", "0"};
        String result = "[\"";

        JSONArray jsonArray;
        jsonArray = parseArray(data);
        resultArray[0] = String.valueOf(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            // System.out.println("---------------" + result);
            JSONObject jsonObject;
            jsonObject = (JSONObject) jsonArray.getJSONObject(i);
            result = result + jsonObject.getString("id") + "\",\"";

        }
        result = result.substring(0, result.length() - 2) + "]";
        resultArray[1] = result;

        System.out.println(resultArray[1]);
        System.out.println(resultArray[0]);
        return resultArray;


    }


    //获取roleall接口某个角色的id
    public static String roleAllGetRoldId(String data, String rold) {
        String id = "";
        JSONArray jsonArray;
        jsonArray = parseArray(data);//把string改变为Json数组
        //       System.out.println("11111111111111111111111111111111");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject;
            jsonObject = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象
            try {
                JSONArray rolesJSONArray = new JSONArray();
                int x=0;
                if (!jsonObject.isEmpty()) {
                    rolesJSONArray = jsonObject.getJSONArray("roles"); //获取roles数组
                    if(rolesJSONArray.size()>0)
                    { x= rolesJSONArray.size();}
                    for (int j = 0; j < x; j++) {
                        JSONObject rolejsonObject;
                        rolejsonObject = (JSONObject) rolesJSONArray.getJSONObject(j);

                        String name;
                        name = rolejsonObject.getString("name");


                        if (name.equals(rold)) {
                            id = rolejsonObject.getString("id");
                        }

                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return id;
    }
    //通过key与keyvalue 去取另一个id的value
    public static String jsonArrayGetId(String data, String key,String keyValue,String id) {
        String value = "";
        JSONArray jsonArray;
        jsonArray = parseArray(data);//把string改变为Json数组
        //System.out.println(data);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject;
            jsonObject = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象

            if (!jsonObject.isEmpty()) {
                String name = "1";
                if (!key.isEmpty()) {
                    name = jsonObject.getString(key);

                    if(null != name) {
                        if (name.contains(keyValue) & !id.isEmpty()) {

                            value = jsonObject.getString("id");
                           // System.out.println(value);
                        }
                    }
                }

            }
        }

        return value;
    }


    public static void main(String[] args) {


//        String resq_data = "[{\"id\":\"6699567235670872064\",\"name\":\"人事\"},{\"id\":\"6699567236815917056\",\"name\":\"市场\"},{\"id\":\"6699567237902241792\",\"name\":\"学管\"},{\"id\":\"6699567239575769088\",\"name\":\"教学\"},{\"id\":\"6699567240125222912\",\"name\":\"运营\"},{\"id\":\"6704936633520754688\",\"name\":\"客服\"},{\"id\":\"6708924638287761408\",\"name\":\"语文\"},{\"id\":\"6712181918340878336\",\"name\":\"行政\"}]";
//
//        System.out.println(resq_data);
//        String[] aa = JsonArrayToJA(resq_data, "id");
//
//        System.out.println(aa[0]);
//        System.out.println(aa[1]);


        String req ="[\n" +
                "    {\n" +
                "        \"createdAt\": \"2020-12-04T00:59:27.424050Z\",\n" +
                "        \"createdBy\": \"6730355031876440064\",\n" +
                "        \"approvalComponents\": \"[]\",\n" +
                "        \"isEnabled\": 0,\n" +
                "        \"name\": \"推荐单\",\n" +
                "        \"icon\": \"http:\\/\\/qiniu.sishuxuefu.com\\/tiansiyu\\/20191113\\/lbr7QOtdS4xy.png\",\n" +
                "        \"id\": \"6740429262790336512\",\n" +
                "        \"conditionComponents\": \"[]\",\n" +
                "        \"type\": 1,\n" +
                "        \"platform\": 3,\n" +
                "        \"updatedAt\": \"2020-12-04T00:59:27.424050Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createdAt\": \"2020-12-04T00:59:25.734063Z\",\n" +
                "        \"createdBy\": \"6730355031876440064\",\n" +
                "        \"approvalComponents\": \"[]\",\n" +
                "        \"isEnabled\": 0,\n" +
                "        \"name\": \"离职申请\",\n" +
                "        \"icon\": \"http:\\/\\/qiniu.sishuxuefu.com\\/tiansiyu\\/20191113\\/lbr7QOtdS4xy.png\",\n" +
                "        \"id\": \"6740429255827791872\",\n" +
                "        \"conditionComponents\": \"[]\",\n" +
                "        \"type\": 1,\n" +
                "        \"platform\": 3,\n" +
                "        \"updatedAt\": \"2020-12-04T00:59:25.734063Z\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"createdAt\": \"2020-12-04T00:59:25.429357Z\",\n" +
                "        \"createdBy\": \"6730355031876440064\",\n" +
                "        \"approvalComponents\": \"[]\",\n" +
                "        \"isEnabled\": 0,\n" +
                "        \"name\": \"入职申请\",\n" +
                "        \"icon\": \"http:\\/\\/qiniu.sishuxuefu.com\\/tiansiyu\\/20191113\\/lbr7QOtdS4xy.png\",\n" +
                "        \"id\": \"6740429254502391808\",\n" +
                "        \"conditionComponents\": \"[]\",\n" +
                "        \"type\": 1,\n" +
                "        \"platform\": 3,\n" +
                "        \"updatedAt\": \"2020-12-04T00:59:25.429357Z\"\n" +
                "    }\n" +
                "]";

        System.out.println("1111:"+jsonArrayGetId(req, "name","入职","id"));

        JsonArrayToJA(req,"id");

        String aa="[\n" +
                "  {\n" +
                "    \"id\": \"6573027021901926400\",\n" +
                "    \"value\": \"1111\",\n" +
                "    \"sort\": 1\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"6573027021901926401\",\n" +
                "    \"value\": \"2222\",\n" +
                "    \"sort\": 2\n" +
                "  },\n" +
                "]";


        System.out.println(jsonArrayGetId(aa,"value","2222","id"));

    }


}






