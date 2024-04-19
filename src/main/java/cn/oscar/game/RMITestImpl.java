package cn.oscar.game;


import java.rmi.RemoteException;
        import java.rmi.server.UnicastRemoteObject;

public class RMITestImpl extends UnicastRemoteObject implements RMITest {
    private static final long serialVersionUID = 1L;

    protected RMITestImpl() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        return "hello Oscar!!";
    }
}