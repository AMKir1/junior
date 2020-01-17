package ru.job4j.generic;

/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.2.2. Реализовать Store<T extends Base> [#157]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import java.util.function.Consumer;

public class AbstractStroe<T extends Base> implements Store<T> {

    private SimpleArray<T> store = new SimpleArray<>(5);

    @Override
    public void add(T model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return findToDo(id, (x) -> store.set(x, model));
    }

    @Override
    public boolean delete(String id) {
        return findToDo(id, (x) -> store.remove(x));
    }

    @Override
    public T findById(String id) {
        for (int i = 0; i < 5; i++) {
            if (id.equals(store.get(i).getId())) {
                return store.get(i);
            }
        }
        return null;
    }

    private boolean findToDo(String id, Consumer<Integer> consumer) {
        boolean result = false;
        for (int i = 0; i < 5; i++) {
            if (id.equals(store.get(i).getId())) {
                consumer.accept(i);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "{ ";
        for (T t : store) {
            if (t != null) {
                result += t.toString() + " ";
            }
        }
        result += "}";
        return result;
    }
}
