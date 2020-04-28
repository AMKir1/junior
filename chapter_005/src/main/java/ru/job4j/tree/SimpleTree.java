package ru.job4j.tree;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 1. Создать элементарную структуру дерева [#1711]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SimpleTree<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }

}
