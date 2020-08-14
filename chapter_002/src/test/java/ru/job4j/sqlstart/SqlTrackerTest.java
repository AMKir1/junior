package ru.job4j.sqlstart;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* class TrackerTest
*/
public class SqlTrackerTest {

/**
*
*/
@Test
public void whenAddItem() throws Exception {
    Store tracker = new SqlTracker();
    Item item1 = new Item("test1");
    tracker.add(item1);
    assertThat(tracker.findByName(item1.getName()).get(0).getName(), is(item1.getName()));
}
/**
*
*/
@Test
public void whenUpdateItem() throws Exception {
    Store tracker = new SqlTracker();
    Item item1 = tracker.findByName("test1").get(0);
    tracker.replace(item1.getId(), new Item("test2", "testDescription2", 1L, "1"));
    assertThat(tracker.findById(item1.getId()).getName(), is("test2"));
}
/**
*
*/
@Test
public void whenDeleteItem() throws Exception {
    Store tracker = new SqlTracker();
    Item item3 = new Item("Test3");
    tracker.add(item3);
    tracker.delete(item3.getId());
    Store expected = null;
    assertThat(tracker.findById(item3.getId()), is(expected));
}

/**
*
*/
@Test
public void whenFindByName() {
    Store tracker = new SqlTracker();
    List<Item> items = tracker.findByName("test_1");
    assertThat(items.size(), is(3));
}
/**
*
*/
@Test
public void whenFindByIdAndNotNull() {
    Store tracker = new SqlTracker();
    assertThat(tracker.findById("10").getName(), is("test_3434"));
}
/**
*
*/
@Test
public void whenFindByIdAndNull() {
    Store tracker = new SqlTracker();
    Store expected = null;
    assertThat(tracker.findById("7"), is(expected));
}
}