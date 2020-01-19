package ru.job4j.list;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.1. Создать динамический список на базе массива. [#158]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<E> implements Iterable<E> {

    private Object[] container;
    private int index;
    public int length;
    private int modCount = 0;

    public DynamicList(int size) {
        this.length = size;
        this.container = new Object[size];
    }


    public void add(E element) {
        if (this.index == this.length) {
            this.container = Arrays.copyOf(this.container, this.length * 2);
            this.length = this.length * 2;
        }
        this.container[index++] = (E) element;
        modCount++;
    }

    public E get(int index) {
        check(index);
        return (E) this.container[index];
    }

    public void check(int index) {
        if (index >= this.index || index < 0) {
            throw new NoSuchElementException("false");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int pos;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModCount();
                return (pos < index);
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[pos++];
            }

            private void checkModCount() throws ConcurrentModificationException {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    @Override
    public String toString() {
        String result = "[ ";
        for (int i = 0; i < this.container.length; i++) {
            result += i != this.container.length - 1 ? this.container[i] + ", " : this.container[i] + " ]";
        }
        return result;
    }
}
