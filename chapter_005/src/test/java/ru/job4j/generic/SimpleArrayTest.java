package ru.job4j.generic;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.2.1. Реализовать SimpleArray<T> [#156]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
 */
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SimpleArrayTest {

    SimpleArray array = new SimpleArray(4);

    @Test
    public void testAddElement() {
        this.array.add(1);
        assertThat(this.array.get(0), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        SimpleArray array = new SimpleArray(0);
        array.add(0);
    }

    @Test
    public void testSetElement() {
        this.array.add(1);
        assertThat(this.array.get(0), is(1));
        this.array.set(0, 5);
        assertThat(this.array.get(0), is(5));
    }

    @Test
    public void testRemoveElement() {
        this.array.add(1);
        this.array.add(2);
        this.array.add(3);
        this.array.add(4);
        assertThat(this.array.get(0), is(1));
        this.array.remove(0);
        assertThat(this.array.get(0), is(2));
        assertThat(this.array.get(1), is(3));
        assertThat(this.array.get(2), is(4));
    }

    @Test
    public void whenIterateOverElements() {
        array.add("1");
        array.add("2");
        Iterator<String> it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorAfterLastElement() {
        array.add("1");
        Iterator<String> it = array.iterator();
        it.next();
        it.next();
    }

}
