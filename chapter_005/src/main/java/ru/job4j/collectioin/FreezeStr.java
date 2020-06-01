package ru.job4j.collectioin;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: Проверить две строчки на идентичность. [#273008]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.Arrays;
import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        } else {
            char[] chLeft = left.toCharArray();
            char[] chRight = right.toCharArray();

            Arrays.sort(chLeft); //o(n log (n))
            Arrays.sort(chRight); //o(n log (n))

            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();

            for (int i = 0; i < chLeft.length; i++) {
                map1.put(chLeft[i], i);
                map2.put(chRight[i], i);
            }

            return map1.equals(map2);
        }
    }

}