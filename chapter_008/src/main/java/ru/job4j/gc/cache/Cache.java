package ru.job4j.gc.cache;
/*
 * Chapter_008. Garbage Collection [#147]
 * Task: 4.1 Реализации кеша на SoftReference [#1592]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Map;

public abstract class Cache<K, V> {

    private Map<K, V> cache;
    private String key;
    private String value;

    public Cache(Map<K, V> cache) {
        this.cache = cache;
    }

    public Map<K, V> getCache() {
        return cache;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}