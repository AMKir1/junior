package ru.job4j.atomicreference;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 0. CAS - операции[6859#453913].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>(0);

    public void increment() {
        int ref;
        int result;
        do {
            ref = count.get();
            result = ref + 1;
        } while (!count.compareAndSet(ref, result));
    }

    public int get() {
        return count.get();
    }
}