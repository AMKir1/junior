package ru.job4j.concurrent;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1.1. Состояние нити.[229175#453891].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 3.
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println(first.getName() + " : "  + first.getState());
        System.out.println(second.getName() + " : "  + second.getState());
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            if (first.getState() != Thread.State.TERMINATED) {
                System.out.println(first.getName() + " : " + first.getState());
            }
            if (second.getState() != Thread.State.TERMINATED) {
                System.out.println(second.getName() + " : " + second.getState());
            }
        }
        System.out.println(first.getName() + " : "  + first.getState());
        System.out.println(second.getName() + " : "  + second.getState());
        System.out.println("fin!");
    }
}
