package task2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDPServer {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(9191)){
            //receiving
            byte[] buffer = new byte[1024];
            while(true){
                DatagramPacket receiving = new DatagramPacket(buffer, buffer.length);
                socket.receive(receiving);

                String message = new String(receiving.getData(), 0, receiving.getLength());
                System.out.println("Received from client: " + message);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
