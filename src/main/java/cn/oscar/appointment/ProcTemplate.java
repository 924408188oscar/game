package cn.oscar.appointment;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

//获取预约模板里的uuid,日期UUID，内容UUID等
public class ProcTemplate {
    public static String[] getUUIdVaule(String data){
        String resultArray[] = new String[]{"0","0","0"};
        JSONObject jsonObject;
        jsonObject=JSONObject.parseObject(data);

        jsonObject=jsonObject.getJSONObject("formTemplate");
        jsonObject=jsonObject.getJSONObject("flowFormTemplate");
        System.out.println(jsonObject.toString());
        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject.getString("body"));//把string改变为Json数组
        String aa;
        try {
            aa=jsonArray.toString();
            System.out.println(aa);
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");

        }

        if(!jsonArray.isEmpty()) {
            for (int i = 0; i < jsonArray.size(); i++) {
                // System.out.println("---------------" + result);
                JSONObject inJsonObject;
                JSONObject inJsonObject1;
                inJsonObject = (JSONObject) jsonArray.getJSONObject(i);
                inJsonObject1= inJsonObject.getJSONObject("props");
                if(i<3) {
                    resultArray[i] = inJsonObject1.getString("id");
                    System.out.println(inJsonObject1.getString("label"));
                    System.out.println(inJsonObject1.getString("id"));
                }
            }
        }

        return  resultArray;
    }

}
