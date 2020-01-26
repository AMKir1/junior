package ru.job4j.set;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 1. Реализовать коллекцию Set на массиве [#996]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import ru.job4j.list.DynamicList;

import java.util.Iterator;

public class SimpleSet<E> {
    private DynamicList simplelist;

    public SimpleSet(int size) {
        this.simplelist = new DynamicList(size);
    }

    public void add(E e) {
        if (check(e)) {
            this.simplelist.add(e);
        }
    }

    public boolean check(E e) {
        for (Object elem : this.simplelist) {
            if (elem.equals(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return simplelist.toString();
    }

    public Iterator<E> iterator() {
        return simplelist.iterator();
    }
}
