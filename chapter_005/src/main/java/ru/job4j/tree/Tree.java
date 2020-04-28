package ru.job4j.tree;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 1. Создать элементарную структуру дерева [#1711]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import java.util.*;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if ((findBy(parent).isPresent() && findBy(child).isPresent())) {
            return false;
        }
        findBy(parent).get().children.add(new Node<E>(child));
        return true;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

}
