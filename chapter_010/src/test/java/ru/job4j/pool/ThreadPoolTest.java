package ru.job4j.pool;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать ThreadPool[1099#453883].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 3.
 */
import org.junit.Test;

public class ThreadPoolTest {
    /**
     * When Use ThreadPool.
     */
    @Test
    public void whenUseThreadPool() {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.work(new ThreadPoolTask(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}
