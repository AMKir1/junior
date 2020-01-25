package ru.job4j.list;

/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.4. Задан связанный список. Определить цикличность. [#161]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class Node<T> {
    T value;
    Node<T> next;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public static boolean hasCycle(Node first) {
        boolean cycle = false;
        Node u1 = first;
        Node u2 = u1;
        while (!cycle) {
            while (u2.next != null) {
                if (!u1.equals(u2.next) && !u2.equals(u2.next.next)) {
                    u2 = u2.next;
                } else {
                    cycle = true;
                    break;
                }
            }
            if (u1.next == null) {
                break;
            }
            u1 = u1.next;
            u2 = u1;
        }
        return cycle;
    }

    @Override
    public String toString() {
        return next != null ? "Node: { value: " + this.value + ", next: " + next.value + " }" : "Node: { value: " + this.value + ", next: null }";
    }
}
