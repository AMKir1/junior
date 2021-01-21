package ru.job4j.concurrent;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1.1. Состояние нити.[229175#453891].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println("First Thread: " + first.getState());
        System.out.println("Second Thread: " + second.getState());
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED) {
            System.out.println("First Thread: " + first.getState());
        }
        while (second.getState() != Thread.State.TERMINATED) {
            System.out.println("Second Thread: " + second.getState());
        }
        System.out.println("First Thread: " + first.getState());
        System.out.println("Second Thread: " + second.getState());
        System.out.println("fin!");
    }
}
