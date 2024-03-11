package rmi;

import java.rmi.RemoteException;

class MyRemoteObject implements MyRemoteInterface {
	@Override
	public String sayHello() throws RemoteException {
		return "\n Hello from the remote object! of RMI APPLICATION of RabiN";
	}
}