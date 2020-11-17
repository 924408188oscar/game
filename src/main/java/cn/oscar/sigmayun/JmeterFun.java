package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONObject;

public class JmeterFun {
    public static void main(String[] args) {
       // createPhoneNumber("151001");
        String response_data="{\"total\":43,\"data\":[{\"id\":\"6701408323306655744\",\"sn\":\"20200818000885\",\"name\":\"沈隆\",\"gender\":1,\"grade\":\"年级\",\"school\":\"学军小学\",\"tags\":[],\"parentName\":\"沈隆1\",\"parentContact\":\"15100149524\",\"duty\":{\"familyOwner\":true,\"studentOwner\":false,\"groupOwner\":false,\"teacher\":false},\"isContacts\":false}]}";

        JSONObject response_data_obj = JSONObject.parseObject(response_data);
        Object data=response_data_obj.get("data");//.get("attack_data").get("animal_list").toString();
        String packJson=data.toString();

//        JSONArray jsonArray = JSONArray.fromObject(data);
        System.out.println(response_data);
        System.out.println();
        System.out.println(data.toString());


    }



    public static String createPhoneNumber(String response_data){

        int num=(int)((Math.random()*9+1)*100000);
        System.out.println(num);

        return String.valueOf(num);

    }


}
