package cn.oscar.game;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

public class RmiJndiSever {
    public static void main(String[] args) {
        try {
            //注册RMI服务器端口
            LocateRegistry.createRegistry(18080);
            //建立RMI服务端接口实现对象
            RMITest server = new RMITestImpl();
            //设置JNDI属性
            Properties properties = new Properties();
            //RMI的JNDI工厂类
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY , "com.sun.jndi.rmi.registry.RegistryContextFactory");
            //RMI服务端的访问地址
            properties.setProperty(Context.PROVIDER_URL, "rmi://192.168.1.167:18080");
            //根据JNDI属性，创建上下文
            InitialContext ctx = new InitialContext(properties);
            //将服务端接口实现对象与JNDI命名绑定，这个地方写的并不是很规范
            //如果在J2EE开发中，规范的写法是，绑定的名字要以java:comp/env/开头
            ctx.bind("RMITest", server);
            System.out.println("RMI与JNDI集成服务启动.等待客户端调用...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}