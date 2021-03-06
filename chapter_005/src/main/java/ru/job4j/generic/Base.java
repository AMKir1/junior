package ru.job4j.generic;

/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.2.2. Реализовать Store<T extends Base> [#157]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
