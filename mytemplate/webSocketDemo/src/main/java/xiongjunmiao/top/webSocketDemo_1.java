package xiongjunmiao.top;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author DangR-X
 * @date 2020/12/30
 * @description
 */
public class webSocketDemo_1 {


    public static void main(String[] args) {


        try {
            Socket socket = new Socket("127.0.0.1", 8080);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            ServerSocket serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));



        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
