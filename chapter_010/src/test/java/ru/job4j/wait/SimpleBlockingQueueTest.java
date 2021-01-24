package ru.job4j.wait;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Реализовать шаблон Producer Consumer.[1098#453887].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */

import org.junit.Test;

public class SimpleBlockingQueueTest {

    /**
     * When use bounded blocking queue.
     */
    @Test
    public void whenUseBoundedBlockingQueue() throws InterruptedException {
        SimpleBlockingQueue<Integer> sbq = new SimpleBlockingQueue<>();
        Thread producer = new Thread(() -> sbq.offer(1));
        Thread consumer = new Thread((sbq::poll));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }

    /**
     * When Use Bounded Blocking Queue And Did Not Offer.
     */
    @Test
    public void whenUseBoundedBlockingQueueAndDidNotOffer() throws InterruptedException {
        SimpleBlockingQueue<Integer> sbq = new SimpleBlockingQueue<>();
        Thread producer = new Thread();
        Thread consumer = new Thread((sbq::poll));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }

    /**
     * When Use Bounded Blocking Queue And Queue Is Full.
     */
    @Test
    public void whenQueueIsFull() throws InterruptedException {
        SimpleBlockingQueue<Integer> sbq = new SimpleBlockingQueue<>();
        Thread producer = new Thread(() -> {
            int i = 0;
            while (i < 22) {
                sbq.offer(i++);
            }
        });
        Thread consumer = new Thread((sbq::poll));
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
