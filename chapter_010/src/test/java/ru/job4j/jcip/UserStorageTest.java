package ru.job4j.jcip;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. Класс хранилища пользователей UserStorage[1104#453906].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 3.
 */
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {
    /**
     * When Use User Storage Successful transfer.
     */
    @Test
    public void whenSuccessfulTransfer() {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        storage.add(new User(2, 200));
        assertThat(storage.toString(), is("UserStorage{userStorage={1=User{id=1, amount=100}, 2=User{id=2, amount=200}}}"));
        storage.transfer(1, 2, 50);
        assertThat(storage.toString(), is("UserStorage{userStorage={1=User{id=1, amount=50}, 2=User{id=2, amount=250}}}"));
    }
    /**
     * When Use User Storage Unsuccessful transfer.
     */
    @Test
    public void whenUnsuccessfulTransfer() {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        storage.add(new User(2, 200));
        assertThat(storage.toString(), is("UserStorage{userStorage={1=User{id=1, amount=100}, 2=User{id=2, amount=200}}}"));
        storage.transfer(1, 2, 150);
        assertThat(storage.toString(), is("UserStorage{userStorage={1=User{id=1, amount=100}, 2=User{id=2, amount=200}}}"));
    }
}
