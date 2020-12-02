package cn.oscar.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

public class JsonTest {

        public static JSONArray getJsonArray(String data, String node) {
            JSONObject jsonObject;
            jsonObject=JSONObject.parseObject(data);

            JSONArray jsonArray;
            jsonArray = parseArray(jsonObject.getString(node));//把string改变为Json数组

            return  jsonArray;
        }

        public static String getNullNodeId(JSONArray jsonArray, String node,  String key){
            String id="0";

            if(!jsonArray.isEmpty()) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    // System.out.println("---------------" + result);
                    JSONObject jsonObject;
                    jsonObject = (JSONObject) jsonArray.getJSONObject(i);
                    JSONArray nodeJSONArray;

                    nodeJSONArray = jsonObject.getJSONArray(node);
                   // System.out.println(nodeJSONArray.toString());

                  //  if(null== nodeJSONArray) {
                    if(nodeJSONArray.isEmpty()) {
                        id = jsonObject.getString(key);
                        break;
                    }

                }
            }

            return  id;

        }
        //获取json里没有键时，的id值
    public static String getArrayNoKeyId(String data, String jsonArraynode,String noKey,  String key){


        String id="0";
        JSONArray jsonArray;
        jsonArray=getJsonArray(data,jsonArraynode);

        if(!jsonArray.isEmpty()) {
            for (int i = 0; i < jsonArray.size(); i++) {
                // System.out.println("---------------" + result);
                JSONObject jsonObject;
                jsonObject = (JSONObject) jsonArray.getJSONObject(i);
                String noKeyValue="0";

                noKeyValue = jsonObject.getString(noKey);

                //  if(null== nodeJSONArray) {
                try {
                    if (noKeyValue.equals(null)) {

                    }
                } catch (NullPointerException e) {
                    System.out.println("noKeyValue.equals(null): " + e);
                    id = jsonObject.getString(key);
                     break;
                }


            }
        }

        return  id;

    }

    //抽取json数组中的每个数组某个字段Key的value
    public static String getNodeArrayKey(String data, String node,String key) {

        String result = "0";
        JSONObject jsonObject;
        jsonObject=JSONObject.parseObject(data);

        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject.getString(node));//把string改变为Json数组


        System.out.println(jsonArray.toString());
        int i= (int) (Math.random()*(jsonArray.size()));
        //System.out.println(i);
        jsonObject = (JSONObject) jsonArray.getJSONObject(i);
        result = jsonObject.getString(key);


        return result;
    }





}
