package ru.job4j.search;

/*
 * Chapter_003. Collection. Lite.
 * Task: 2. Написать программу преобразования List в Map. [#10093]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

public class User {

    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCity(){
        return city;
    }
}
