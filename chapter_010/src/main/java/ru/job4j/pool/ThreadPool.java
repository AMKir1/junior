package ru.job4j.pool;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать ThreadPool[1099#453883].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */

import ru.job4j.wait.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>(size);

    public void work(Runnable job) {
        tasks.offer(job);
        if (tasks.isFull()) {
            notify();
        }
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public void addTasksToThreads(SimpleBlockingQueue<Runnable> tasks) {
        threads.add(new Thread(() -> {
           while (!tasks.isEmpty()) {
               try {
                   ThreadPoolTask tpt = (ThreadPoolTask) tasks.poll();
                   if (tpt != null) {
                       tpt.run();
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
                   Thread.currentThread().interrupt();
               }
           }
        }));
    }

    public void startThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void joinThreads() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public SimpleBlockingQueue<Runnable> getTasks() {
        return tasks;
    }
}