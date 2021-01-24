package ru.job4j.wait;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать шаблон Producer Consumer.[1098#453887].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private static final int SIZE = 10;
    private final Queue<T> queue = new LinkedList<>();

    public void offer(T value) {
        synchronized (this) {
            while (isFull()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(!isFull()) {
                this.queue.offer(value);
                notifyAll();
            }
        }
    }

    public T poll() throws InterruptedException {
        T t;
        synchronized (this) {
            while (isEmpty()) {
                wait();
            }
            t = this.queue.poll();
            notifyAll();
        }
        return t;
    }

    @Override
    public synchronized String toString() {
        return "SimpleBlockingQueue{" + "queue=" + queue + '}';
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public synchronized boolean isFull() {
        return this.queue.size() == SIZE;
    }
}