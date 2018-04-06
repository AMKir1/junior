package ru.job4j.search;

import java.util.LinkedList;
/*
 * Chapter_003. Collection. Lite.
 * Task: 2. Очередь с приоритетом на LinkedList [#41670]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /*
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список
        if (tasks.size() != 0) {
           for (Task t : tasks) {
                if (t.getPriority() > task.getPriority()) {
                    tasks.add(tasks.indexOf(t), task);
                    break;
                }
            }
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
