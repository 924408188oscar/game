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
        //       System.out.println("11111111111111111111111111111111");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject;
            jsonObject = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象

            if (!jsonObject.isEmpty()) {
                String name = "1";
                if (!key.isEmpty()) {
                    name = jsonObject.getString(key);

                    if(null != name) {
                        if (name.equals(keyValue) & !id.isEmpty()) {

                            value = jsonObject.getString("id");
                            System.out.println(value);
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


        String req = "[\n" +
                "  {\n" +
                "    \"id\": \"6699567227856883712\",\n" +
                "    \"name\": \"默认\",\n" +
                "    \"type\": 1,\n" +
                "    \"objectType\": \"group\",\n" +
                "    \"roles\": [\n" +
                "      {\n" +
                "        \"id\": \"6699567227886243840\",\n" +
                "        \"createdAt\": \"2020-08-13T06:48:19.081064Z\",\n" +
                "        \"updatedAt\": \"2020-08-13T06:48:19.081064Z\",\n" +
                "        \"createdBy\": \"6699565169288286208\",\n" +
                "        \"name\": \"主管\",\n" +
                "        \"groupId\": \"6699567227856883712\",\n" +
                "        \"type\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"6699567227911409664\",\n" +
                "        \"createdAt\": \"2020-08-13T06:48:19.083259Z\",\n" +
                "        \"updatedAt\": \"2020-08-13T06:48:19.083259Z\",\n" +
                "        \"createdBy\": \"6699565169288286208\",\n" +
                "        \"name\": \"负责\",\n" +
                "        \"groupId\": \"6699567227856883712\",\n" +
                "        \"type\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"6699567227919798272\",\n" +
                "        \"createdAt\": \"2020-08-13T06:48:19.085666Z\",\n" +
                "        \"updatedAt\": \"2020-08-13T06:48:19.085666Z\",\n" +
                "        \"createdBy\": \"6699565169288286208\",\n" +
                "        \"name\": \"主管理员\",\n" +
                "        \"groupId\": \"6699567227856883712\",\n" +
                "        \"type\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"6699567227928186880\",\n" +
                "        \"createdAt\": \"2020-08-13T06:48:19.087595Z\",\n" +
                "        \"updatedAt\": \"2020-08-13T06:48:19.087595Z\",\n" +
                "        \"createdBy\": \"6699565169288286208\",\n" +
                "        \"name\": \"子管理员\",\n" +
                "        \"groupId\": \"6699567227856883712\",\n" +
                "        \"type\": 1\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"6699567227936575488\",\n" +
                "        \"createdAt\": \"2020-08-13T06:48:19.089426Z\",\n" +
                "        \"updatedAt\": \"2020-08-13T06:48:19.089426Z\",\n" +
                "        \"createdBy\": \"6699565169288286208\",\n" +
                "        \"name\": \"组织成员\",\n" +
                "        \"groupId\": \"6699567227856883712\",\n" +
                "        \"type\": 1\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"6699567245963694080\",\n" +
                "    \"name\": \"教学\",\n" +
                "    \"type\": 2,\n" +
                "    \"objectType\": \"group\",\n" +
                "    \"roles\": [\n" +
                "      {\n" +
                "        \"id\": \"6699567247482032128\",\n" +
                "        \"createdAt\": \"2020-08-13T06:48:23.749895Z\",\n" +
                "        \"updatedAt\": \"2020-08-13T06:48:23.749895Z\",\n" +
                "        \"createdBy\": \"6699565169288286208\",\n" +
                "        \"name\": \"老师\",\n" +
                "        \"groupId\": \"6699567245963694080\",\n" +
                "        \"type\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"6706764905862795264\",\n" +
                "        \"createdAt\": \"2020-09-02T03:29:19.233420Z\",\n" +
                "        \"updatedAt\": \"2020-09-02T03:29:19.233420Z\",\n" +
                "        \"createdBy\": \"6699565169288286208\",\n" +
                "        \"name\": \"辅导\",\n" +
                "        \"groupId\": \"6699567245963694080\",\n" +
                "        \"type\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"6708924806257053696\",\n" +
                "        \"createdAt\": \"2020-09-08T02:31:59.621783Z\",\n" +
                "        \"updatedAt\": \"2020-09-08T02:31:59.621783Z\",\n" +
                "        \"createdBy\": \"6699582508113203200\",\n" +
                "        \"name\": \"语文老师\",\n" +
                "        \"groupId\": \"6699567245963694080\",\n" +
                "        \"type\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"6710455717347856384\",\n" +
                "        \"createdAt\": \"2020-09-12T07:55:17.268158Z\",\n" +
                "        \"updatedAt\": \"2020-09-12T07:55:17.268158Z\",\n" +
                "        \"createdBy\": \"6699582508113203200\",\n" +
                "        \"name\": \"班主\",\n" +
                "        \"groupId\": \"6699567245963694080\",\n" +
                "        \"type\": 2\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "]";

        System.out.println(roleAllGetRoldId(req, "老师"));

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






