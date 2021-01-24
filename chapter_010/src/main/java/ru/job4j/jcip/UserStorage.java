package ru.job4j.jcip;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. Класс хранилища пользователей UserStorage[1104#453906].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Map<Integer, User> userStorage = new HashMap<>();

    public synchronized boolean add(User user) {
        this.userStorage.put(user.getId(), user);
        return true;
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        for (User u : this.userStorage.values()) {
            if (u.getId() == user.getId()) {
                u.setAmount(user.getAmount());
                result = true;
            }
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        this.userStorage.remove(user.getId());
        return true;
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        this.userStorage.remove(fromId);
        this.userStorage.replace(toId, this.userStorage.get(toId), new User(fromId, amount));
    }

    @Override
    public synchronized String toString() {
        return "UserStorage{" + "userStorage=" + userStorage + '}';
    }
}
