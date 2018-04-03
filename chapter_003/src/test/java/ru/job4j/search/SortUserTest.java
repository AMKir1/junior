package ru.job4j.search;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    /**
     * Chapter_003. Collection. Lite.
     * Task: 1. Организовать сортировку User [#10034]
     * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
     * @version 1
     */

public class SortUserTest {

    @Test
    public void testSortAgeOfUsers () {
        SortUser su = new SortUser();
        List<UserModel> list = new ArrayList<>();
        list.add(new UserModel("VASYA", 40));
        list.add(new UserModel("KOLYA", 15));
        list.add(new UserModel("BORIS", 37));
        Set<UserModel> userSet = su.sort(list);
        assertThat(userSet , is(-1));
    }

        @Test
        public void testSortUserByLenghtName() {
            SortUser su = new SortUser();
            List<UserModel> list = new ArrayList<>();
            list.add(new UserModel("SEM", 40));
            list.add(new UserModel("NIKOLAI", 15));
            list.add(new UserModel("KIM", 37));
            list.add(new UserModel("VASYA", 21));
            List<UserModel> userlist = su.sortNameLength(list);
            assertThat(userlist , is(-1));
        }

        @Test
        public void testSortUserByNameAndAge() {
            SortUser su = new SortUser();
            List<UserModel> list = new ArrayList<>();
            list.add(new UserModel("SEM", 40));
            list.add(new UserModel("VASYA", 15));
            list.add(new UserModel("KIM", 37));
            list.add(new UserModel("VASYA", 21));
            List<UserModel> userlist = su.sortByAllFields(list);
            assertThat(userlist , is(-1));
        }
}
