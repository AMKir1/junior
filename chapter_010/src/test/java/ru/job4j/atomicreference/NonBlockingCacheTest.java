package ru.job4j.atomicreference;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Неблокирующий кеш[4741#453912].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;

public class NonBlockingCacheTest {

    /**
     * When Throw Exception In Cache
     */
    @Test
    public void whenThrowExceptionInCache() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        NonBlockingCache cache = new NonBlockingCache();
        cache.add(new NonBlockingCache.Base(1, 1));
        Thread thread1 = new Thread(
                () -> {
                    try {
                        cache.update(new NonBlockingCache.Base(1, 1));
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    try {
                        cache.update(new NonBlockingCache.Base(1, 1));
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        Assert.assertThat(ex.get().getMessage(), is("Failed to update data for : Base{id=1, version=1}"));
    }

    /**
     * When add model
     */
    @Test
    public void whenAddModel() throws InterruptedException {
        NonBlockingCache cache = new NonBlockingCache();
        Thread thread1 = new Thread(
                () -> {
                    try {
                        cache.add(new NonBlockingCache.Base(1, 1));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    try {
                        cache.add(new NonBlockingCache.Base(1, 2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        Assert.assertThat(cache.toString(), is("NonBlockingCache{cache={1=Base{id=1, version=1}}}"));
    }

    /**
     * When del model
     */
    @Test
    public void whenDelModel() throws InterruptedException {
        NonBlockingCache cache = new NonBlockingCache();
        NonBlockingCache.Base base = new NonBlockingCache.Base(1, 1);
        Thread thread1 = new Thread(
                () -> {
                    try {
                        cache.add(base);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    try {
                        cache.delete(base);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        Assert.assertThat(cache.toString(), is("NonBlockingCache{cache={}}"));
    }

    /**
     * When update model
     */
    @Test
    public void whenUpdateModel() throws InterruptedException {
        NonBlockingCache cache = new NonBlockingCache();
        NonBlockingCache.Base base1 = new NonBlockingCache.Base(1, 1);
        NonBlockingCache.Base base2 = base1;
        Thread thread1 = new Thread(
                () -> {
                    try {
                        cache.add(base1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    try {
                        cache.update(base2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        Assert.assertThat(cache.toString(), is("NonBlockingCache{cache={1=Base{id=1, version=2}}}"));
    }

}
