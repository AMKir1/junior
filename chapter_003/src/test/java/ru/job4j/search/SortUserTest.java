package ru.job4j.search;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    /**
     * Chapter_003. Collection. Lite.
     * Сортировка User с использованием Comparator [#10036]
     * Collection API Улучшения [#70623]
     * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
     * @version 1
     */

public class SortUserTest {
    public SortUser su = new SortUser();

    public  List<UserModel> list = List.of(
        new UserModel("SEM", 40),
        new UserModel("NIKOLAI", 15),
        new UserModel("KIM", 37),
        new UserModel("VASYA", 21),
        new UserModel("NIKOLAI", 10)
    );

    @Test
    public void testSortAgeOfUsers() {
        List<UserModel> expected = List.of(
            new UserModel("NIKOLAI", 10),
            new UserModel("NIKOLAI", 15),
            new UserModel("VASYA", 21),
            new UserModel("KIM", 37),
            new UserModel("SEM", 40)
        );
        Set<UserModel> result = su.sort(list);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void testSortUserByLenghtName() {
        List<UserModel> expected = List.of(
                new UserModel("SEM", 40),
                new UserModel("KIM", 37),
                new UserModel("VASYA", 21),
                new UserModel("NIKOLAI", 15),
                new UserModel("NIKOLAI", 10)
        );
        List<UserModel> result = su.sortNameLength(list);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void testSortUserByNameAndAge() {
        List<UserModel> expected = List.of(
                new UserModel("KIM", 37),
                new UserModel("NIKOLAI", 10),
                new UserModel("NIKOLAI", 15),
                new UserModel("SEM", 40),
                new UserModel("VASYA", 21)
        );
        List<UserModel> result = su.sortByAllFields(list);
        assertThat(result.toString(), is(expected.toString()));
    }
}
