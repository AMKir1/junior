package ru.job4j.jcip;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. Класс хранилища пользователей UserStorage[1104#453906].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 3.
 */

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private final Map<Integer, User> userStorage = new HashMap<>();

    public synchronized boolean add(User user) {
        return this.userStorage.putIfAbsent(user.getId(), user) == null;
    }

    public synchronized boolean update(User user) {
       return this.userStorage.replace(user.getId(), user) != null;
    }

    public synchronized boolean delete(User user) {
        return this.userStorage.remove(user.getId(), user);
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        User userFrom = this.userStorage.get(fromId);
        User userTo = this.userStorage.get(toId);
        if(userFrom != null && userTo != null && userFrom.getAmount() >= amount) {
            userFrom.setAmount(userFrom.getAmount() - amount);
            userTo.setAmount(userTo.getAmount() + amount);
        }
    }

    @Override
    public synchronized String toString() {
        return "UserStorage{" + "userStorage=" + userStorage + '}';
    }
}
