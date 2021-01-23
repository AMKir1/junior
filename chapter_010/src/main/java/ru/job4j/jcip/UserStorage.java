package ru.job4j.jcip;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. Класс хранилища пользователей UserStorage[1104#453906].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private List<User> userStorage;

    public UserStorage() {
        this.userStorage = new ArrayList<>();
    }

    public synchronized boolean add(User user) {
        return this.userStorage.add(user);
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        for (User u : this.userStorage) {
            if (u.getId() == user.getId()) {
                u.setAmount(user.getAmount());
                result = true;
            }
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        return this.userStorage.remove(user);
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        for (int i = 0; i < this.userStorage.size(); i++) {
            if (this.userStorage.get(i).getId() == fromId) {
                this.delete(this.userStorage.get(i));
            }
            if (this.userStorage.get(i).getId() == toId) {
                this.userStorage.get(i).setId(fromId);
                this.userStorage.get(i).setAmount(amount);
            }
        }
    }

    @Override
    public synchronized String toString() {
        return "UserStorage{" + "userStorage=" + userStorage + '}';
    }
}
