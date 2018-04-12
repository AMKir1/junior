package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Chapter_003. Collection. Lite.
 * Task: Банковские переводы. [#10038]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class UserTest {
    /**
     * Получение имени пользователя.
     */
    @Test
    public void testGetName() {
        User user = new User("Petr", "0000 000000");
        assertThat(user.getName(), is("Petr"));
    }
    /**
     * Изменение, добавление имени пользователя.
     */
    @Test
    public void testSetName() {
        User user = new User("Petr", "0000 000000");
        user.setName("Osterwald");
        assertThat(user.getName(), is("Osterwald"));
    }
    /**
     * Получение номера паспорта пользователя.
     */
    @Test
    public void testGetPassport() {
        User user = new User("Petr", "0000 000000");
        assertThat(user.getPassport(), is("0000 000000"));
    }
    /**
     * Изменения паспортных данных.
     */
    @Test
    public void testSetPassport() {
        User user = new User("Petr", "0000 000000");
        user.setPassport("1234 123321");
        assertThat(user.getPassport(), is("1234 123321"));
    }
    /**
     * Проверка метода сравнения.
     */
    @Test
    public void testEquals() {
        User user = new User("Petr", "0000 000000");
        assertThat(user.getPassport().equals("0000 000000"), is(true));
    }
}
