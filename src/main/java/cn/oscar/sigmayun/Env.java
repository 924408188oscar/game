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
            SSTTid=jsonObjectNode.getString("id");
           // System.out.println(SSTTid);
            JSONArray jsonArrayOrgs;
            jsonArrayOrgs = parseArray(jsonObjectNode.getString("orgs"));//把string改变为Json数组
            for (int j = 0; j < jsonArrayOrgs.size(); j++) {
                JSONObject jsonObjectNode1;

                jsonObjectNode1 = (JSONObject) jsonArrayOrgs.getJSONObject(j);//把每个数组转的josn对象
                String orgName1=jsonObjectNode1.getString("name");
                if(orgName1.contains(orgName)) {
                    orgId = jsonObjectNode1.getString("id");
                    break;
                }
            }

        }
        result[0]=SSTTid;
        result[1]=orgId;

        return  result;
    }

    public static void main(String[] args) {
        String content="{\n" +
                "  \"userInfo\": {\n" +
                "    \"name\": \"李若亮\",\n" +
                "    \"phone\": \"15505883399\",\n" +
                "    \"status\": 2,\n" +
                "    \"userId\": \"6716553800968179712\"\n" +
                "  },\n" +
                "  \"tenants\": [\n" +
                "    {\n" +
                "      \"id\": \"6670924919376842752\",\n" +
                "      \"name\": \"华夏教育\",\n" +
                "      \"orgs\": [\n" +
                "        {\n" +
                "          \"id\": \"6670925975221571584\",\n" +
                "          \"name\": \"华夏红旗\",\n" +
                "          \"img\": \"http://qiniu.sishuxuefu.com/6670924919376842752.png?time=1597284931138\",\n" +
                "          \"isRoot\": false\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6703857617044901888\",\n" +
                "      \"name\": \"线上测试专用企业\",\n" +
                "      \"orgs\": [\n" +
                "        {\n" +
                "          \"id\": \"6703857619913805824\",\n" +
                "          \"name\": \"线上测试专用企业\",\n" +
                "          \"img\": \"http://qiniu.sishuxuefu.com/6703857617044901888.png\",\n" +
                "          \"isRoot\": true\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6758577358405505024\",\n" +
                "      \"name\": \"晞格玛教育757\",\n" +
                "      \"orgs\": [\n" +
                "        {\n" +
                "          \"id\": \"6758577361853222912\",\n" +
                "          \"name\": \"晞格玛教育757\",\n" +
                "          \"img\": \"\",\n" +
                "          \"isRoot\": true\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"6758586866796204032\",\n" +
                "          \"name\": \"学军中学\",\n" +
                "          \"img\": \"\",\n" +
                "          \"isRoot\": false\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String[] aa=Env.getSSTTandOrgId(content,"tenants","晞格玛教");
        System.out.println(aa[0]+"\n"+aa[1]);


    }
}
