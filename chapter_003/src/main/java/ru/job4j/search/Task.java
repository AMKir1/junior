package ru.job4j.search;
/**
 * Chapter_003. Collection. Lite.
 * Task: 2. Очередь с приоритетом на LinkedList [#41670]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
