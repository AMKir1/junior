package ru.job4j.search;

import java.util.Comparator;
import java.util.List;

/*
 * Chapter_003. Collection. Lite.
 * Task: 3. Компаратор для строк. [#35008]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int minsize = Math.min(left.length(), right.length());
        int i = 0;
        do {
            if (left.charAt(i) < right.charAt(i)) {
                result = -1;
                i++;
                break;
            } else if (left.charAt(i) > right.charAt(i)) {
                result = 1;
                i++;
                break;
            }
            i++;
        } while (i != minsize);
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
