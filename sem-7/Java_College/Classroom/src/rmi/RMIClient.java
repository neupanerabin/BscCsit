package rmi;

//Client program
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			MyRemoteInterface remoteObject = (MyRemoteInterface) registry.lookup("MyRemoteObject");

			String response = remoteObject.sayHello();
			System.out.println("Response from server: " + response);
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
