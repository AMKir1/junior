package ru.job4j.wait;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать шаблон Producer Consumer.[1098#453887].
 * Task: 1. Реализовать ThreadPool[1099#453883].
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
    private volatile Queue<T> queue = new LinkedList<>();
    private final int size;

    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    public void offer(T value) throws InterruptedException {
        synchronized (this) {
            while (isFull()) {
                wait();
            }
            this.queue.offer(value);
            notifyAll();
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
        return this.queue.size() == size;
    }
}