package ru.job4j.search;

import java.util.HashMap;
import java.util.List;
/*
 * Chapter_003. Collection. Lite.
 * Task: 2. Написать программу преобразования List в Map. [#10093]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class UserConvert {
    /*
     * Метод для перобразования List в Map
     * @param list список объектов.
     * @return hashMap возвращает карту.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashMap = new HashMap<>();
        for (User user : list) {
            hashMap.put(user.getId(), user);
        }
        return hashMap;
    }
}
