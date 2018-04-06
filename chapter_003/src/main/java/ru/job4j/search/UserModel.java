package ru.job4j.search;

/**
 * Chapter_003. Collection. Lite.
 * Task: 2. Сортировка User с использованием Comparator [#10036]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

public class UserModel implements Comparable<UserModel> {

    private String name;
    private Integer age;

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
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
        return this.getAge() - o.getAge() == 0 ? 0 : this.age.compareTo(o.age);
    }

    @Override
    public String toString() {
        return "age = " + age + ", name = " + name;
    }
}
