package ru.job4j.ref;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 4. Thread без общих ресурсов[267919#453900]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserCache {
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger();

    public void add(User user) {
        users.put(id.incrementAndGet(), User.of(user.getName()));
    }

    public User findById(int id) {
        return User.of(users.get(id).getName());
    }

    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        users.values().forEach(user -> result.add(User.of(user.getName())));
        return result;
    }
}
