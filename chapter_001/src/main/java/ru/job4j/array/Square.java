package ru.job4j.array;
/**
 * Class Square решение задачи части 001 урок 6.0. Заполнить массив степенями чисел
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i ++) {
            rst[i-1] = i * i;
        }
        return rst;
    }
}
