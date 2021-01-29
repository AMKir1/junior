package ru.job4j.pool;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать ThreadPool[1099#453883].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */
import org.junit.Test;

public class ThreadPoolTest {
    /**
     * When Use User Storage Successful transfer.
     */
    @Test
    public void when() throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                threadPool.work(new ThreadPoolTask(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        producer.start();
        producer.join();

        Thread threads = new Thread(() -> {
            threadPool.addTasksToThreads(threadPool.getTasks());
        });

        threads.start();
        threads.join();
        threadPool.startThreads();
//        threadPool.shutdown();
        threadPool.joinThreads();

//        producer.interrupt();
        threadPool.shutdown();

    }
}
