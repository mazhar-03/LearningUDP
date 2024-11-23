package task2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(9191)){
            String msg = "Hello how you doing";
            byte[] buffer= msg.getBytes();
            InetAddress IP = InetAddress.getLocalHost();

            DatagramPacket sending = new DatagramPacket(buffer, buffer.length , IP, 9191);
            socket.send(sending);

            byte[] buffer2 = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer2, buffer2.length);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server response: " + response);
        }catch (Exception e){
            System.out.println("Error has occurred: " + e.getMessage());
        }
    }
}
