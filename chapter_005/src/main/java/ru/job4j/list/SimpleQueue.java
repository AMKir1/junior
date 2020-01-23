package ru.job4j.list;

/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.3.1 Очередь на двух стеках [#160]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class SimpleQueue<T> {

    private SimpleStack stak1 = new SimpleStack();
    private SimpleStack stak2 = new SimpleStack();

    public <T> T poll() {
        T res = null;
        if (stak2.size() == 0) {
            while (stak1.size() != 0) {
                stak2.push(stak1.poll());
            }
            res = (T) stak2.poll();
        } else {
            res = (T) stak2.poll();
        }
        return res;
    }

    public void push(T value) {
        stak1.push(value);
    }

    @Override
    public String toString() {
        return stak1.toString() + "   " + stak2.toString();
    }
}
