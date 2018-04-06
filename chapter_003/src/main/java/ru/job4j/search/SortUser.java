package ru.job4j.search;

import java.util.*;
/*
 * Chapter_003. Collection. Lite.
 * 2. Сортировка User с использованием Comparator [#10036]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class SortUser {

    Set<UserModel> sort(List<UserModel> list) {
        Set<UserModel> setUser = new TreeSet<>(list);
        return setUser;
    }

    public List<UserModel> sortNameLength(List<UserModel> list) {
        list.sort(new Comparator<UserModel>() {
            @Override
            public int compare(UserModel o1, UserModel o2) {
                Integer user1 = o1.getName().length();
                Integer user2 = o2.getName().length();
                return user1.compareTo(user2);
            }
        });
        return list;
    }

    public List<UserModel> sortByAllFields(List<UserModel> list) {
        list.sort(new Comparator<UserModel>() {
            @Override
            public int compare(UserModel o1, UserModel o2) {
                Integer user1 = o1.getName().length();
                Integer user2 = o2.getName().length();
                return user1.equals(user2) ? o1.getAge().compareTo(o2.getAge()) : user1.compareTo(user2);
            }
                  });
        return list;
    }
}
