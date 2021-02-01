package ru.job4j.search;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. ForkJoinPool[315067#453881].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
public class IndexSearch<T> extends RecursiveTask<Integer> {

    private final T[] array;
    private final int from;
    private final int to;
    private final T object;

    public IndexSearch(T[] array, int from, int to, T object) {
        this.array = array;
        this.from = from;
        this.to = to;
        this.object = object;
    }

    @Override
    protected Integer compute() {
        if (array.length / Runtime.getRuntime().availableProcessors() <= 10) {
            return lineSearch(this.array, this.object);
        }
        return ForkJoinTask.invokeAll(createSubtasks()).stream().mapToInt(ForkJoinTask::join).max().orElse(-1);
    }


    private Collection<IndexSearch<T>> createSubtasks() {
        List<IndexSearch<T>> dividedTasks = new ArrayList<>();
        dividedTasks.add(new IndexSearch<>(array, from, array.length / 2, object));
        dividedTasks.add(new IndexSearch<>(array, (array.length / 2) + 1, to, object));
        return dividedTasks;
    }

    private int lineSearch(T[] array, T object) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
}
