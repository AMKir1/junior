package ru.job4j.wait;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать шаблон Producer Consumer.[1098#453887].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private static final int SIZE = 20;
    private Queue<T> queue = new LinkedList<>();

    public void offer(T value) {
        synchronized (this) {
            while (this.queue.size() == SIZE) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.queue.offer(value);
            notify();
        }
    }

    public T poll() {
        T t;
        synchronized (this) {
            while (this.queue.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            t = this.queue.peek();
        }
        return t;
    }
}