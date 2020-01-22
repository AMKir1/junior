package ru.job4j.list;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.2. Создать контейнер на базе связанного списка  [#159]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements Iterable<E> {
    private int size;
    private int modCount = 0;

    public class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public Node<E> first;

    public int size() {
        return this.size;
    }

    public void add(E element) {
        Node<E> newnode = new Node<E>(element);
        if (first == null) {
            first = newnode;
        } else {
            newnode.next = first;
            first = newnode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        check(index);
        Node<E> result = this.first;
        for (int i = 0; i == index; i++) {
            result = result.next;
        }
        return result.value;
    }

    public E remove(int index) {
        check(index);
        Node<E> findres = this.first;
        this.first = this.first.next;
        size--;
        modCount++;
        return findres.value;
    }

    public void check(int index) {
        if (index >= this.size || index < 0) {
            throw new NoSuchElementException("false");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            Node<E> curr = null;
            Node<E> prev = null;
            Node<E> in = first;

            @Override
            public boolean hasNext() {
                checkModCount();
                return in != null;
            }

            @Override
            public E next() {
                checkModCount();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                prev = curr;
                curr = in;
                in = in.next;

                return (E) curr.value;

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
        Node<E> res = first;
        String result = "LinkedList is empty";
        if (res != null) {
            result = "[ ";
            for (int i = 0; i < this.size; i++) {
                result += i != this.size - 1 ? res.value + ", " : res.value + " ]";
                res = res.next;
            }
        }
        return result;
    }
}
