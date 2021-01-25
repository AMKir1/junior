package ru.job4j.atomicreference;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 0. CAS - операции[6859#453913].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASСount<T> {
    private final AtomicReference<Integer> count = new AtomicReference<>();

    public void increment() {
        Integer ref;
        Integer result;
        do {
            ref = this.get();
            result = ref + 1;
        } while (!count.compareAndSet(ref, result));
//        throw new UnsupportedOperationException("Count is not impl.");
    }

    public int get() {
        Integer ref;
        Integer result;
        do {
            ref = count.get();
            result = ref == null ? 0 : ref;
        } while (!count.compareAndSet(ref, result));
        return result;
//        throw new UnsupportedOperationException("Count is not impl.");
    }
}