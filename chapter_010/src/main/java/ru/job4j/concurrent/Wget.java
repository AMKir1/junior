package ru.job4j.concurrent;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1.2. Режим ожидания.[231217#453892].
 * Task: 3.1. Прерывание блокированной нити.[267413#453893].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class Wget {
    public static void main(String[] args) {
        Thread loading = new Thread(() -> {
            try {
                for(int i = 0; i <= 100; i++) {
                    System.out.print("\rLoading : " + i  + "%");
                    Thread.sleep(60);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        loading.start();
    }
}
