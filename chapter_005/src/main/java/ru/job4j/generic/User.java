package ru.job4j.generic;

/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.2.2. Реализовать Store<T extends Base> [#157]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class User extends Base {

    protected User(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("User - %s", getId());
    }
}
