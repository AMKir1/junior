package ru.job4j.linked;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. Immutable объекты[267918#453899].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import net.jcip.annotations.Immutable;

@Immutable
public class Node<T> {
    private final Node next;
    private final T value;

    public Node(final Node next, final T value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

}
