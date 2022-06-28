import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientStringTest {

    public static void main(String[] args) throws Exception {

        // 1. 创建 Socket 类型的对象并提供服务器的主机名和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        System.out.println("连接服务器成功");
        // 2. 使用输入输出流进行通信
        Scanner scanner = new Scanner(System.in);
        PrintStream ps = new PrintStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (true) {

//        Thread.sleep(10000);
            // 实现客户端发送的内容由叫输入
            System.out.println("请输入要发送的数据内容: ");
            String s = scanner.next();
            // 实现客户端向服务器发送字符串 "hello"
            ps.println(s);
            System.out.println("客户端发送数据内容成功 !");
            if ("bye".equalsIgnoreCase(s)) {
                System.out.println("聊天结束 !");
                break;
            }
            // 实现接收服务器发送来的内容并打印
            String s1 = br.readLine();
            System.out.println("服务器来的字符串是: " + s1);
        }

        // 3. 关闭 Socket 并释放有关的资源
        br.close();
        socket.close();
        ps.close();
    }
}
