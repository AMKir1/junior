package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 0. Что такое Socket? [#4850]
 * Task: 1. Бот [#7921]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String msg = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("msg")) {
                            if (str.contains("Exit")) {
                                server.close();
                            } else if (str.contains("Hello")) {
                                msg = "Hello, dear friend.";
                            } else {
                                msg = str.split("=")[1].split(" ")[0];
                            }
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(msg.getBytes());
                }
            }
        }
    }
}