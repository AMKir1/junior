package ru.job4j.search;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. ForkJoinPool[315067#453881].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class IndexSearchTest {
    /**
     * When Use ThreadPool.
     */
    @Test
    public void whenMoreThan10() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 9, 6, 7, 8, 5, 10, 11, 12, 13, 14, 15, 16, 17};
        IndexSearch is = new IndexSearch(arr, 0, arr.length, 5);
        assertThat(is.compute(), is(8));
    }

    @Test
    public void whenLessThanOrEqualTo10() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 9, 6, 7, 8, 5, 10};
        IndexSearch is = new IndexSearch(arr, 0, arr.length, 5);
        assertThat(is.compute(), is(8));
    }
}
