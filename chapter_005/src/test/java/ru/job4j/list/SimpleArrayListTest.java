package ru.job4j.list;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.0 Создать метод delete для односвязного списка [#51424]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDelFirstElement() {
        assertThat(list.toString(), is("[ 3, 2, 1 ]"));
        assertThat(list.delete(), is(3));
        assertThat(list.toString(), is("[ 2, 1 ]"));
        assertThat(list.getSize(), is(2));
    }
}