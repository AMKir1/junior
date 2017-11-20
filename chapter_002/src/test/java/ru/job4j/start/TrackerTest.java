package ru.job4j.start;

	import org.junit.Test;
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
		Item item1 = new Item("test1", "Description1", 123L);
		tracker.add(item1);
		assertThat(tracker.findAll()[0], is(item1));
	}
	/**
	*
	*/
	public void whenUpdateItem() {
		Tracker tracker = new Tracker();
		Item previous = new Item("test1", "testDescription", 1L);
		tracker.add(previous);
		Item next = new Item("test2", "testDescription2", 1L);
		next.setId(previous.getId());
		tracker.update(next);
		assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
	}
	/**
	*
	*/
	public void whenDeleteItem() {
		Tracker tracker = new Tracker();
		Item item3 = new Item("Test3", "Desc3", 3L);
		tracker.add(item3);
		tracker.delete(item3);
		Tracker expected = null;
		assertThat(tracker.findById(item3.getId()), is(expected));
	}
	/**
	*
	*/
	public void whenFindAll() {
		Tracker tracker = new Tracker();
		Tracker tracker2 = new Tracker();
		Item item1 = new Item("Test1", "Desc1", 1L);
		Item item2 = new Item("Test2", "Desc2", 2L);
		Item item3 = new Item("Test3", "Desc3", 3L);
		tracker.add(item1);
		tracker.add(item2);
		tracker.add(item3);
		tracker.delete(item2);
		tracker2.add(item1);
		tracker2.add(item2);
		assertThat(tracker.findAll(), is(tracker2));
	}
	/**
	*
	*/
	public void whenFindByName() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("Test1", "Desc1", 1L);
		Item item2 = new Item("Test2", "Desc2", 2L);
		Item item3 = new Item("Test3", "Desc3", 3L);
		Item item4 = new Item("Test4", "Desc4", 4L);
		tracker.add(item1);
		tracker.add(item2);
		tracker.add(item3);
		tracker.add(item4);
		assertThat(tracker.findByName("Test2"), is(item2));
	}
	/**
	*
	*/
	public void whenFindByIdAndNotNull() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("Test1", "Desc1", 1L);
		Item item2 = new Item("Test2", "Desc2", 2L);
		Item item3 = new Item("Test3", "Desc3", 3L);
		Item item4 = new Item("Test4", "Desc4", 4L);
		tracker.add(item1);
		tracker.add(item2);
		tracker.add(item3);
		tracker.add(item4);
		assertThat(tracker.findById("2"), is(item3));
	}
	/**
	*
	*/
	public void whenFindByIdAndNull() {
		Tracker tracker = new Tracker();
		Item item1 = new Item("Test1", "Desc1", 1L);
		Item item2 = new Item("Test2", "Desc2", 2L);
		Item item3 = new Item("Test3", "Desc3", 3L);
		Item item4 = new Item("Test4", "Desc4", 4L);
		tracker.add(item1);
		tracker.add(item2);
		tracker.add(item3);
		tracker.add(item4);
		Tracker expected = null;
		assertThat(tracker.findById("5"), is(expected));
	}
}