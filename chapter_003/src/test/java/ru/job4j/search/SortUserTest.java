package ru.job4j.search;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    /**
     * Chapter_003. Collection. Lite.
     * Task: 2. Сортировка User с использованием Comparator [#10036]
     * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
     * @version 1
     */

public class SortUserTest {

    @Test
    public void testSortAgeOfUsers() {
        SortUser su = new SortUser();
        List<UserModel> list = new ArrayList<>();
        list.add(new UserModel("VASYA", 40));
        list.add(new UserModel("KOLYA", 15));
        list.add(new UserModel("BORIS", 37));
        Set<UserModel> userSet = su.sort(list);
        assertThat(userSet.toString(), is(new StringBuilder()
                .append("[age = " + list.get(1).getAge() + ", name = " + list.get(1).getName())
                .append(", age = " + list.get(2).getAge() + ", name = " + list.get(2).getName())
                .append(", age = " + list.get(0).getAge() + ", name = " + list.get(0).getName() + "]")
                .toString()));
    }

        @Test
        public void testSortUserByLenghtName() {
            SortUser su = new SortUser();
            List<UserModel> list = new ArrayList<>();
            list.add(new UserModel("SEM", 40));
            list.add(new UserModel("NIKOLAI", 15));
            list.add(new UserModel("KIM", 37));
            list.add(new UserModel("VASYA", 21));
            su.sortNameLength(list);
            assertThat(list.get(0).getName(), is("SEM"));
        }

        @Test
        public void testSortUserByNameAndAge() {
            SortUser su = new SortUser();
            List<UserModel> list = new ArrayList<>();
            list.add(new UserModel("SEM", 40));
            list.add(new UserModel("VASYA", 15));
            list.add(new UserModel("KIM", 37));
            list.add(new UserModel("VASYA", 21));
            su.sortByAllFields(list);
            assertThat(list.get(0).getName(), is("KIM"));
        }
}
