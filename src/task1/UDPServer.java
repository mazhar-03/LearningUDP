package task1;

import javax.print.DocFlavor;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(9999)){
            byte[] buffer= new byte[1024];
            while(true){
                //receiving
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(requestPacket);

                String receivedMsg = new String(requestPacket.getData(), 0, requestPacket.getLength());
                System.out.println("Received: " + receivedMsg);

                //sending again
                byte[] buffer2 = receivedMsg.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(buffer2, buffer2.length,
                requestPacket.getAddress(), requestPacket.getPort()
                );
                socket.send(responsePacket);
            }

        }catch (Exception e){
            System.out.println("Error occurred" + e.getMessage());
        }
    }
}
