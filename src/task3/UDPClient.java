package task3;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            File file = new File("file_to_send.txt");
            byte[] fileData = new byte[(int) file.length()];

            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(fileData);
            }

            InetAddress serverAddress = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(
                    fileData,
                    fileData.length,
                    serverAddress,
                    9876
            );
            socket.send(packet);
            System.out.println("File sent to server.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
