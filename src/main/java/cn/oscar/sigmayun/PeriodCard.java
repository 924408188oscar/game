package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONArray;

import static com.alibaba.fastjson.JSON.parseArray;

public class PeriodCard {

    //从学员课时卡列表，获取有库存可以转课时 的课时卡
    public static String getPeriodCardId(String req,String periodCardName,int residuePeriod){
        String periodCardId="0";
        JSONArray jsonArray;
        JSONArray nodeArray;
        jsonArray = parseArray(req);



        return periodCardId;
    }


    public static void main(String[] args) {



    }
}
