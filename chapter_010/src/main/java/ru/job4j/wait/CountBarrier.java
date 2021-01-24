package ru.job4j.wait;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 0. Управление нитью через wait.[6858#453888].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class CountBarrier {
    private final Object monitor = this;

    private final int total;

    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public  void count() {
        synchronized (monitor) {
            this.count++;
            monitor.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (monitor) {
            if (this.count == this.total) {
                monitor.notifyAll();
            } else {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
