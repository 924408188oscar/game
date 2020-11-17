package cn.oscar.game;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        String response_data= "{\"code\":10200,\"message\":\"111\",\"data\":{\"id\":\"13\",\"attack_data\":{\"interval\":500,\"animal_list\":[{\"id\":30003,\"num\":9},{\"id\":10003,\"num\":4}],\"elite\":0,\"life\":3200,\"speed\":650},\"defense_data\":{\"map_data\":[[0,0],[0,1],[0,2],[0,3],[1,0],[1,1],[1,2],[1,3],[0,4],[0,5],[1,4],[1,5],[0,6],[0,7],[1,6],[1,7],[2,6],[2,7],[3,6],[3,7],[2,4],[2,5],[3,4],[3,5],[4,6],[4,7],[5,6],[5,7],[4,4],[4,5],[5,4],[5,5],[6,6],[6,7],[7,6],[7,7],[6,4],[6,5],[7,4],[7,5],[8,6],[8,7],[9,6],[9,7],[8,4],[8,5],[9,4],[9,5],[2,2],[2,3],[3,2],[3,3]],\"tower_list\":[{\"id\":1532,\"tower_id\":10007,\"coord_x\":1,\"coord_y\":1,\"state\":0},{\"id\":1533,\"tower_id\":10007,\"coord_x\":0,\"coord_y\":3,\"state\":0},{\"id\":1539,\"tower_id\":10007,\"coord_x\":4,\"coord_y\":5,\"state\":0},{\"id\":1540,\"tower_id\":10007,\"coord_x\":3,\"coord_y\":6,\"state\":0},{\"id\":1546,\"tower_id\":10007,\"coord_x\":6,\"coord_y\":6,\"state\":0},{\"id\":1547,\"tower_id\":10007,\"coord_x\":7,\"coord_y\":6,\"state\":0},{\"id\":1548,\"tower_id\":20001,\"coord_x\":7,\"coord_y\":5,\"state\":0},{\"id\":1549,\"tower_id\":20001,\"coord_x\":8,\"coord_y\":6,\"state\":0},{\"id\":1545,\"tower_id\":20004,\"coord_x\":0,\"coord_y\":4,\"state\":0},{\"id\":1535,\"tower_id\":20005,\"coord_x\":2,\"coord_y\":5,\"state\":0},{\"id\":1537,\"tower_id\":20005,\"coord_x\":0,\"coord_y\":5,\"state\":0},{\"id\":1544,\"tower_id\":20005,\"coord_x\":4,\"coord_y\":6,\"state\":0},{\"id\":1536,\"tower_id\":30002,\"coord_x\":1,\"coord_y\":7,\"state\":0},{\"id\":1542,\"tower_id\":30004,\"coord_x\":6,\"coord_y\":5,\"state\":0},{\"id\":1534,\"tower_id\":30005,\"coord_x\":1,\"coord_y\":5,\"state\":0},{\"id\":1543,\"tower_id\":30005,\"coord_x\":5,\"coord_y\":6,\"state\":0},{\"id\":1538,\"tower_id\":40004,\"coord_x\":3,\"coord_y\":5,\"state\":0},{\"id\":1541,\"tower_id\":40004,\"coord_x\":5,\"coord_y\":5,\"state\":0}],\"buff_info\":null},\"user_info\":{\"user_id\":66135,\"exp\":154,\"hp\":210,\"coin\":3804,\"diamond\":700,\"credit\":80,\"first_recharge\":0,\"amount\":\"2.43\",\"balance\":\"0.00\",\"total_revenue\":\"0.00\",\"frequency_num\":11,\"lock\":170,\"recovery_time\":1574672421,\"step\":20100,\"sub_step\":10720,\"is_step\":1,\"come_from\":1,\"update_time\":1574671062,\"step_rec\":10370,\"level\":44,\"new_user_level\":12,\"create_time\":1574670939,\"channel_id\":2,\"user_level\":\"12\",\"user_cost\":\"120\",\"strength_limit\":\"122\",\"strength_recovery\":\"600\",\"u_exp\":1834,\"up_exp\":\"500\"},\"building_id\":10011,\"guard\":7245,\"defense_pets_info\":{\"attack\":121,\"defense\":159,\"hp\":256,\"speed\":134,\"magic\":163}}}";

        JSONObject  response_data_obj = JSONObject.parseObject(response_data);
        Object data=response_data_obj.get("data");//.get("attack_data").get("animal_list").toString();

        System.out.println(response_data);
        System.out.println(data.toString());

        JSONObject  attack_data_obj = JSONObject.parseObject(data.toString());
        Object attack_data=attack_data_obj.get("attack_data");

        System.out.println("attack_data:"+attack_data.toString());

        JSONObject  animal_list_obj = JSONObject.parseObject(attack_data.toString());
        Object animal_List_obj=animal_list_obj.get("animal_list");

        System.out.println("animal_List_obj: "+animal_List_obj.toString());


        JSONArray res = animal_list_obj.getJSONArray("animal_list");

        List<Animal_list> rules = new ArrayList<Animal_list>();
        for (int i = 0; i < res.size(); i++) {
            JSONObject Animal_listi = (JSONObject) res.get(i);
            Animal_list Animal_list1;
            Animal_list1 = JSONObject.toJavaObject(Animal_listi,Animal_list.class);
            System.out.println("ddddddddddddddddddddddddddddddddd");
            rules.add(Animal_list1);
            System.out.println(Animal_list1.toString());

        }

       System.out.println(rules.toString());
        System.out.println(para(response_data));
//        Animal_list a= new Animal_list(2,3);
//        Animal_list b= new Animal_list(5,6);
//        List<Animal_list> aa= new ArrayList<>();
//        aa.add(a);
//        aa.add(b);
//        System.out.println("Animal_list:"+aa.toString());


    }

    public static String para(String response_data){
        JSONObject  response_data_obj = JSONObject.parseObject(response_data);
        Object data=response_data_obj.get("data");//.get("attack_data").get("animal_list").toString();

        //System.out.println(response_data);
        //System.out.println(data.toString());

        JSONObject  attack_data_obj = JSONObject.parseObject(data.toString());
        Object attack_data=attack_data_obj.get("attack_data");

       // System.out.println("attack_data:"+attack_data.toString());

        JSONObject  animal_list_obj = JSONObject.parseObject(attack_data.toString());
        Object animal_List_obj=animal_list_obj.get("animal_list");

        //System.out.println("animal_List_obj: "+animal_List_obj.toString());
        JSONArray res = animal_list_obj.getJSONArray("animal_list");

        List<Animal_list> rules = new ArrayList<Animal_list>();
        for (int i = 0; i < res.size(); i++) {
            JSONObject Animal_listi = (JSONObject) res.get(i);
            Animal_list Animal_list1;
            Animal_list1 = JSONObject.toJavaObject(Animal_listi,Animal_list.class);

            rules.add(Animal_list1);
           // System.out.println(Animal_list1.toString());

        }

        String s = rules.toString();
        System.out.println(s);
        return s;


    }

}
