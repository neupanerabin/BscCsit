package network_Configuration;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkConfiguration {

    public static void main(String[] args) {
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                System.out.println("Interface: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());

                // Get all IP addresses for the network interface
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("    IP Address: " + inetAddress.getHostAddress());
                }
                System.out.println("-----------------------------------------");
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
