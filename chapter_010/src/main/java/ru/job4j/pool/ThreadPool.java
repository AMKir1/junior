package ru.job4j.pool;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать ThreadPool[1099#453883].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 3.
 */

import ru.job4j.wait.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(100);

    ThreadPool() {
        for (int i = 0; i < size; i++) {
            threads.add(new Thread(() -> {
                while (!tasks.isEmpty() || !Thread.currentThread().isInterrupted()) {
                    try {
                        ThreadPoolTask tpt = (ThreadPoolTask) tasks.poll();
                        if (tpt != null) {
                            tpt.run();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }));
        }
        threads.forEach(Thread::start);
    }

    public synchronized void work(Runnable job) {
        tasks.offer(job);
    }

    public synchronized void shutdown() {
        threads.forEach(Thread::interrupt);
    }
}