import java.net.ServerSocket;
import java.net.Socket;

public class ServerStringTest {

    public static void main(String[] args) throws Exception {

        // 1. 创建 ServerSocket 类型的对象并提供端口号
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2. 等待客户的连接请求，调用 accept 方法
        Socket socket = null;
        while (true) {
            System.out.println("等待客户端的连接请求");
            // 当没有客户端连接时，则服务器阻塞在 accept 方法这里
            socket = serverSocket.accept();
            System.out.println("客户端"+socket.getInetAddress()+"连接成功 !");
            // 每当有一个客户端连接成功，则需要启动一个新的线程为之服务
            new ServerThread(socket).start();
        }

        // 3. 使用输入输出流进行通信

        // 4. 关闭 Socket 并释放有关的资源
//        serverSocket.close();
    }
}
