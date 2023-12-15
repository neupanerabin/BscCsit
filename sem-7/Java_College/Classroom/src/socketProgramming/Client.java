package socketProgramming;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        return in.readLine();
    }

    public void stopConnection() throws IOException {
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
        if (clientSocket != null) {
            clientSocket.close();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.startConnection("localhost", 7777);

            // Sending a message to the server
            String response = client.sendMessage("hello server");
            System.out.println("Server response: " + response);

            // Sending another message to the server
            String anotherResponse = client.sendMessage("How are you?");
            System.out.println("Server response: " + anotherResponse);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.stopConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
