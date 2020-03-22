package ru.job4j.list;

/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack [#71474]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 5
 */
public class SimpleStack<T> {


    private SimpleLinkedList<T> collection = new SimpleLinkedList<T>();

    public <T> T poll() {
        return collection.size() == 0 ? null : (T) collection.remove();
    }

    public void push(T value) {
        collection.add(value);
    }

    public int size() {
        return collection.size();
    }

    @Override
    public String toString() {
            return collection.toString();
    }
}
