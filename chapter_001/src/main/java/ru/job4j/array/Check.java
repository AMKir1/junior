package ru.job4j.array;
/**
 * Class Check решение задачи части 001 6.3. Массив заполнен true или false
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}
