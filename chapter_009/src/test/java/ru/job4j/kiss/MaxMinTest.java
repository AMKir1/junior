package ru.job4j.kiss;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Принципы Kiss, Dry и Yagni [#238813]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {

    List<User> usersList = Arrays.asList(
            new User(1, "Alexandr", 35),
            new User(2, "Boris", 18),
            new User(3, "Klaudia", 27)
    );

    MaxMin mm = new MaxMin();

    @Test
    public void whenUseAgeComporator() {
        assertThat(mm.max(usersList, User.ageComparator).getAge(), is(35));
        assertThat(mm.min(usersList, User.ageComparator).getAge(), is(18));
    }

    @Test
    public void whenUseNameComporator() {
        assertThat(mm.max(usersList, User.lengthNameComparator).getName(), is("Alexandr"));
        assertThat(mm.min(usersList, User.lengthNameComparator).getName(), is("Boris"));
    }

}
