package ru.job4j.synch;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 4. ThreadSafe динамический список [1105#453907].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynamicList;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {

    private DynamicList list = new DynamicList(10);

    public synchronized void add(T value) {
        this.list.add(value);
    }

    public synchronized T get(int index) {
        return (T) this.list.get(index);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.list).iterator();
    }

    private synchronized Iterable<T> copy(DynamicList list) {
        DynamicList result = new DynamicList(10);
        list.iterator().forEachRemaining(result::add);
        return result;
    }
}
