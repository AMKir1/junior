package ru.job4j.kiss;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Принципы Kiss, Dry и Yagni [#238813]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return getValue(value, comparator, x -> x >= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return getValue(value, comparator, x -> x <= 0);
    }

    public <T> T getValue(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T res = value.get(0);
        for (int i = 0; i < value.size() - 1; i++) {
            res = predicate.test(comparator.compare(res, value.get(i + 1))) ? res : value.get(i + 1);
        }
        return res;
    }
}