package org.throwable.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/12/21 18:48
 */
public class SocketGet {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9099);
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("GET http://localhost:9099/hello/get HTTP/1.1");
        writer.println("Accept-Language: zh-cn");
        writer.println("Connection: Keep-Alive");

        writer.println();
        writer.println();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }
        String lastResult = "";
        if (result.length() > 0) {
            lastResult = result.substring(0, result.lastIndexOf("\n"));
        }
        System.out.println(lastResult);
        socket.close();
    }
}
