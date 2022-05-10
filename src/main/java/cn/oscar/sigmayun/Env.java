package cn.oscar.sigmayun;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;
//通过机构名称获取 orgId和企业的Id
public class Env {
    static public String[] getSSTTandOrgId(String data,String key,String orgName){
        String[] result=new String[]{"0","0"};
        String SSTTid="0";
        String orgId="0";
        JSONObject jsonObject;
        jsonObject=JSONObject.parseObject(data);

        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject.getString(key));//把string改变为Json数组
       // System.out.println(jsonArray.toString());
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObjectNode;
            jsonObjectNode = (JSONObject) jsonArray.getJSONObject(i);//把每个数组转的josn对象

           // System.out.println(SSTTid);
            JSONArray jsonArrayOrgs;
            jsonArrayOrgs = parseArray(jsonObjectNode.getString("orgs"));//把string改变为Json数组
            for (int j = 0; j < jsonArrayOrgs.size(); j++) {
                JSONObject jsonObjectNode1;

                jsonObjectNode1 = (JSONObject) jsonArrayOrgs.getJSONObject(j);//把每个数组转的josn对象
                String orgName1=jsonObjectNode1.getString("name");
                if(orgName1.contains(orgName)) {
                    orgId = jsonObjectNode1.getString("id");
                    SSTTid=jsonObjectNode.getString("id");
                    break;
                }
            }

        }
        result[0]=SSTTid;
        result[1]=orgId;

        return  result;
    }

    public static void main(String[] args) {
        String content="{\"userInfo\":{\"name\":\"郑临佑\",\"phone\":\"13905888390\",\"status\":2,\"userId\":\"6787546948099510272\"},\"tenants\":[{\"id\":\"6786483569788325888\",\"name\":\"晞格玛教育410\",\"status\":1,\"orgs\":[{\"id\":\"6786484420829384704\",\"name\":\"希望小学\",\"status\":1,\"img\":\"http://qiniu.sishuxuefu.com/6786483569788325888.png\",\"isRoot\":false}]},{\"id\":\"6791199177314537472\",\"name\":\"晞格玛教育117\",\"status\":1,\"orgs\":[{\"id\":\"6791199180833558528\",\"name\":\"晞格玛教育117\",\"status\":1,\"img\":\"http://qiniu.sishuxuefu.com/6791199177314537472.png\",\"isRoot\":true},{\"id\":\"6791236525737775104\",\"name\":\"学军中学\",\"status\":1,\"img\":\"http://qiniu.sishuxuefu.com/6791199177314537472.png\",\"isRoot\":false}]}]}";

        String[] aa=Env.getSSTTandOrgId(content,"tenants","希望小学");
        System.out.println(aa[0]+"\n"+aa[1]);


    }
}
