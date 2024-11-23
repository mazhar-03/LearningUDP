package task3;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(9876)) {
            System.out.println("File Server is running...");
            byte[] buffer = new byte[4096];

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);

            try (FileOutputStream fos = new FileOutputStream("received_file.txt")) {
                fos.write(packet.getData(), 0, packet.getLength());
            }
            System.out.println("File received and saved as 'received2_file.txt'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
