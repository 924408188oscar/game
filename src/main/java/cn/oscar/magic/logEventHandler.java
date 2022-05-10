package cn.oscar.magic;

import cn.oscar.common.StringAdd;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

public class logEventHandler {

//提取日志事件处理 下arguments的参数
    public static String getProcessCommandline(String data,String node,String key){
        String processCommnadline="";
        JSONObject jsonObject,jsonObject1;
        jsonObject = JSONObject.parseObject(data);
        jsonObject1 = jsonObject.getJSONObject("data");


        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject1.getString(node));//把string改变为Json数组,获取list数组

        System.out.println(jsonArray.toJSONString());

        for (int i = 0; i < jsonArray.size(); i++) {
            // System.out.println("---------------" + result);
            JSONObject jsonObject2,arguments;
            jsonObject2 = (JSONObject) jsonArray.getJSONObject(i);

            arguments=jsonObject2.getJSONObject("arguments");

            processCommnadline=arguments.getString(key);

            break;
            }

        processCommnadline=StringAdd.slash(processCommnadline);
        return processCommnadline;
    }

    public static void main(String[] args) {
        String data="";
        String a=getProcessCommandline(data,"list","process_commandline");

       // StringAdd.slash(a);
        System.out.println(a);

    }


}
