package ru.job4j.atomicreference;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 0. CAS - операции[6859#453913].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class CASCountTest {

    @Test
    public void whenThrowException() throws InterruptedException {
        final CASCount count = new CASCount();
        Thread thread1 = new Thread(count::increment);
        Thread thread2 = new Thread(count::increment);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        Assert.assertThat(count.get(), is(2));
    }

}
