import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) {

        try {
            // 1. 使用参数指定的字符串来构造对象
            URL url = new URL("https://www.lagou.com/");
            // 2. 获取相关信息并打印出来
            System.out.println("协议: " + url.getProtocol());
            System.out.println("主机名称: " + url.getHost());
            System.out.println("端口号: " + url.getPort());

            // 3. 建立连接并读取相关信息
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            br.close();
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
