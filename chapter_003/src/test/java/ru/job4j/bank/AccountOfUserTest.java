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
public class AccountOfUserTest {
    /**
     * Проверка метода н получения данных о денежных средствах на счету.
     */
    @Test
    public void testGetValue() {
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0000");
        assertThat(acc.getValue(), is(0.0));
    }
    /**
     * Проверка теста на получение номера счета.
     */
    @Test
    public void testGetRequisites() {
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0000");
        assertThat(acc.getRequisites(), is("0000 0000 0000 0000"));
    }
    /**
     * Тест изменения суммы на счету.
     */
    @Test
    public void testSetValue() {
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0000");
        acc.setValue(100);
        assertThat(acc.getValue(), is(100.0));
    }
    /**
     * Тест добавления, изменения номера счета.
     */
    @Test
    public void testSetRequisites() {
        AccountOfUser acc = new AccountOfUser(0, "0000 0000 0000 0000");
        acc.setRequisites("1234 5678 8765 4321");
        assertThat(acc.getRequisites(), is("1234 5678 8765 4321"));
    }
}
