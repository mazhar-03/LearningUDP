package zero_task;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket ds = new DatagramSocket()) {
            int i = 8;
            byte[] byteFormat = String.valueOf(i).getBytes();
            InetAddress ia = InetAddress.getLocalHost();

            //data sending
            DatagramPacket dp = new DatagramPacket(byteFormat, byteFormat.length, ia, 9999);
            ds.send(dp);

            //data receiving
            byte[] b1 = new byte[1024];
            DatagramPacket dp1 = new DatagramPacket(b1, b1.length);
            ds.receive(dp1);

            String msg = new String(dp1.getData(), 0, dp1.getLength());
            System.out.println("msg: " + msg);

        }catch(Exception e ){
            System.out.println("Error occured" + e.getMessage());
        }
    }
}
