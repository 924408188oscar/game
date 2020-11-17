package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Random;

import static com.alibaba.fastjson.JSON.parseArray;

public class Report {

    public static String setRoleReport(String data, String nodeArray, String key) {
        String result = "[\"";
        JSONArray jsonArray;
        jsonArray = parseArray(data);//把string改变为Json数组

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject;
            jsonObject = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象

            System.out.println(jsonObject.toString());
            JSONArray rolesJSONArray = new JSONArray();

            if (!jsonObject.isEmpty()) {
                rolesJSONArray = jsonObject.getJSONArray(nodeArray); //获取panelDtos数组
                int x = rolesJSONArray.size();
                for (int j = 0; j < x; j++) {
                    JSONObject rolejsonObject;
                    rolejsonObject = (JSONObject) rolesJSONArray.getJSONObject(j);
                    result = result + rolejsonObject.getString(key) + "\",\"";
                }

            }
        }
        result = result.substring(0, result.length() - 2) + "]";

        return result;

    }

    //输入["6619862729270366223","6619862729270366224","6619862729274560512","6619862729274560513","6619862729274560514","6619862729274560515"]
    //return 随机 "6619862729270366223"
    public static String getArraryRandomValue(String data) {
        String result = "";
        String temp = "";
        if (data.length() < 3) {
            return result;
        }
        temp = data.substring(1, data.length() - 1);
        String[] bb = temp.split(",");

//        for(int i=0;i<bb.length;i++){
//            System.out.println(bb[i]);
//        }
        Random random = new Random();
        int i = random.nextInt(bb.length);
        System.out.println(i);
        result = bb[i];

        return result;
    }

    public static String getResponseId(String data, String node, String id) {
        String result="";
        JSONObject jsonObject;
        jsonObject=JSONObject.parseObject(data);

        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject.getString(node));//把string改变为Json数组
        int j=jsonArray.size();
        if(j>0){
        String[] temp = new String[j];
        for (int i = 0; i < j; i++) {
            JSONObject jsonObject1;
            jsonObject1 = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象
            temp[i]=jsonObject1.getString(id);
            System.out.println(jsonObject1.toString());
        }

        Random random=new Random();
        int k=random.nextInt(j);
        result=temp[k];

        }

        return  result;
    }


    public static void main(String[] args) {





    }


}


