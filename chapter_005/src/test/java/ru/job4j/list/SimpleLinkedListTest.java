package ru.job4j.list;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.2. Создать контейнер на базе связанного списка  [#159]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleLinkedListTest {
    SimpleLinkedList linkedlist = new SimpleLinkedList();

    @Test
    public void whenAddElements() {
        assertThat(linkedlist.toString(), is("LinkedList is empty"));
        linkedlist.add("1");
        assertThat(linkedlist.toString(), is("[ 1 ]"));
    }

    @Test
    public void whenGetElement() {
        linkedlist.add("1");
        linkedlist.add("1");
        linkedlist.add("1");
        linkedlist.add("1");
        assertThat(linkedlist.get(0), is("1"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetElementAfterLast() {
        linkedlist.add("1");
        linkedlist.add("1");
        linkedlist.add("1");
        linkedlist.add("1");
        linkedlist.get(4);
    }

    @Test
    public void whenUseIterator() {
        linkedlist.add("1");
        linkedlist.add("2");
        System.out.println(linkedlist.toString());
        Iterator<String> it = linkedlist.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenUseIteratorWithArrayListMod() {
        linkedlist.add("1");

        Iterator<String> it = linkedlist.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        linkedlist.add("2");
        it.next();
    }
}
