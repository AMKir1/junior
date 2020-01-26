package ru.job4j.set;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 1. Реализовать коллекцию Set на массиве [#996]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {
    SimpleSet simpleSet = new SimpleSet(4);

    @Test
    public void whenAddElements() {
        assertThat(simpleSet.toString(), is("[ null, null, null, null ]"));
        simpleSet.add("1");
        assertThat(simpleSet.toString(), is("[ 1, null, null, null ]"));
    }

    @Test
    public void whenAddDiffElements() {
        assertThat(simpleSet.toString(), is("[ null, null, null, null ]"));
        simpleSet.add("1");
        simpleSet.add("2");
        simpleSet.add("3");
        simpleSet.add("4");
        assertThat(simpleSet.toString(), is("[ 1, 2, 3, 4 ]"));
    }

    @Test
    public void whenAddSameElements() {
        assertThat(simpleSet.toString(), is("[ null, null, null, null ]"));
        simpleSet.add("1");
        simpleSet.add("1");
        simpleSet.add("1");
        simpleSet.add("1");
        assertThat(simpleSet.toString(), is("[ 1, null, null, null ]"));
    }

    @Test
    public void whenUseIterator() {
        simpleSet.add("1");
        simpleSet.add("2");

        Iterator<String> it = simpleSet.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenUseIteratorWithSameElement() {
        simpleSet.add("1");
        simpleSet.add("1");

        Iterator<String> it = simpleSet.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(false));
    }


    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorWithSetMod() {
        simpleSet.add("1");
        simpleSet.add("2");

        Iterator<String> it = simpleSet.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));

        simpleSet.add("3");
        it.next();
    }
}
