package cn.oscar.common;

import redis.clients.jedis.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


/**
 * 单机版的Jedis连接池的用法
 */
public class RedisClient {

    public static Jedis GetRedisClient(String ip, int port, String password, int database) throws IOException {
        Integer maxTotal = 60000;        // 最大连接数
        Integer maxIdle = 1000;            // 最大空闲数
        Integer MinIdle = 1;            //
        Integer maxWaitMillis = 3000;       // 超时时间
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(MinIdle);
        JedisPool jedisPool = new JedisPool(poolConfig, ip, port, 2000, password, database);

        // 从连接池中获取jedis对象
        Jedis jedis = jedisPool.getResource();

        return jedis;

    }

    /**
     * 集群的Jedis连接池的用法
     */
    public static JedisCluster getRedisCluster(String clusterNodes, String password) {
        JedisCluster jedisCluster = null;
        Integer maxTotal = 60000;        // 最大连接数
        Integer maxIdle = 1000;            // 最大空闲数
        Integer maxWaitMillis = 3000;
        //分割出集群节点
        String[] cNodes = clusterNodes.split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String node : cNodes) {
            String[] ipAndPort = node.split(":");
            nodes.add(new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1])));
        }

        // 配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);


        // 连接Redis集群
        jedisCluster = new JedisCluster(nodes, 3000, 3000, 5, password, jedisPoolConfig);

        return jedisCluster;

    }

    public static void main(String[] args) throws IOException {


        Integer maxTotal = 60000;        // 最大连接数
        Integer maxIdle = 1000;            // 最大空闲数
        Integer MinIdle = 1;            //
        Integer maxWaitMillis = 3000;       // 超时时间

        // 设置Redis Pool相关参数
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(MinIdle);


        String nodes = "r-8vb372e30ea17a54pd.redis.zhangbei.rds.aliyuncs.com";
        //"172.168.0.2:6002,172.168.0.3:6003,172.168.0.4:6004";
        String password = "QDhic20190719";
        String key = "CUSTOM_PAGE_TEMPLATE_384387968149740999";
        // 创建Jedis连接池
//        JedisPool jedisPool = new JedisPool(poolConfig, nodes, 6379, 1000, password, 0);
//
//        // 从连接池中获取jedis对象
//        Jedis jedis = jedisPool.getResource();//
//        // 进行操作
////        jedis.set("name", "beyond");//
//        System.out.println(jedis.get(key));//
//        // 归还连接
//        jedis.close();//
//        // 关闭连接池
//        jedisPool.close();

        Jedis testJedis = RedisClient.GetRedisClient(nodes, 6379, password, 0);
        System.out.println(testJedis.get(key));
        testJedis.close();


        nodes = "r-8vb372e30ea17a54pd.redis.zhangbei.rds.aliyuncs.com:6379";
        //连接Redis
        JedisCluster jmeterRedisClusterUtil = null;
        try {
            jmeterRedisClusterUtil = RedisClient.getRedisCluster(nodes, password);

        } catch (Throwable e) {
            System.out.println("error: " + e);
            throw e;
        }

        //获取数据
        String value = jmeterRedisClusterUtil.get(key);

        System.out.println(value);

        // 操作哈希表
        String hashKey = "CLIENT_DETAILS";
        java.util.Map<String, String> hashMap = jmeterRedisClusterUtil.hgetAll(hashKey);
        for (String key1 : hashMap.keySet()) {
            System.out.println(key1 + ": " + hashMap.get(key1));
        }

        String hvalue = jmeterRedisClusterUtil.hget(hashKey, "third");
        System.out.println(hvalue);


    }
}