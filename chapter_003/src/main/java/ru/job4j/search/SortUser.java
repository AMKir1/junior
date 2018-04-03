package ru.job4j.search;

import java.util.*;

/**
 * Chapter_003. Collection. Lite.
 * Task: 1. Организовать сортировку User [#10034]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

public class SortUser {

    Set<UserModel> sort (List<UserModel> list) {
        Set<UserModel> setUser = new TreeSet<>();
        for(UserModel user : list) {
            setUser.add(user);
        }
        return setUser;
    }
}
