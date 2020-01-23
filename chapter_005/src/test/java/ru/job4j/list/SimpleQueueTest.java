package ru.job4j.list;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.3.1 Очередь на двух стеках [#160]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {

    SimpleQueue queue = new SimpleQueue();

    @Test
    public void pushElements() {
        assertThat(queue.toString(), is("Collection is empty   Collection is empty"));
        queue.push("1");
        assertThat(queue.toString(), is("[ 1 ]   Collection is empty"));
        queue.push("2");
        assertThat(queue.toString(), is("[ 2, 1 ]   Collection is empty"));
        queue.push("3");
        assertThat(queue.toString(), is("[ 3, 2, 1 ]   Collection is empty"));
    }

    @Test
    public void pollElements() {
        assertThat(queue.toString(), is("Collection is empty   Collection is empty"));
        queue.push("1");
        assertThat(queue.toString(), is("[ 1 ]   Collection is empty"));
        queue.push("2");
        assertThat(queue.toString(), is("[ 2, 1 ]   Collection is empty"));
        queue.push("3");
        assertThat(queue.toString(), is("[ 3, 2, 1 ]   Collection is empty"));

        assertThat(queue.poll(), is("1"));
        assertThat(queue.toString(), is("Collection is empty   [ 2, 3 ]"));

        assertThat(queue.poll(), is("2"));
        assertThat(queue.toString(), is("Collection is empty   [ 3 ]"));

    }
}