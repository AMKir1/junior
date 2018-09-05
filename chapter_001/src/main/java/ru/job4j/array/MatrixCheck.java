package ru.job4j.array;
/**
 * Class MatrixCheck решение задачи части 001 6.7. Квадратный массив заполнен true или false по диагоналям.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i ++) {
                if (data[i][i] == data[i + 1][i + 1] && data[i][i] == data[i][data.length - i - 1]) {
                  break;
                }
                else result = false;
        }
        return result;
    }
}