package ru.job4j.ref;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 4. Thread без общих ресурсов[267919#453900]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class User {
    private int id;
    private String name;

    public static User of(String name) {
        User user = new User();
        user.name = name;
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
