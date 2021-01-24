package ru.job4j.buffer;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 2. Обеспечить остановку потребителя.[66825#453885].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import ru.job4j.wait.SimpleBlockingQueue;

public class ParallelSearch {
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        final int size = 3;
        final Thread consumer = new Thread(
                () -> {
                    int s = 0;
                    while (s < size) {
                        try {
                            System.out.println(queue.poll());
                            s++;
                        } catch (Exception e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
        consumer.start();
        new Thread(
                () -> {
                    for (int index = 0; index != size; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }

        ).start();
    }
}
