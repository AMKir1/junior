package ru.job4j.list;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.1. Создать динамический список на базе массива. [#158]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DynamicListTest {

    DynamicList arraylist = new DynamicList(4);

    @Test
    public void whenAddElements() {
        assertThat(arraylist.toString(), is("[ null, null, null, null ]"));
        arraylist.add("1");
        assertThat(arraylist.toString(), is("[ 1, null, null, null ]"));
    }

    @Test
    public void whenAddLastElement() {
        assertThat(arraylist.toString(), is("[ null, null, null, null ]"));
        arraylist.add("1");
        arraylist.add("1");
        arraylist.add("1");
        arraylist.add("1");
        assertThat(arraylist.toString(), is("[ 1, 1, 1, 1 ]"));
        assertThat(arraylist.length, is(4));
        arraylist.add("1");
        assertThat(arraylist.length, is(8));
        assertThat(arraylist.toString(), is("[ 1, 1, 1, 1, 1, null, null, null ]"));
    }

    @Test
    public void whenGetElement() {
        arraylist.add("1");
        arraylist.add("1");
        arraylist.add("1");
        arraylist.add("1");
        assertThat(arraylist.get(0), is("1"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetElementAfterLast() {
        arraylist.add("1");
        arraylist.add("1");
        arraylist.add("1");
        arraylist.add("1");
        arraylist.get(4);
    }

    @Test
    public void whenUseIterator() {
        arraylist.add("1");
        arraylist.add("2");

        Iterator<String> it = arraylist.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorWithArrayListMod() {
        arraylist.add("1");
        arraylist.add("2");

        Iterator<String> it = arraylist.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));

        arraylist.add("3");
        it.next();
    }

}
