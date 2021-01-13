package ru.job4j.menu;
/*
 * Chapter_009. OOD [#143]
 * Task: Создать меню. [#4748]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
public class Action {

    private String name;

    public Action(String name) {
        this.name = name;
    }

    public String doAction() {
        return "Choose: " + this.name;
    }

}
