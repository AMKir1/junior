package ru.job4j.collectioin;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: Проверить две строчки на идентичность. [#273008]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Arrays;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        } else {
            char[] chLeft = left.toCharArray();
            char[] chRight = right.toCharArray();
            Arrays.sort(chLeft); //o(n log (n))
            Arrays.sort(chRight); //o(n log (n))

            for (int i = 0; i < chLeft.length; i++) { //o(n)
                if (chLeft[i] != chRight[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}