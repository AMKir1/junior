package ru.job4j.atomicity;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Синхронизация общих ресурсов.[1096#453901].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public final class Cache {
    private static Cache cache;

    public synchronized static Cache instOf() {
        if (cache == null) {
            cache = new Cache();
        }
        return cache;
    }
}