package ru.job4j.concurrent;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1.1. Состояние нити.[229175#453891].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println(first.getName() + " : "  + first.getState());
        System.out.println(second.getName() + " : "  + second.getState());
        first.start();
        second.start();
        printNotTerminatedState(first);
        printNotTerminatedState(second);
        System.out.println(first.getName() + " : "  + first.getState());
        System.out.println(second.getName() + " : "  + second.getState());
        System.out.println("fin!");
    }

    private static void printNotTerminatedState(Thread thread) {
        while (thread.getState() != Thread.State.TERMINATED) {
            System.out.println(thread.getName() + " : "  + thread.getState());
        }
    }
}
