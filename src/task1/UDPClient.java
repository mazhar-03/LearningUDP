package task1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket()){
            InetAddress serverAddress = InetAddress.getLocalHost();
            String message = "Hello, UDP Server!";

            byte[] buffer = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, serverAddress, 9999);
            socket.send(sendPacket);

            //receiving
            byte[] buffer2 = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer2, buffer2.length);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server response: " + response);
        }catch (Exception e){
            System.out.println("Error occurred" + e.getMessage());
        }
    }
}
