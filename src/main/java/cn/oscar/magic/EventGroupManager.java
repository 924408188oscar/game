package cn.oscar.magic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import static com.alibaba.fastjson.JSON.parseArray;

public class EventGroupManager {

    public static JSONArray getJsonArray(String data, String node) {
        JSONObject jsonObject;
        jsonObject = JSONObject.parseObject(data);
//        System.out.println(jsonObject.toString());

        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject.getString(node));//把string改变为Json数组

        return jsonArray;
    }

    //事件组管理
    public static String[] getEventIdAndType(String data,String node,String id,String log_name){
        String[]  event={"0","0"};
        JSONObject jsonObject,jsonObject1;
        jsonObject = JSONObject.parseObject(data);
        jsonObject1 = jsonObject.getJSONObject("data");
        JSONArray jsonArray;
        jsonArray = parseArray(jsonObject1.getString(node));
      //  System.out.println(jsonArray.toJSONString());

        for (int i = 0; i < jsonArray.size(); i++) {
            // System.out.println("---------------" + result);
            JSONObject jsonObject2;
            jsonObject2 = (JSONObject) jsonArray.getJSONObject(i);
            if(!jsonObject2.containsKey("obj")){
                event[0]=jsonObject2.getString(id);
                event[1]=jsonObject2.getString(log_name);
                System.out.println(event[0]);
                System.out.println(event[1]);
                break;

            }

        }

        return event;
    }



    public static void main(String[] args) {
        String content = "{\n" +
                "    \"code\":0,\n" +
                "    \"message\":\"操作成功\",\n" +
                "    \"data\":{\n" +
                "        \"nodes\":[\n" +
                "            {\n" +
                "                \"obj\":\"221.231.81.213\",\n" +
                "                \"id\":\"1fa41b71-f80c-438c-bd12-43bdbc8fc857\",\n" +
                "                \"type\":\"ip\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"policy_id\":\"33\",\n" +
                "                \"ipv6_address\":\"fe80::4891:522d:5b88:b6a8\",\n" +
                "                \"source\":\"Agent\",\n" +
                "                \"uuid\":\"de017a84cd70bc2f46dd3c3a40704324\",\n" +
                "                \"mac\":\"00-0C-29-C0-95-E4\",\n" +
                "                \"result\":1,\n" +
                "                \"relation_field\":\"remote_ip:66.20.10.151\",\n" +
                "                \"log_category\":\"Login\",\n" +
                "                \"operating\":\"Login\",\n" +
                "                \"id\":\"248E1128-6191-4E9C-9496-9E376541CE0D\",\n" +
                "                \"event\":true,\n" +
                "                \"behavior\":2,\n" +
                "                \"timestamp\":1640148403000,\n" +
                "                \"log_name\":\"Crack\",\n" +
                "                \"level\":4,\n" +
                "                \"os_version\":\"Windows 10 Enterprise\",\n" +
                "                \"operation_mode\":0,\n" +
                "                \"ip_address\":\"66.20.10.124\",\n" +
                "                \"event_category\":\"Login\",\n" +
                "                \"superior\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"os_type\":1,\n" +
                "                \"processing\":1640148411476,\n" +
                "                \"arguments\":{\n" +
                "                    \"remote_ip\":\"66.20.10.151\",\n" +
                "                    \"login_type\":\"\",\n" +
                "                    \"login_time\":\"2021-12-22 12:38:43\",\n" +
                "                    \"remote_hostname\":\"\",\n" +
                "                    \"crack_count\":3,\n" +
                "                    \"account\":\"Administrator\"\n" +
                "                },\n" +
                "                \"terminate\":1,\n" +
                "                \"event_group_id\":\"9b91655a-fde9-4c70-8f0e-38fb501fb2d0\",\n" +
                "                \"detail\":\"66.20.10.151在-分钟内尝试登录3次，疑似暴力密码破解行为\",\n" +
                "                \"user\":\"k\",\n" +
                "                \"host_name\":\"DESKTOP-R2SE668\",\n" +
                "                \"status\":0\n" +
                "            },\n" +
                "            {\n" +
                "                \"policy_id\":\"33\",\n" +
                "                \"ipv6_address\":\"fe80::4891:522d:5b88:b6a8\",\n" +
                "                \"source\":\"Agent\",\n" +
                "                \"uuid\":\"de017a84cd70bc2f46dd3c3a40704324\",\n" +
                "                \"mac\":\"00-0C-29-C0-95-E4\",\n" +
                "                \"result\":1,\n" +
                "                \"relation_field\":\"remote_ip:66.20.10.151\",\n" +
                "                \"log_category\":\"Login\",\n" +
                "                \"id\":\"07EC9369-D760-42C7-8791-76F2432675E0\",\n" +
                "                \"operating\":\"Login\",\n" +
                "                \"event\":true,\n" +
                "                \"behavior\":2,\n" +
                "                \"timestamp\":1640148330000,\n" +
                "                \"log_name\":\"IllegalLoginIp\",\n" +
                "                \"level\":4,\n" +
                "                \"os_version\":\"Windows 10 Enterprise\",\n" +
                "                \"operation_mode\":0,\n" +
                "                \"ip_address\":\"66.20.10.124\",\n" +
                "                \"event_category\":\"Login\",\n" +
                "                \"superior\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"os_type\":1,\n" +
                "                \"processing\":1640148331598,\n" +
                "                \"arguments\":{\n" +
                "                    \"country\":\"\",\n" +
                "                    \"remote_ip\":\"66.20.10.151\",\n" +
                "                    \"province\":\"\",\n" +
                "                    \"login_type\":\"RDP\",\n" +
                "                    \"city\":\"\",\n" +
                "                    \"login_time\":\"2021-12-22 12:45:22\",\n" +
                "                    \"location\":\"美国BellSouth.net Inc.\",\n" +
                "                    \"remote_hostname\":\"DESKTOP-2MN5VA6\",\n" +
                "                    \"user\":\"k\",\n" +
                "                    \"detection_rule\":\"IllegalLoginTime\",\n" +
                "                    \"session_uuid\":\"9c34f40101d7f6ee|1\"\n" +
                "                },\n" +
                "                \"terminate\":1,\n" +
                "                \"event_group_id\":\"9b91655a-fde9-4c70-8f0e-38fb501fb2d0\",\n" +
                "                \"detail\":\"IP“66.20.10.151”在“2021-12-22 12:45:22”“”非法登录系统\",\n" +
                "                \"user\":\"k\",\n" +
                "                \"host_name\":\"DESKTOP-R2SE668\",\n" +
                "                \"status\":0\n" +
                "            },\n" +
                "            {\n" +
                "                \"policy_id\":\"33\",\n" +
                "                \"ipv6_address\":\"fe80::4891:522d:5b88:b6a8\",\n" +
                "                \"source\":\"Agent\",\n" +
                "                \"uuid\":\"de017a84cd70bc2f46dd3c3a40704324\",\n" +
                "                \"mac\":\"00-0C-29-C0-95-E4\",\n" +
                "                \"result\":0,\n" +
                "                \"relation_field\":\"remote_ip:66.20.10.151\",\n" +
                "                \"log_category\":\"Network\",\n" +
                "                \"id\":\"B5909455-3B3E-4415-AAF2-B1DBD30B790D\",\n" +
                "                \"operating\":\"Connect\",\n" +
                "                \"event\":true,\n" +
                "                \"behavior\":1,\n" +
                "                \"timestamp\":1640148147000,\n" +
                "                \"log_name\":\"PortScan\",\n" +
                "                \"level\":2,\n" +
                "                \"os_version\":\"Windows 10 Enterprise\",\n" +
                "                \"operation_mode\":0,\n" +
                "                \"ip_address\":\"66.20.10.124\",\n" +
                "                \"event_category\":\"IllegalNetwork\",\n" +
                "                \"superior\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"os_type\":1,\n" +
                "                \"processing\":1640148149971,\n" +
                "                \"arguments\":{\n" +
                "                    \"intranet\":false,\n" +
                "                    \"local_ip\":\"66.20.10.124\",\n" +
                "                    \"country\":\"\",\n" +
                "                    \"remote_ip\":\"66.20.10.151\",\n" +
                "                    \"province\":\"\",\n" +
                "                    \"city\":\"\",\n" +
                "                    \"local_port\":\"3389,445,139,23,22\",\n" +
                "                    \"scan_duration\":30,\n" +
                "                    \"is_lock\":false,\n" +
                "                    \"scan_count\":5,\n" +
                "                    \"location\":\"\"\n" +
                "                },\n" +
                "                \"terminate\":1,\n" +
                "                \"event_group_id\":\"9b91655a-fde9-4c70-8f0e-38fb501fb2d0\",\n" +
                "                \"detail\":\"\",\n" +
                "                \"user\":\"k\",\n" +
                "                \"host_name\":\"DESKTOP-R2SE668\",\n" +
                "                \"status\":0\n" +
                "            },\n" +
                "            {\n" +
                "                \"policy_id\":\"33\",\n" +
                "                \"ipv6_address\":\"fe80::4891:522d:5b88:b6a8\",\n" +
                "                \"source\":\"Agent\",\n" +
                "                \"uuid\":\"de017a84cd70bc2f46dd3c3a40704324\",\n" +
                "                \"mac\":\"00-0C-29-C0-95-E4\",\n" +
                "                \"result\":0,\n" +
                "                \"relation_field\":\"remote_ip:66.20.10.151\",\n" +
                "                \"log_category\":\"Network\",\n" +
                "                \"id\":\"0C8E136F-1819-4A93-8EE7-FEC098555525\",\n" +
                "                \"operating\":\"Connect\",\n" +
                "                \"event\":true,\n" +
                "                \"behavior\":1,\n" +
                "                \"timestamp\":1640148129000,\n" +
                "                \"log_name\":\"HoneyPort\",\n" +
                "                \"level\":2,\n" +
                "                \"os_version\":\"Windows 10 Enterprise\",\n" +
                "                \"operation_mode\":0,\n" +
                "                \"ip_address\":\"66.20.10.124\",\n" +
                "                \"event_category\":\"IllegalNetwork\",\n" +
                "                \"superior\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"os_type\":1,\n" +
                "                \"processing\":1640148136536,\n" +
                "                \"arguments\":{\n" +
                "                    \"intranet\":false,\n" +
                "                    \"local_ip\":\"66.20.10.124\",\n" +
                "                    \"country\":\"\",\n" +
                "                    \"remote_ip\":\"66.20.10.151\",\n" +
                "                    \"province\":\"\",\n" +
                "                    \"city\":\"\",\n" +
                "                    \"local_port\":\"23\",\n" +
                "                    \"scan_duration\":0,\n" +
                "                    \"is_lock\":false,\n" +
                "                    \"scan_count\":1,\n" +
                "                    \"location\":\"\"\n" +
                "                },\n" +
                "                \"terminate\":1,\n" +
                "                \"event_group_id\":\"9b91655a-fde9-4c70-8f0e-38fb501fb2d0\",\n" +
                "                \"detail\":\"66.20.10.151非法探测本机未开放的端口 23\",\n" +
                "                \"user\":\"k\",\n" +
                "                \"host_name\":\"DESKTOP-R2SE668\",\n" +
                "                \"status\":0\n" +
                "            },\n" +
                "            {\n" +
                "                \"policy_id\":\"33\",\n" +
                "                \"ipv6_address\":\"fe80::7581:75be:72dd:6c3b\",\n" +
                "                \"source\":\"Agent\",\n" +
                "                \"uuid\":\"5b56ea35e40155a2e7933c9b9f2ce263\",\n" +
                "                \"mac\":\"00-0C-29-B0-45-D9\",\n" +
                "                \"result\":0,\n" +
                "                \"relation_field\":\"remote_ip:221.231.81.213\",\n" +
                "                \"log_category\":\"Network\",\n" +
                "                \"id\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"operating\":\"Connect\",\n" +
                "                \"event\":true,\n" +
                "                \"behavior\":1,\n" +
                "                \"timestamp\":1640140898000,\n" +
                "                \"log_name\":\"PortScan\",\n" +
                "                \"level\":2,\n" +
                "                \"os_version\":\"Windows 10 Enterprise\",\n" +
                "                \"operation_mode\":0,\n" +
                "                \"ip_address\":\"66.20.10.151\",\n" +
                "                \"event_category\":\"IllegalNetwork\",\n" +
                "                \"superior\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"response\":\"{\\\"global_block_list\\\":false,\\\"global_trust_list\\\":false,\\\"isolation\\\":false,\\\"time\\\":\\\"2021-12-22 10:47:58\\\",\\\"add_to_block_list\\\":false,\\\"kill\\\":false,\\\"user\\\":\\\"admin\\\",\\\"userId\\\":1,\\\"add_to_trust_list\\\":false}\",\n" +
                "                \"os_type\":1,\n" +
                "                \"processing\":1640140905956,\n" +
                "                \"arguments\":{\n" +
                "                    \"intranet\":false,\n" +
                "                    \"local_ip\":\"66.20.10.151\",\n" +
                "                    \"country\":\"\",\n" +
                "                    \"remote_ip\":\"221.231.81.213\",\n" +
                "                    \"province\":\"\",\n" +
                "                    \"city\":\"\",\n" +
                "                    \"local_port\":\"49848,49863,49864,49865,49866,49868,49869,49870,49871,49872,49873,49874,49875,49876,49877,49878,49879,49880,49881,49882,49883,49884,49885,49886,49887,49888,49889,49890,49891,49892,49893,49894,49895,49896,49897,49898,49899,49900,49901,49902,49903,49904,49905,49906\",\n" +
                "                    \"scan_duration\":30,\n" +
                "                    \"is_lock\":false,\n" +
                "                    \"scan_count\":5,\n" +
                "                    \"location\":\"\"\n" +
                "                },\n" +
                "                \"terminate\":1,\n" +
                "                \"event_group_id\":\"9b91655a-fde9-4c70-8f0e-38fb501fb2d0\",\n" +
                "                \"detail\":\"\",\n" +
                "                \"user\":\"Administrator\",\n" +
                "                \"host_name\":\"DESKTOP-2MN5VA6\",\n" +
                "                \"status\":1\n" +
                "            }\n" +
                "        ],\n" +
                "        \"edges\":[\n" +
                "            {\n" +
                "                \"relation_field\":\"remote_ip\",\n" +
                "                \"source\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"relation_type\":\"remote_ip\",\n" +
                "                \"target\":\"248E1128-6191-4E9C-9496-9E376541CE0D\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"relation_field\":\"remote_ip\",\n" +
                "                \"source\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"relation_type\":\"remote_ip\",\n" +
                "                \"target\":\"07EC9369-D760-42C7-8791-76F2432675E0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"relation_field\":\"remote_ip\",\n" +
                "                \"source\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"relation_type\":\"remote_ip\",\n" +
                "                \"target\":\"B5909455-3B3E-4415-AAF2-B1DBD30B790D\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"relation_field\":\"remote_ip\",\n" +
                "                \"source\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\",\n" +
                "                \"relation_type\":\"remote_ip\",\n" +
                "                \"target\":\"0C8E136F-1819-4A93-8EE7-FEC098555525\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"relation_field\":\"remote_ip\",\n" +
                "                \"source\":\"1fa41b71-f80c-438c-bd12-43bdbc8fc857\",\n" +
                "                \"relation_type\":\"remote_ip\",\n" +
                "                \"target\":\"A65F7A21-EF46-48FA-9897-6B5DA731A411\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}" ;


        getEventIdAndType(content,"nodes","id","log_name");

    }

}
