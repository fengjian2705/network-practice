import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread{

    private Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream ps = null;
        try {
            ps = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {

            // 实现对客户端发来的字符串内容接收并打印
            String s = null;
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("客户端"+inetAddress+"发来的字符串内容是: " + s);
            if ("bye".equalsIgnoreCase(s)) {
                System.out.println("客户端"+inetAddress+"已下线");
                break;
            }
            // 实现服务器想客户端回发字符串 "I received"
            ps.println("I received");
        }
        ps.close();
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
