package cn.oscar.game;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMITest extends Remote {
    public String sayHello() throws RemoteException;


}