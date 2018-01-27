package ru.job4j.start;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	import org.junit.After;
	import org.junit.Before;
	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;
	import ru.job4j.start.*;

public class StunInputTest {
     /**
      * Байтовый поток вывода.
      * Используется для чтения и проверки вывода программы на соответствие ожидаемому.
      */
	 private final ByteArrayOutputStream byteout = new ByteArrayOutputStream();
 
     /**
      * Разделитель строк.
      * Вынесен в отдельную переменную для удобства использования.
      */
     private final String lineSep = System.lineSeparator();
	
	 /**
      * Устанавливаем новый поток вывода.
      */
	 @Before 
     public void loadByteOut() {
         System.setOut(new PrintStream(this.byteout));
     }
 
     /**
      * Вывод программы при показе меню.
      * Вынесен в отдельную переменную для удобства использования.
      */
    private final String menu = new StringBuilder()
              .append("MENU").append(lineSep)
			  .append("0. Add new Item").append(lineSep)
              .append("1. Show all items").append(lineSep)
              .append("2. Edit item").append(lineSep)
              .append("3. Delete item").append(lineSep)
              .append("4. Find item by id").append(lineSep)
              .append("5. Find item by name").append(lineSep)
              .append("6. Exit Program").append(lineSep)
			  .toString();
	
	private String showItem(Item item) {
			String result = new StringBuilder()
              .append("Name: " + item.getName()).append(lineSep)
			  .append("Description: " + item.getDescription()).append(lineSep)
			  .append("Create: " + item.getCreate()).append(lineSep)
              .append("Id: " + item.getId()).append(lineSep)
			  .toString();
			return result;
	}
	
	
	
	@Test
	public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
	Tracker tracker = new Tracker(); // создаём Tracker
	Input input = new StunInput(new String[]{"0", "nameItem", "DiscItem", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	assertThat(tracker.findAll()[0].getName(), is("nameItem")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}

	@Test
	public void whenUpdateThenTrackerHasUpdatedValue() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item("IUpd1", "DUpd1", 123L, "0")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"2", "IUpd2", "DUpd2", "0", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); // создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId())[0].getName(), is("IUpd2")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}

	@Test
	public void whenShowAllValuesWhenNoItem() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item()); //Напрямую добавляем заявку
	Input input = new StunInput(new String[]{"1", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); // создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
                 .append("All Items").append(lineSep)
				 .append("NO Items").append(lineSep)
                 .append(this.menu)
                 .append("See you later!").append(lineSep)
                 .toString();
	String result = new String(this.byteout.toByteArray());
	assertThat(result, is(expected)); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}
 @Test
	public void whenDeleteItem() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item("I1", "D1", 123L, "1")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"3", "1", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); // создаём StartUI и вызываем метод init()
	assertThat(tracker.findAll(), is(new Item[]{})); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 @Test
	public void whenFindItemById() {
    Tracker tracker = new Tracker(); //создаём Tracker
    Item item = tracker.add(new Item("I1id", "D1id", 123L, "0")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"4", "0", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId())[0].getName(), is("I1id")); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 @Test
	public void whenFindItemByIdandNoItems() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item("I1id", "D1id", 123L, "0")); //Напрямую добавляем заявку
	Item item2 = tracker.add(new Item("I1id", "D1id2", 123L, "1")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"4", "123456", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
                 .append("Find Items by Id").append(lineSep)
				 .append("NO Items").append(lineSep)
                 .append(this.menu)
                 .append("See you later!").append(lineSep)
                 .toString();
	String result = new String(this.byteout.toByteArray());
	assertThat(result, is(expected)); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 @Test
	public void whenFindItemByNameandNoItems() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item("I1id", "D1id", 123L, "0")); //Напрямую добавляем заявку
	Item item2 = tracker.add(new Item("I1id", "D1id2", 123L, "1")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"5", "I1", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
                 .append("Find Items by Name").append(lineSep)
				 .append("NO Items").append(lineSep) 
                 .append(this.menu)
                 .append("See you later!").append(lineSep)
                 .toString();
	String result = new String(this.byteout.toByteArray());
	assertThat(result, is(expected)); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }

 @Test
	public void whenFindItemByName() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item("I1name", "D1name", 123L, "0")); //Напрямую добавляем заявку
	Item item2 = tracker.add(new Item("I1name", "D1name2", 123L, "1")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"5", "I1name", "6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
                 .append("Find Items by Name").append(lineSep)
				 .append("It's your item:").append(lineSep)
				 .append(showItem(item))
				 .append("It's your item:").append(lineSep)
				 .append(showItem(item2))
                 .append(this.menu)
                 .append("See you later!").append(lineSep)
                 .toString();
	String result = new String(this.byteout.toByteArray());
	assertThat(result, is(expected)); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }

 @Test
	public void whenUserWanttoExit() {
    Tracker tracker = new Tracker(); // создаём Tracker
    Item item = tracker.add(new Item()); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"6"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
                 .append("See you later!").append(lineSep)
                 .toString();
	String result = new String(this.byteout.toByteArray());
	assertThat(expected, is(result)); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
  
}