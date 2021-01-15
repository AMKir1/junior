package ru.job4j.menu;
/*
 * Chapter_009. OOD [#143]
 * Task: Создать меню. [#4748]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
 */

public class Item implements Component {

    private String name;
    private Action action;

    public Item(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * get String Item.
     * @param level - level.
     * @return String.
     */
    @Override
    public String print(String level) {
        StringBuilder sb = new StringBuilder();
        sb.append(level).append(getName()).append(System.lineSeparator());
        return sb.toString();
    }

}
