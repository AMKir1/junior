package ru.job4j.generic;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.2.1. Реализовать SimpleArray<T> [#156]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.NoSuchElementException;

public class SimpleArray<T> {

    int index = 0;
    T[] array;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public void add(T model) {
        checkIndex(index);
        this.array[this.index++] = model;
    }

    public void set(int index, T model) {
        checkIndex(index);
        this.array[index] = model;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
    }

    public T get(int index) {
        checkIndex(index);
        return (T) this.array[index];
    }

    public void checkIndex(int index) {
        if (index >= this.array.length || index < 0) {
            throw new NoSuchElementException("false");
        }
    }

}
