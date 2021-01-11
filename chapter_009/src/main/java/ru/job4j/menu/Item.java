package ru.job4j.menu;
/*
 * Chapter_009. OOD [#143]
 * Task: Создать меню. [#4748]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.ArrayList;
import java.util.List;

public class Item implements Component {

    private String name;
    private List<Component> components = new ArrayList<>();

    public Item(String name) {
        this.name = name;
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

    /**
     * choose item.
     * @param item - item.
     * @return String.
     */
    @Override
    public String chooseItem(String item) {
        return getName().equals(item) ? "Choose: " + getName() : "";
    }
}
