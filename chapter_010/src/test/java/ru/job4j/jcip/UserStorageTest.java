package ru.job4j.jcip;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. Класс хранилища пользователей UserStorage[1104#453906].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    /**
     * When Use User Storage.
     */
    @Test
    public void whenUseUserStorage() {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        storage.add(new User(2, 200));
        assertThat(storage.toString(), is("UserStorage{userStorage=[User{id=1, amount=100}, User{id=2, amount=200}]}"));
        storage.transfer(1, 2, 50);
        assertThat(storage.toString(), is("UserStorage{userStorage=[User{id=1, amount=50}]}"));
    }
}
