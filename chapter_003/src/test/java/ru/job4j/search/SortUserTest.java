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
        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(new UserModel("VASYA", 40));
        userModelList.add(new UserModel("KOLYA", 15));
        userModelList.add(new UserModel("BORIS", 37));
        Set<UserModel> userModelSet = new TreeSet<>();
        userModelSet.addAll(userModelList);
        userModelSet = su.sort(userModelList);
        assertThat(userModelSet.toString() , is(
                new StringBuilder()
                .append("[age = " + userModelList.get(1).getAge() + ", name = " + userModelList.get(1).getName())
                .append(", age = " + userModelList.get(2).getAge() + ", name = " + userModelList.get(2).getName())
                .append(", age = " + userModelList.get(0).getAge() + ", name = " + userModelList.get(0).getName() + "]")
                .toString()
            ));
    }
}
