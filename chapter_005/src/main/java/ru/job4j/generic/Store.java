package ru.job4j.generic;

/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.2.2. Реализовать Store<T extends Base> [#157]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);

}
