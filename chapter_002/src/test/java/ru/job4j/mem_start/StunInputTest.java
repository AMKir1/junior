package ru.job4j.mem_start;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;

	import org.junit.Before;
	import java.io.ByteArrayOutputStream;
	import java.io.PrintStream;
	import java.util.function.Consumer;

public class StunInputTest {
     /**
      * Байтовый поток вывода.
      * Используется для чтения и проверки вывода программы на соответствие ожидаемому.
      */
     private final ByteArrayOutputStream out = new ByteArrayOutputStream();
     private final Consumer<String> output = new Consumer<String>() {
		 private final PrintStream stdout = new PrintStream(out);

		 @Override
		 public void accept(String s) {
			 stdout.println(s);
		 }
	 };
 
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
         System.setOut(new PrintStream(this.out));
     }
 
     /**
      * Вывод программы при показе меню.
      * Вынесен в отдельную переменную для удобства использования.
      */
    private final String menu = new StringBuilder()
			  .append("0. Add the new Item").append(lineSep)
              .append("1. Show all Items").append(lineSep)
              .append("2. Edit Item").append(lineSep)
              .append("3. Delete Item").append(lineSep)
              .append("4. Find Items by Id").append(lineSep)
              .append("5. Find Items by Name").append(lineSep)
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
	public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws Exception {
	MemTracker tracker = new MemTracker(); // создаём Tracker
	Input input = new StunInput(new String[]{"0", "nameItem", "DiscItem", "y"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker, output).init(); //создаём StartUI и вызываем метод init()
	assertThat(tracker.findAll().get(0).getName(), is("nameItem")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}

	@Test
	public void whenUpdateThenTrackerHasUpdatedValue() throws Exception {
		MemTracker tracker = new MemTracker(); // создаём Tracker
    Item item = tracker.add(new Item("IUpd1", "DUpd1", 123L, "0")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"2", "0", "IUpd2", "DUpd2", "y"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker, output).init(); // создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId()).get(0).getName(), is("IUpd2")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}

	@Test
	public void whenShowAllValuesWhenNoItem() throws Exception {
		MemTracker tracker = new MemTracker(); // создаём Tracker
    tracker.add(new Item()); //Напрямую добавляем заявку
	Input input = new StunInput(new String[]{"1", "y"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker, output).init(); // создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
				 .append("NO Items").append(lineSep)
                 .toString();
	String result = new String(this.out.toByteArray());
	assertThat(result, is(expected)); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
	}
 	@Test
	public void whenDeleteItem() throws Exception {
		MemTracker tracker = new MemTracker(); // создаём Tracker
    tracker.add(new Item("I1", "D1", 123L, "0")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"3", "0", "y"}); //создаём StubInput с последовательностью действий
	int firstsize = tracker.findAll().size();
	new StartUI(input, tracker, output).init(); // создаём StartUI и вызываем метод init()
	assertThat(tracker.findAll().size(), is(firstsize - 1)); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
 
 	@Test
	public void whenFindItemById() throws Exception {
		MemTracker tracker = new MemTracker(); //создаём Tracker
    Item item = tracker.add(new Item("I1id", "D1id", 123L, "0")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"4", "0", "y"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker, output).init(); //создаём StartUI и вызываем метод init()
	assertThat(tracker.findById(item.getId()).get(0).getName(), is("I1id")); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }

 	@Test
	public void whenFindItemByIdandNoItems() throws Exception {
		MemTracker tracker = new MemTracker(); // создаём Tracker
    tracker.add(new Item("I1id", "D1id", 123L, "0")); //Напрямую добавляем заявку
	tracker.add(new Item("I1id", "D1id2", 123L, "1")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"4", "123456", "y"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker, output).init(); //создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
				 .append("NO Items").append(lineSep)
                 .toString();
	String result = new String(this.out.toByteArray());
	assertThat(result, is(expected)); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }

 	@Test
	public void whenFindItemByNameandNoItems() throws Exception {
		MemTracker tracker = new MemTracker(); // создаём Tracker
    tracker.add(new Item("I1id", "D1id", 123L, "0")); //Напрямую добавляем заявку
	tracker.add(new Item("I1id", "D1id2", 123L, "1")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"5", "I1", "y"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker, output).init(); //создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
				 .append("NO Items").append(lineSep)
                 .toString();
	String result = new String(this.out.toByteArray());
	assertThat(result, is(expected)); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }


 	@Test
	public void whenFindItemByName() throws Exception {
		MemTracker tracker = new MemTracker(); // создаём Tracker
    Item item = tracker.add(new Item("I1name", "D1name", 123L, "0")); //Напрямую добавляем заявку
	Item item2 = tracker.add(new Item("I1name", "D1name2", 123L, "1")); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"5", "I1name", "y"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker, output).init(); //создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
				 .append("It's your item:").append(lineSep)
				 .append(showItem(item))
				 .append("It's your item:").append(lineSep)
				 .append(showItem(item2))
                 .toString();
	String result = new String(this.out.toByteArray());
	assertThat(result, is(expected)); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }

 	@Test
	public void whenUserWanttoExit() throws Exception {
		MemTracker tracker = new MemTracker(); // создаём Tracker
    tracker.add(new Item()); //Напрямую добавляем заявку
    Input input = new StunInput(new String[]{"6", "y"}); //создаём StubInput с последовательностью действий
	new StartUI(input, tracker, output).init(); //создаём StartUI и вызываем метод init()
	String expected = new StringBuilder()
                 .append(this.menu)
                 .toString();
	String result = new String(this.out.toByteArray());
	assertThat(expected, is(result)); //проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
 }
}