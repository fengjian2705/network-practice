import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveTest {

    public static void main(String[] args) {
        DatagramSocket ds = null;

        try {
            // 1. 创建 DatagramSocket 类型对象并提供端口号
            ds = new DatagramSocket(7777);
            // 2. 创建 DatagramPacket 类型的对象并提供缓冲区
            byte[] bytes = new byte[20];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            // 3. 通过 Socket 接收数据内容并存放到 Packet 里面，调用 receive 方法
            System.out.println("等待数据的到来...");
            ds.receive(dp);
            System.out.println("接收到的内容是: " + new String(bytes, 0, bytes.length) + " !");
            // 将字符串 "I received" 回发客户端
            byte[] bytes1 = "I received".getBytes();
            DatagramPacket dp2 = new DatagramPacket(bytes1, bytes1.length, dp.getAddress(), dp.getPort());
            ds.send(dp2);
            System.out.println("回发数据成功 ！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭 Socket 并释放有关的连接
            if (ds != null) {
                ds.close();
            }
        }


    }
}
