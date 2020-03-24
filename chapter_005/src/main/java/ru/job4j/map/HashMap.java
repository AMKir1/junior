package ru.job4j.map;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 8. Реализовать собственную структуру данных - HashMap [#1008]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.*;

public class HashMap<K, V> implements Iterable<K> {

    private static int defaultSize = 16;
    private static float checker = 0.8f;

    private Obj<K, V>[] table;
    private int size;
    private int count = 0;

    public HashMap() {
        this.size = defaultSize;
        this.table = new Obj[this.size];
    }

    public int getSize() {
        return size;
    }

    private int hash(K key) {
        return key.hashCode() % this.size;
    }

    boolean insert(K key, V value) {
        int i = hash(key);
        if (table[i] == null || !table[i].getKey().equals(key)) {
            table[i] = new Obj<>(key, value);
            this.count++;
            checkSize(this.count);
            return true;
        }
        return false;
    }

    V get(K key) {
        int i = hash(key);
        return table[i].getKey().equals(key) ? this.table[i].getValue() : null;
    }

    boolean delete(K key) {
        int i = hash(key);
        if (this.table[i] != null && this.table[i].getKey().equals(key)) {
            this.table[i] = null;
            count--;
            return true;
        }
        return false;
    }

    void checkSize(int curr) {
        if (curr >= this.size * checker) {
            this.size *= 2;
            Obj<K, V>[] table2 = new Obj[this.size];
            for (Obj<K, V> o : this.table) {
                if (o != null) {
                    table2[hash(o.getKey())] = o;
                }
            }
            this.table = table2;
        }
    }

    @Override
    public String toString() {
        return "HashMap{"
                + "table=" + Arrays.toString(table)
                + ", size=" + size
                + ", count=" + count
                + '}';
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                while (pos < size) {
                    if (table[pos] != null) {
                        return true;
                    }
                    pos++;
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[pos] == null && pos < size) {
                    pos++;
                }
                K result = table[pos].getKey();
                pos++;
                return result;
            }
        };
    }

    public class Obj<K, V> {
        K key;
        V value;

        Obj(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Obj{"
                    + "key=" + key
                    + ", value=" + value
                    + '}';
        }
    }
}