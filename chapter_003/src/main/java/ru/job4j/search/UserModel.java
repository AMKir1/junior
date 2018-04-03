package ru.job4j.search;

/**
 * Chapter_003. Collection. Lite.
 * Task: 1. Организовать сортировку User [#10034]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

public class UserModel implements Comparable<UserModel> {

    private String name;
    private int age;

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(UserModel o) {
        int diff = this.getAge() - o.getAge();
        return diff != 0 ? diff : 0;
    }

    @Override
    public String toString() {
        return "age = " + age + ", name = " + name;
    }
}
