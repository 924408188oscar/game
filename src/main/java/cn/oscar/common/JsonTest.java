package cn.oscar.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

public class JsonTest {

    public static JSONArray getJsonArray(String data, String node) {
        JSONObject jsonObject;
        jsonObject = JSONObject.parseObject(data);

        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject.getString(node));//把string改变为Json数组

        return jsonArray;
    }

    public static String getNullNodeId(JSONArray jsonArray, String node, String key) {
        String id = "0";

        if ( !jsonArray.isEmpty() ) {
            for (int i = 0; i < jsonArray.size(); i++) {
                // System.out.println("---------------" + result);
                JSONObject jsonObject;
                jsonObject = (JSONObject) jsonArray.getJSONObject(i);
                JSONArray nodeJSONArray;

                nodeJSONArray = jsonObject.getJSONArray(node);
                // System.out.println(nodeJSONArray.toString());

                //  if(null== nodeJSONArray) {
                if ( nodeJSONArray.isEmpty() ) {
                    id = jsonObject.getString(key);
                    break;
                }

            }
        }

        return id;

    }

    //获取json里没有键时，的id值
    public static String getArrayNoKeyId(String data, String jsonArraynode, String noKey, String key) {


        String id = "0";
        JSONArray jsonArray;
        jsonArray = getJsonArray(data, jsonArraynode);

        if ( !jsonArray.isEmpty() ) {
            for (int i = 0; i < jsonArray.size(); i++) {
                // System.out.println("---------------" + result);
                JSONObject jsonObject;
                jsonObject = (JSONObject) jsonArray.getJSONObject(i);
                String noKeyValue = "0";

                noKeyValue = jsonObject.getString(noKey);

                //  if(null== nodeJSONArray) {
                try {
                    if ( noKeyValue.equals(null) ) {

                    }
                } catch (NullPointerException e) {
                    System.out.println("noKeyValue.equals(null): " + e);
                    id = jsonObject.getString(key);
                    break;
                }


            }
        }

        return id;

    }

    //抽取json数组中的每个数组某个字段Key的value
    public static String getNodeArrayKey(String data, String node, String key) {

        String result = "0";
        JSONObject jsonObject;
        jsonObject = JSONObject.parseObject(data);

        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject.getString(node));//把string改变为Json数组


        System.out.println(jsonArray.toString());
        int i = (int) (Math.random() * (jsonArray.size()));
        //System.out.println(i);
        jsonObject = (JSONObject) jsonArray.getJSONObject(i);
        result = jsonObject.getString(key);
        return result;
    }

    //获取jsonArray数组里两个key的值。key2为node数组下的key
    public static String[] getArray2Key(String data, String key1, String node, String key2) {
        String[] arrayValue = {"0", "0"};
        JSONArray jsonArray;
        JSONArray nodeArray;
        jsonArray = parseArray(data);//把string改变为Json数组
        //System.out.println(data);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject;

            jsonObject = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象

            if ( !jsonObject.isEmpty() ) {
                String name = "1";
                arrayValue[0] = jsonObject.getString(key1);
                if ( !node.isEmpty() ) {
                    nodeArray = jsonObject.getJSONArray(node);
                    if ( !nodeArray.isEmpty() ) {
                        JSONObject nodeObject;
                        nodeObject = (JSONObject) nodeArray.getJSONObject(0);
                        arrayValue[1] = nodeObject.getString(key2);

                    }

                }

            }
        }
        System.out.println(arrayValue[0] + "==" + arrayValue[1]);

        return arrayValue;
    }


    //获取jsonArray数组key1为key1value值数据下 节点为node下key2 的值。  主要获取订单课时卡版本。
    public static String getPeriodCardsVersion(String data, String key1, String key1Value, String node, String key2) {
        String arrayValue = "0";
        String value = "0";
        JSONArray jsonArray;
        JSONArray nodeArray;
        jsonArray = parseArray(data);//把string改变为Json数组
        //System.out.println(data);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject;

            jsonObject = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象

            try {
                if ( !jsonObject.isEmpty() ) {
                    String name = "1";
                    value = jsonObject.getString(key1);
                    if ( value.equals(key1Value) ) {
                        if ( !node.isEmpty() ) {
                            nodeArray = jsonObject.getJSONArray(node);
                            if ( !nodeArray.isEmpty() ) {
                                JSONObject nodeObject;
                                nodeObject = (JSONObject) nodeArray.getJSONObject(0);
                                arrayValue = nodeObject.getString(key2);
                            }
                        }

                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return arrayValue;
    }

        public static void main(String[] args) {
            String content = "[\n" +
                    "  {\n" +
                    "    \"id\": \"6770995350317699072\",\n" +
                    "    \"version\": 3,\n" +
                    "    \"name\": \"希望小学希望小学历史0226非班课\",\n" +
                    "    \"type\": 1,\n" +
                    "    \"periodMin\": 2,\n" +
                    "    \"periodMax\": 200,\n" +
                    "    \"prices\": [\n" +
                    "      {\n" +
                    "        \"id\": \"6770993737377124352\",\n" +
                    "        \"version\": 0,\n" +
                    "        \"periodMin\": 0,\n" +
                    "        \"periodMax\": 9999,\n" +
                    "        \"price\": 23000\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"children\": [\n" +
                    "      {\n" +
                    "        \"id\": \"6770995324908605440\",\n" +
                    "        \"version\": 8,\n" +
                    "        \"name\": \"希望小学历史0226\",\n" +
                    "        \"grade\": \"大学\",\n" +
                    "        \"subject\": \"历史\",\n" +
                    "        \"consumeUnit\": 2,\n" +
                    "        \"periodMin\": 2,\n" +
                    "        \"periodMax\": 200,\n" +
                    "        \"personMin\": 1,\n" +
                    "        \"personMax\": 1\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"presentPeriods\": [\n" +
                    "      {\n" +
                    "        \"id\": \"6777826684180762624\",\n" +
                    "        \"version\": 1,\n" +
                    "        \"period\": 2,\n" +
                    "        \"present\": 2\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": \"6770995346161143808\",\n" +
                    "    \"version\": 5,\n" +
                    "    \"name\": \"希望小学希望小学数学0226班课\",\n" +
                    "    \"type\": 2,\n" +
                    "    \"periodMin\": 20,\n" +
                    "    \"periodMax\": 20,\n" +
                    "    \"prices\": [\n" +
                    "      {\n" +
                    "        \"id\": \"6770993737377124352\",\n" +
                    "        \"version\": 0,\n" +
                    "        \"periodMin\": 0,\n" +
                    "        \"periodMax\": 9999,\n" +
                    "        \"price\": 23000\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"children\": [\n" +
                    "      {\n" +
                    "        \"id\": \"6770995329056772096\",\n" +
                    "        \"version\": 0,\n" +
                    "        \"name\": \"希望小学数学0226班课\",\n" +
                    "        \"grade\": \"大学\",\n" +
                    "        \"subject\": \"数学\",\n" +
                    "        \"totalPeriod\": 20,\n" +
                    "        \"personMin\": 1,\n" +
                    "        \"personMax\": 20,\n" +
                    "        \"headCount\": 20\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"presentPeriods\": [\n" +
                    "      {\n" +
                    "        \"id\": \"6777826684180762624\",\n" +
                    "        \"version\": 1,\n" +
                    "        \"period\": 2,\n" +
                    "        \"present\": 2\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "]";


            String aa = getPeriodCardsVersion(content, "id", "6770995350317699072", "children", "version");

            System.out.println(aa);

        }


    }
