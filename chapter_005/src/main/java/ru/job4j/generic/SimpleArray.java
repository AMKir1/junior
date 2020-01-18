package ru.job4j.generic;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.2.1. Реализовать SimpleArray<T> [#156]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 4
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private int index = 0;
    private Object[] array;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        if (this.index == this.array.length) {
            throw new NoSuchElementException("Array is full");
        }
        this.array[this.index++] = model;
    }

    public void set(int index, T model) {
        checkIndex(index);
        this.array[index] = model;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        this.array[this.array.length - 1] = null;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) this.array[index];
    }

    public void checkIndex(int index) {
        if (index >= this.index || index < 0) {
            throw new NoSuchElementException("false");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int pos;

            @Override
            public boolean hasNext() {
                return pos < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[pos++];
            }
        };
    }

    @Override
    public String toString() {
        String result = "[ ";
        for (int i = 0; i < this.array.length; i++) {
            if (i != this.array.length - 1) {
                result += this.array[i] + ", ";
            } else {
                result += this.array[i] + "]";
            }
        }
        return result;
    }
}
