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

        String content="[\n" +
                "  {\n" +
                "    \"category\": \"regional\",\n" +
                "    \"panelDtos\": [\n" +
                "      {\n" +
                "        \"name\": \"在职员工数量\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构的员工数。\",\n" +
                "        \"panelId\": \"6619862729274560801\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/mXFHRtM6i5NS.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"在职员工数\",\n" +
                "            \"content\": \"区域内各机构的在职员工数量，以确认入职为准。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"分渠道到访\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构的各渠道的实际到访数量。\",\n" +
                "        \"panelId\": \"6619862729274560802\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/GrsvIg4rB1Pt.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"渠道\",\n" +
                "            \"content\": \"当前企业配置的到访渠道。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"渠道到访量\",\n" +
                "            \"content\": \"筛选时间范围内，机构内已确认的到访的渠道数量。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"获客量及占比\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构内各渠道的获客量及该渠道的数据占比。\",\n" +
                "        \"panelId\": \"6619862729274560803\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/gzL5GmV00mEr.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"渠道\",\n" +
                "            \"content\": \"当前企业配置的获客渠道（信息来源渠道）。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"渠道数据\",\n" +
                "            \"content\": \"筛选时间范围内，机构内该渠道的获客数量（包含批量导入与单条录入）。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"获客总量\",\n" +
                "            \"content\": \"筛选时间范围内，机构内添加的所有渠道的获客量之和。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"到访量\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构的预约上门量、上门接待量。\",\n" +
                "        \"panelId\": \"6619862729274560804\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/rkQY5tPhYW5S.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"预约上门量\",\n" +
                "            \"content\": \"筛选时间范围内，机构添加的预约到访数量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"预约且上门量\",\n" +
                "            \"content\": \"筛选时间范围内，机构添加预约到访且实际到访的数量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"一次上门接待\",\n" +
                "            \"content\": \"筛选时间范围内，机构内员工接待的家长为首次到访的到访数量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"再次上门接待\",\n" +
                "            \"content\": \"筛选时间范围内，机构内员工接待的家长为非首次到访的到访数量。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"订单量\\t\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构的预约上门量、上门接待量。\",\n" +
                "        \"panelId\": \"6619862729274560805\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/fFMjQukVpu6O.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"班课订单\",\n" +
                "            \"content\": \"当前企业配置的班课类型订单，统计筛选时间范围内，机构添加的且已完成付全款的新签及续费班课订单总数。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"非班课订单\",\n" +
                "            \"content\": \"当前企业配置的非班课类型订单，统计筛选时间范围内，机构添加的且已完成付全款的新签及续费非班课订单总数。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"订单总量排名\",\n" +
                "            \"content\": \"区域内各机构完成的付全款的订单总量的排名。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"销售课时\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构完成的订单的课时量。\",\n" +
                "        \"panelId\": \"6619862729274560806\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/1iqEmmtjwKq6.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"班课课时\",\n" +
                "            \"content\": \"当前企业配置的班课类型订单，统计筛选时间范围内，机构添加的且已完成付全款的新签及续费班课订单的课时量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"非班课课时\",\n" +
                "            \"content\": \"当前企业配置的非班课类型订单，统计筛选时间范围内，机构添加的且已完成付全款的新签及续费非班课订单的课时量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"总课时排名\",\n" +
                "            \"content\": \"区域内各机构完成的付全款的订单课时量的排名。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"销售金额\\t\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构内完成的订单的金额。\",\n" +
                "        \"panelId\": \"6619862729274560807\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/p0jR6S7EAVrL.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"班课金额\",\n" +
                "            \"content\": \"当前企业配置的班课类型订单，统计筛选时间范围内，机构添加的且已完成付全款的新签及续费班课订单的金额。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"非班课金额\",\n" +
                "            \"content\": \"当前企业配置的非班课类型订单，统计筛选时间范围内，机构添加的且已完成付全款的新签及续费非班课订单的金额。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"总金额排名\",\n" +
                "            \"content\": \"当前区域内，各机构完成的付全款的订单金额的排名。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"排消课\\t\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构的排消课数量。\",\n" +
                "        \"panelId\": \"6619862729274560809\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/UsUoBi0MPK1X.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"排课量\",\n" +
                "            \"content\": \"机构内，筛选时间范围内的排课次数。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"消课量\",\n" +
                "            \"content\": \"机构内，筛选时间范围内的消课次数。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"退费\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构内申请或完成的退费数据。\",\n" +
                "        \"panelId\": \"6619862729274560811\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/IGKrn0vUrlHN.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"退费申请数\",\n" +
                "            \"content\": \"当前机构内，员工申请的订单退费数量,不包含已撤回的退费申请。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"完成退费订单数\",\n" +
                "            \"content\": \"当前机构内，在财务退款处已完成退款的订单退费数。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"退费学员数\",\n" +
                "            \"content\": \"当前机构内，在财务退款处已完成退款的订单退费学员数，不包含定金退费（需去重）。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"定金退费金额\",\n" +
                "            \"content\": \"当前机构内，在财务退款处已完成退款的定金金额。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"订单退费金额\",\n" +
                "            \"content\": \"当前机构内，在财务退款处已完成退款的订单退费的金额。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"订单退费课时\",\n" +
                "            \"content\": \"当前机构内，在财务退款处已完成退款的退费申请单的课时数。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"异常课程\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构内的异常课程数量及已处理的异常课程数量(此处统计的为课程次数）。\",\n" +
                "        \"panelId\": \"6619862729274560812\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/tiansiyu/20200619/RFmArQfQr6fw.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"未消课异常\",\n" +
                "            \"content\": \"机构内，截止到筛选结束时间前一天的未消课异常课次量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"异常课程处理\",\n" +
                "            \"content\": \"机构内，截止到筛选结束时间已经处理的异常课次量。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"学员管理\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构内不同类型的学员数量。\",\n" +
                "        \"panelId\": \"6619862729274560813\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/zhangjing/20200703-07.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"已签约学员\",\n" +
                "            \"content\": \"机构内，是已签约状态的学员。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"结课学员\",\n" +
                "            \"content\": \"机构内，课时卡已关闭是结课状态的学员。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"课时消耗\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构的课时消耗量。\",\n" +
                "        \"panelId\": \"6619862729274560814\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/zhangjing/20200703-04.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"课时消耗量\",\n" +
                "            \"content\": \"机构内，学员负责人所负责的学员消耗的课时量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"班课课时消耗量\",\n" +
                "            \"content\": \"机构内，学员负责人所负责的学员消耗的班课课时卡的课时量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"非班课课时消耗量\",\n" +
                "            \"content\": \"机构内，学员负责人所负责的学员消耗的非班课课时卡的课时量。\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"carefulArray\": [\n" +
                "          \"当前课时量不受时间筛选限制。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"请假课时\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构的请假课时量。\",\n" +
                "        \"panelId\": \"6619862729274560815\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/zhangjing/20200703-02.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"请假课时量\",\n" +
                "            \"content\": \"机构内，学员负责人所负责的学员请假的课时量，包含教师请假与家长端请假。\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"carefulArray\": [\n" +
                "          \"当前请假课时量不受时间筛选限制。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"课时库存\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构内的学员课时库存量。\",\n" +
                "        \"panelId\": \"6619862729274560816\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/zhangjing/20200703-03.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"库存课时总量\",\n" +
                "            \"content\": \"区域内各机构的学员所有类型课时卡的课时库存总量（包含各种类型课时卡的购买和赠送）。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"购买课时库存\",\n" +
                "            \"content\": \"区域内各机构的学员课时卡（班课/非班课）的购买课时库存。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"赠送课时库存\",\n" +
                "            \"content\": \"区域内各机构的学员课时卡（班课/非班课）的赠送课时库存。\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"carefulArray\": [\n" +
                "          \"当前此处库存课时量显示的是截止到当前时间的库存课时量，不受时间筛选限制。\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"分类订单量\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构完成的订单量。\",\n" +
                "        \"panelId\": \"6619862729274560817\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/zhangjing/20200703-01.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"班课\",\n" +
                "            \"content\": \"当前企业配置的班课类型订单。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"非班课\",\n" +
                "            \"content\": \"当前企业配置的非班课类型订单。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"新签订单量\",\n" +
                "            \"content\": \"筛选时间范围内，机构添加的且已完成付全款的新签类型的班课/非班课订单总数，注意类型的区分（新签=未签约购买订单且付全款+结课且课时卡关闭 再次购买订单且付全款）。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"续费订单量\",\n" +
                "            \"content\": \"筛选时间范围内，机构添加的且已完成付全款的续费类型的班课/非班课订单总数，注意类型的区分（续费=已签约添加订单且付全款+结课且课时卡未关闭 再次购买订单且付全款）。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"推荐单\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构添加的且已审批通过的推荐单数量。\",\n" +
                "        \"panelId\": \"6619862729274560818\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/zhangjing/20200703-05.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"已审批通过推荐单总量\",\n" +
                "            \"content\": \"机构添加的在筛选时间范围内已被审批通过的推荐单数量。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"推荐签约\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构审批通过的推荐单被签约订单关联的相关数据。\",\n" +
                "        \"panelId\": \"6619862729274560819\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/zhangjing/20200703-06.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"订单量\",\n" +
                "            \"content\": \"机构内已审批通过的推荐单被关联的各类型（班课/非班课）的订单数量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"课时\",\n" +
                "            \"content\": \"机构内已审批通过的推荐单被关联的各类型（班课/非班课）的订单的课时量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"金额\",\n" +
                "            \"content\": \"机构内已审批通过的推荐单被关联的各类型（班课/非班课）的订单的金额。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"维护记录\",\n" +
                "        \"desc\": \"此模块主要统计区域内各机构内添加的各类型维护记录数量。\",\n" +
                "        \"panelId\": \"6619862729274560820\",\n" +
                "        \"logoUrl\": \"http://qiniu.sishuxuefu.com/sigma/ui/zhangjing/2020080507.png\",\n" +
                "        \"panelDetailsArray\": [\n" +
                "          {\n" +
                "            \"title\": \"常规沟通\",\n" +
                "            \"content\": \"在筛选时间范围内，每个机构添加的常规沟通维护数量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"家长会\",\n" +
                "            \"content\": \"在筛选时间范围内，每个机构添加的家长会维护数量。\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"title\": \"教讨会\",\n" +
                "            \"content\": \"在筛选时间范围内，每个机构添加的教讨会维护数量。\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";


        String cc=Report.setRoleReport(content,"panelDtos","panelId");
        System.out.println(cc);




    }


}


