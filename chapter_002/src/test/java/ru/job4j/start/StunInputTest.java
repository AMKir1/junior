package ru.job4j.start;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;

public class StunInputTest {
	@Test
	public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
	Tracker tracker = new Tracker(); // создаём Tracker
	Input input = new StunInput(new String[]{"0", "1", "1", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	assertThat(tracker.findAll()[0].getName(), is("AddItem test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}

/*	@Test
	public void whenUpdateThenTrackerHasUpdatedValue() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item()); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"2", item.getId(), "test name2", "desc", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); // создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId()).getName(), is("test name2")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 @Test
	public void whenShowAllValues() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item()); //Напрямую добавляем заявку
	Input input = new StunInput(new String[]{"0", "AddItem test name", "desctest", "1", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); // создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId()).getName(), is("AddItem test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 @Test
	public void whenDeleteItem() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item()); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"0", "test name666", "desctest", "3", item.getId(), "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); // создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId()).getName(), is("")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 @Test
	public void whenFindItemById() {
    Tracker tracker = new Tracker(); //создаём Tracker
    Item item = tracker.add(new Item()); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"0", "test name666", "desctest", "4", item.getId(), "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId()).getName(), is("test name666")); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 @Test
	public void whenFindItemByName() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item()); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"0", "test name555", "desctest", "4", item.getName(), "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	assertThat(tracker.findByName(item.getName()), is("test name555")); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 @Test
	public void whenUserWanttoExit() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item()); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"4", item.getId(), "test name", "desc", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId()).getName(), is("test name")); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 */
 
}