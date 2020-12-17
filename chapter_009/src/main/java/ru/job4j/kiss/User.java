package ru.job4j.kiss;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Принципы Kiss, Dry и Yagni [#238813]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Comparator;

public class User {
    private int id;
    private String name;
    private int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public static Comparator<User> ageComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            return (int) (u1.getAge() - u2.getAge());
        }
    };

    public static Comparator<User> lengthNameComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            return (int) (u1.getName().length() - u2.getName().length());
        }
    };
}
