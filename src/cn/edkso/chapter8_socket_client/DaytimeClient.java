package cn.edkso.chapter8_socket_client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 通过Socket获取网络时间
 */
public class DaytimeClient {

    public static void main(String[] args) {
        String hostname = args.length > 0 ? args[0]:"time.nist.gov";
        Socket socket = null;
        try {
            socket = new Socket(hostname, 13);
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");

            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char)c);
            }
            System.out.println(time);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
