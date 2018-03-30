package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Chapter_003. Collection. Lite.
 * Task: 2. Очередь с приоритетом на LinkedList [#41670]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }
}
