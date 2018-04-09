package ru.job4j.start;

	import org.junit.Test;

	import java.util.ArrayList;

	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class TrackerTest
	*/
public class TrackerTest {
	/**
	*
	*/
	@Test
	public void whenAddItem() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("test1", "Description1", 123L, "1");
		tracker.add(item1);
		assertThat(tracker.findAll().get(0), is(item1));
	}
	/**
	*
	*/
	@Test
	public void whenUpdateItem() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("test1", "testDescription", 1L, "1"));
		tracker.update(new Item("test2", "testDescription2", 1L, "1"));
		assertThat(tracker.findAll().get(0).getName(), is("test2"));
	}
	/**
	*
	*/
	@Test
	public void whenDeleteItem() {
		Tracker tracker = new Tracker();
		Item item3 = new Item("Test3", "Desc3", 3L, "1");
		tracker.add(item3);
		tracker.delete(item3.getId());
		Tracker expected = null;
		assertThat(tracker.findById(item3.getId()), is(expected));
	}
	/**
	*
	*/
	@Test
	public void whenFindAll() {
		Tracker tracker = new Tracker();
		Tracker tracker2 = new Tracker();
		tracker.add(new Item("Test1", "Desc1", 1L, "1"));
		tracker.add(new Item("Test2", "Desc2", 2L, "2"));
		tracker.add(new Item("Test3", "Desc3", 3L, "3"));
		tracker2.add(tracker.findAll().get(1));
		tracker2.add(tracker.findAll().get(0));
		tracker.delete(tracker.findAll().get(1).getId());
		assertThat(tracker.findAll().size(), is(2));
	}
	/**
	*
	*/
	@Test
	public void whenFindByName() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("Test1", "Desc1", 1L, "1"));
		tracker.add(new Item("Test2", "Desc2", 2L, "2"));
		tracker.add(new Item("Test2", "Desc3", 3L, "3"));
		tracker.add(new Item("Test4", "Desc4", 4L, "4"));
		ArrayList<Item> items = tracker.findByName("Test2");
		assertThat(items.size(), is(2));
	}
	/**
	*
	*/
	@Test
	public void whenFindByIdAndNotNull() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("Test1", "Desc1", 1L, "1"));
		tracker.add(new Item("Test2", "Desc2", 2L, "2"));
		tracker.add(new Item("Test3", "Desc3", 3L, "3"));
		tracker.add(new Item("Test4", "Desc4", 4L, "4"));
		assertThat(tracker.findAll().get(3).getName(), is("Test4"));
	}
	/**
	*
	*/
	@Test
	public void whenFindByIdAndNull() {
		Tracker tracker = new Tracker();
		tracker.add(new Item("Test1", "Desc1", 1L, "1"));
		tracker.add(new Item("Test3", "Desc3", 3L, "3"));
		tracker.add(new Item("Test2", "Desc2", 2L, "2"));
		tracker.add(new Item("Test4", "Desc4", 4L, "4"));
		Tracker expected = null;
		assertThat(tracker.findById("5"), is(expected));
	}
}