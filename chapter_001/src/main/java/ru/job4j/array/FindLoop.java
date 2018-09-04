package ru.job4j.array;
/**
 * Class FindLoop решение задачи части 001 урок 6.1. Классический поиск перебором.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
