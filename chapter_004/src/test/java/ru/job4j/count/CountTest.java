package ru.job4j.count;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Chapter_004. Stream API.
 * Task: Stream API [#106993]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class CountTest {
    /**
     * Check method count
     */
    @Test
    public void testCount() {
        Count count = new Count();
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(220, is(count.count(list)));
    }
}