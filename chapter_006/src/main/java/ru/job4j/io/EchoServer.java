package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 0. Что такое Socket? [#4850]
 * Task: 1. Бот [#7921] v2
 * Task: 4. Slf4j - вывод exception. [#268853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String msg = "";
                    while (!str.isEmpty()) {
                        if (str.contains("msg=")) {
                            if (str.contains("Exit")) {
                                server.close();
                            } else if (str.contains("Hello")) {
                                msg = "Hello, dear friend.";
                            } else {
                                String[] mass = str.split("=");
                                msg = mass.length > 1 ? mass[1].split(" ")[0] : "";
                            }
                        }
                        System.out.println(str);
                        str = in.readLine();
                    }
                    if (!server.isClosed()) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(msg.getBytes());
                    }
                } catch (Exception e) {
                    LOG.error("OutputStream error: ", e);
                }
            }
        } catch (Exception e) {
            LOG.error("ServerSocket error: ", e);
        }
    }
}