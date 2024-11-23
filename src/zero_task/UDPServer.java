package zero_task;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(9999);

            byte[] b1 = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b1, b1.length);
            ds.receive(dp);

            String str = new String(dp.getData(),0,dp.getLength());
            int num = Integer.parseInt(str.trim());
            int result = num * num;

            byte[] b2 = String.valueOf(result).getBytes();
            InetAddress clientAddress = dp.getAddress();
            int clientPort = dp.getPort();
            DatagramPacket dp1 = new DatagramPacket(b2, b2.length, clientAddress, clientPort);
            ds.send(dp1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
