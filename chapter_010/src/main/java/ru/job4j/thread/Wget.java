package ru.job4j.thread;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 4. Скачивание файла с ограничением.[144271#453890].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Wget implements Runnable {
    private final String url;
    private final int speed;

    public Wget(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        Long start = System.currentTimeMillis();
        String file = url;
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            try {
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                    Long timeFinish = System.currentTimeMillis();
                    long speedAfterDownload = this.speed - (timeFinish - start);
                    if (speedAfterDownload <= this.speed && speedAfterDownload > 0) {
                        Thread.sleep(speedAfterDownload);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length > 1) {
            String url =  args[0];
            int speed = Integer.parseInt(args[1]);
            Thread wget = new Thread(new Wget(url, speed));
            wget.start();
            wget.join();
        }
    }
}
