package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface MyRemoteInterface extends Remote {
	String sayHello() throws RemoteException;
}
