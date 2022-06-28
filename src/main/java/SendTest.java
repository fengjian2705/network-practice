import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendTest {

    public static void main(String[] args) {
        DatagramSocket ds = null;

        try {
            // 1. 创建 DatagramSocket 对象
            ds = new DatagramSocket();
            // 2. 创建 DatagramPacket 对象，并提供接收方的通信地址和端口号
            byte[] bytes = "hello".getBytes();
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),7777);
            // 3. 发送数据
            ds.send(dp);
            System.out.println("发送数据成功 !");
            // 接收回发的数据内容
            byte[] bytes1 = new byte[20];
            DatagramPacket dp2 = new DatagramPacket(bytes1, bytes1.length);
            ds.receive(dp2);
            System.out.println("接收到的回发消息内容: "+ new String(bytes1,0,bytes1.length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭 Socket 并释放有关的资源
            if (ds !=null) {
                ds.close();
            }
        }

    }
}
