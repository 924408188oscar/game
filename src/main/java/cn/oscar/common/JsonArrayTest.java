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
    //json数组：通过key与keyvalue 去取另一个id的value
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

                            value = jsonObject.getString(id);
                           // System.out.println(value);
                        }
                    }
                }

            }
        }

        return value;
    }

    //获取转课时3组课时ID和课时名称
    public static String[] getPeriodCards(String data,String key,String keyValue,String node){
        String[] result={"0","0","0","0","0","0","0","0","0"};
        JSONArray jsonArray,nodeArray;
        jsonArray = parseArray(data);
        for (int i = 0; i < jsonArray.size(); i++) {
            // System.out.println("---------------" + result);
            JSONObject jsonObject;
            jsonObject = (JSONObject) jsonArray.getJSONObject(i);
            String value=jsonObject.getString(key);

            if(value.equals(keyValue)) {
                System.out.println("===:"+value);
                if ( !node.isEmpty() ) {
                    nodeArray = jsonObject.getJSONArray(node);
                    if ( !nodeArray.isEmpty() ) {
                        for (int j = 0; j < nodeArray.size(); j++) {
                            if ( j > 2 ) break;
                            JSONObject nodeObject;
                            nodeObject = (JSONObject) nodeArray.getJSONObject(j);
                            result[j] = nodeObject.getString("id");
                            result[j + 3] = nodeObject.getString("name");
                            result[j + 6] = nodeObject.getString("version");

                        }
                    }
                }
            }
        }



        return result;
    }
    public static void main(String[] args) {
        String content= "{\n" +

                "}";

        String[] periodMax=JsonArrayTest.getPeriodCards(content,"id","6778562063146029056","children");


     for(int q = 0;q<9;q++){
            System.out.println(periodMax[q]);
        }
    }

}






