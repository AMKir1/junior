package ru.job4j.map;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 8. Реализовать собственную структуру данных - HashMap [#1008]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HashMapTest {

    public HashMap hm = new HashMap();

    @Test
    public void whenAddElements() {
        assertThat(hm.toString(), is("HashMap{table=[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=0}"));
        hm.insert(1, 1);
        assertThat(hm.toString(), is("HashMap{table=[null, Obj{key=1, value=1}, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=1}"));
        hm.insert(2, 2);
        assertThat(hm.toString(), is("HashMap{table=[null, Obj{key=1, value=1}, Obj{key=2, value=2}, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=2}"));
        hm.insert(8, 8);
        assertThat(hm.toString(), is("HashMap{table=[null, Obj{key=1, value=1}, Obj{key=2, value=2}, null, null, null, null, null, Obj{key=8, value=8}, null, null, null, null, null, null, null], size=16, count=3}"));
    }

    @Test
    public void whenAddElementInFullCell() {
        assertThat(hm.toString(), is("HashMap{table=[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=0}"));
        hm.insert(1, 1);
        assertThat(hm.insert(1, 100), is(false));
        assertThat(hm.toString(), is("HashMap{table=[null, Obj{key=1, value=1}, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=1}"));
    }

    @Test
    public void whenGetElement() {
        assertThat(hm.toString(), is("HashMap{table=[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=0}"));
        hm.insert(1, 1);
        assertThat(hm.toString(), is("HashMap{table=[null, Obj{key=1, value=1}, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=1}"));
        assertThat(hm.get(1), is(1));
    }

    @Test
    public void whenDeleteElement() {
        assertThat(hm.toString(), is("HashMap{table=[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=0}"));
        hm.insert(1, 1);
        assertThat(hm.toString(), is("HashMap{table=[null, Obj{key=1, value=1}, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=1}"));
        hm.delete(1);
        assertThat(hm.toString(), is("HashMap{table=[null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null], size=16, count=0}"));
    }

    @Test
    public void whenTableIsFull() {
        assertThat(hm.getSize(), is(16));
        hm.insert(1, 1);
        hm.insert(2, 2);
        hm.insert(3, 3);
        hm.insert(4, 4);
        hm.insert(5, 5);
        hm.insert(6, 6);
        hm.insert(7, 7);
        hm.insert(8, 8);
        hm.insert(9, 9);
        hm.insert(10, 10);
        hm.insert(11, 11);
        hm.insert(12, 12);
        hm.insert(13, 13);
        hm.insert(14, 14);
        assertThat(hm.getSize(), is(32));
    }

    @Test
    public void whenUseIterator() {
        hm.insert(1, 1);
        hm.insert(2, 2);

        Iterator<String> it = hm.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(hm.get(it.next()), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(hm.get(it.next()), is(2));
        assertThat(it.hasNext(), is(false));
    }
}