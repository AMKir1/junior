package ru.job4j.concurrent;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Запуск нити. Thread#start()[1016#453894].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class ConcurrentOutput {
    public static void main(String[] args) {
        Thread another = new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        );
//        Thread another2 = new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println(Thread.currentThread().getName());
//                    }
//                }
//        );
        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        another.start();
//        another2.run();
        second.start();
        System.out.println(Thread.currentThread().getName());
    }
}
