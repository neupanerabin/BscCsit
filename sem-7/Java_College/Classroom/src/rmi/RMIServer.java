package rmi;

//Server program
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

 public static void main(String[] args) {
     try {
         MyRemoteObject remoteObject = new MyRemoteObject();
         MyRemoteInterface stub = (MyRemoteInterface) UnicastRemoteObject.exportObject(remoteObject, 0);

         Registry registry = LocateRegistry.createRegistry(1099);
         registry.rebind("MyRemoteObject", stub);

         System.out.println("Server is ready.");
     } catch (RemoteException e) {
         System.err.println("Server exception: " + e.toString());
         e.printStackTrace();
     }
 }
}