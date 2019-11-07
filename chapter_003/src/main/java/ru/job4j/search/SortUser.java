package ru.job4j.search;
import java.util.*;
import java.util.stream.Collectors;
/*
 * Chapter_003. Collection. Lite.
 * Сортировка User с использованием Comparator [#10036]
 * Collection API Улучшения [#70623]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class SortUser {

    Set<UserModel> sort(List<UserModel> list) {
        return new TreeSet<>(list);
    }

    public List<UserModel> sortNameLength(List<UserModel> list) {
        return list.stream().sorted(Comparator.comparing(userModel -> userModel.getName().length())).collect(Collectors.toList());
    }

    public List<UserModel> sortByAllFields(List<UserModel> list) {
        return list.stream().sorted(Comparator.comparing(UserModel::getName).thenComparing(UserModel::getAge)).collect(Collectors.toList());
    }
}
