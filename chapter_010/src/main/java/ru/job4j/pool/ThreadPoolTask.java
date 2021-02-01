package ru.job4j.pool;

import static java.lang.String.*;

/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать ThreadPool[1099#453883].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 3.
 */
public class ThreadPoolTask implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    private int task;

    public ThreadPoolTask(int task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(format("Task %s", this.task));
    }
}
